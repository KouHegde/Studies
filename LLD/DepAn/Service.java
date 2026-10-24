package org.example.Study.LLD.DepAn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Thread-safe service that grants tokens from one shared pool.
 *
 * <p>All changes to the pool and grant bookkeeping are protected by the same
 * lock, so a request, release, or expiry is applied atomically.</p>
 */
public final class TokenGrantService implements AutoCloseable {
    private static final long GRANT_DURATION_MILLIS = TimeUnit.HOURS.toMillis(1);
    private static final int UNLIMITED = Integer.MAX_VALUE;

    private final ReentrantLock stateLock = new ReentrantLock();
    private final Bucket bucket;
    private final Map<String, Grant> grantsById = new HashMap<>();
    private final Map<String, Integer> heldCountByUser = new HashMap<>();
    private final Map<String, Integer> limitByUser = new HashMap<>();
    private final DelayQueue<Grant> expiryQueue = new DelayQueue<>();
    private final Thread sweeperThread;

    private volatile boolean running = true;

    public TokenGrantService(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("capacity must be non-negative");
        }

        bucket = new Bucket(capacity);
        sweeperThread = new Thread(this::sweepExpiredGrants, "token-grant-sweeper");
        sweeperThread.setDaemon(true);
        sweeperThread.start();
    }

    public void setUserLimit(String userId, int limit) {
        requireUserId(userId);
        if (limit < 0) {
            throw new IllegalArgumentException("limit must be non-negative");
        }

        stateLock.lock();
        try {
            ensureRunning();
            limitByUser.put(userId, limit);
        } finally {
            stateLock.unlock();
        }
    }

    /**
     * Returns a grant ID, or {@code null} if the request cannot be satisfied.
     */
    public String requestTokens(String userId, int tokenCount) {
        // Fail fast before acquiring the lock or touching shared state.
        requireUserId(userId);
        if (tokenCount <= 0) {
            throw new IllegalArgumentException("tokenCount must be greater than zero");
        }

        stateLock.lock();
        try {
            ensureRunning();

            int heldCount = heldCountByUser.getOrDefault(userId, 0);
            int userLimit = limitByUser.getOrDefault(userId, UNLIMITED);

            // Fail before removing tokens. This form also avoids addition overflow.
            if (tokenCount > userLimit - heldCount
                    || tokenCount > bucket.availableCount()) {
                return null;
            }

            long assignedAt = System.currentTimeMillis();
            List<Token> tokens = bucket.take(tokenCount);
            for (Token token : tokens) {
                token.assignTo(userId, assignedAt);
            }

            String grantId = UUID.randomUUID().toString();
            Grant grant = new Grant(
                    grantId,
                    userId,
                    tokens,
                    assignedAt + GRANT_DURATION_MILLIS);

            grantsById.put(grantId, grant);
            heldCountByUser.put(userId, heldCount + tokenCount);
            expiryQueue.offer(grant);
            return grantId;
        } finally {
            stateLock.unlock();
            while (running) {
                try {
                    Grant grant = expiryQueue.take();

                    stateLock.lock();
                    try {
                        if (grant.active) {
                            releaseGrant(grant);
                        }
                    } finally {
                        stateLock.unlock();
                    }
                } catch (InterruptedException interrupted) {
                    if (!running) {
                        return;
                    }
                    // A stray interrupt should not permanently disable expiration.
                }
            }
        }

        /** Must be called while {@link #stateLock} is held. */
        private void releaseGrant(Grant grant) {
            // Mark inactive first, making release idempotent for all callers.
            grant.active = false;
            grantsById.remove(grant.grantId);

            int remaining = heldCountByUser.getOrDefault(grant.userId, 0)
                    - grant.tokens.size();
            if (remaining == 0) {
                heldCountByUser.remove(grant.userId);
            } else {
                heldCountByUser.put(grant.userId, remaining);
            }

            bucket.giveBack(grant.tokens);
        }

        public void shutdown() {
            stateLock.lock();
            try {
                if (!running) {
                    return;
                }

                running = false;

                // Reclaim every outstanding grant now that expiry processing stops.
                for (Grant grant : new ArrayList<>(grantsById.values())) {
                    if (grant.active) {
                        releaseGrant(grant);
                    }
                }
                expiryQueue.clear();
            } finally {
                stateLock.unlock();
            }

            // Wake the sweeper if it is blocked in DelayQueue.take().
            sweeperThread.interrupt();
        }

        @Override
        public void close() {
            shutdown();
        }

        private void ensureRunning() {
            if (!running) {
                throw new IllegalStateException("service has been shut down");
            }
        }

        private static void requireUserId(String userId) {
            if (userId == null || userId.isBlank()) {
                throw new IllegalArgumentException("userId must not be blank");
            }
        }

        private static final class Token {
            private final int number;
            private String assignedUserId;
            private long assignedAt;

            private Token(int number) {
                this.number = number;
            }

            private void assignTo(String userId, long time) {
                assignedUserId = userId;
                assignedAt = time;
            }

            private void clearAssignment() {
                assignedUserId = null;
                assignedAt = 0L;
            }
        }

        private static final class Grant implements Delayed {
            private final String grantId;
            private final String userId;
            private final List<Token> tokens;
            private final long expiryTimeMillis;
            private boolean active = true;

            private Grant(
                    String grantId,
                    String userId,
                    List<Token> tokens,
                    long expiryTimeMillis) {
                this.grantId = grantId;
                this.userId = userId;
                this.tokens = List.copyOf(tokens);
                this.expiryTimeMillis = expiryTimeMillis;
            }

            @Override
            public long getDelay(TimeUnit unit) {
                long remainingMillis = expiryTimeMillis - System.currentTimeMillis();
                return unit.convert(remainingMillis, TimeUnit.MILLISECONDS);
            }

            @Override
            public int compareTo(Delayed other) {
                if (other == this) {
                    return 0;
                }
                return Long.compare(
                        expiryTimeMillis,
                        ((Grant) other).expiryTimeMillis);
            }
        }

        /** Not independently synchronized; callers hold the service state lock. */
        private static final class Bucket {
            private final Deque<Token> availableTokens = new ArrayDeque<>();

            private Bucket(int capacity) {
                for (int number = 0; number < capacity; number++) {
                    availableTokens.addLast(new Token(number));
                }
            }

            private List<Token> take(int count) {
                List<Token> taken = new ArrayList<>(count);
                for (int i = 0; i < count; i++) {
                    taken.add(availableTokens.removeFirst());
                }
                return taken;
            }

            private void giveBack(List<Token> tokens) {
                for (Token token : tokens) {
                    token.clearAssignment();
                    availableTokens.addLast(token);
                }
            }

            private int availableCount() {
                return availableTokens.size();
            }
        }
    }