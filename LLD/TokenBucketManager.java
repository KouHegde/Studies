package org.example.Study.LLD;


import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class TokenBucketManager {

    private  final Map<String,TokenBucket> tokenBucketMap = new ConcurrentHashMap<>();

    private final AccountRepository accountRepository;

    public TokenBucketManager(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    boolean canGetToken(String accountId) {
        Account account = accountRepository.accountMap.get(accountId);
        if(account == null) {
            return false;
        }
        TokenBucket bucket = tokenBucketMap.computeIfAbsent(accountId, k->new TokenBucket(5,5));
        return bucket.canAcquire();
    }
}


class TokenBucket {
    int capacity;
    double refillRate;
    double tokenCount;
    long lastRefillTime;
    ReentrantLock lock = new ReentrantLock();


    public TokenBucket(int capacity, double refillRate) {
        this.capacity = capacity;
        this.refillRate = refillRate;
        this.tokenCount = capacity;
        this.lastRefillTime = System.currentTimeMillis();
    }

    public boolean canAcquire() {
        lock.lock();
        try {
            long now = System.currentTimeMillis();
            long diff = now - lastRefillTime;
            tokenCount = Math.min(capacity, tokenCount + ((double) diff / 1000) * refillRate);
            lastRefillTime = now;

            if (tokenCount >= 1.0) {
                tokenCount--;
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }finally {
            lock.unlock();
        }
    }
}

class Account{

    String accountName;
    String accountNumber;

    public Account(String accountName, String accountNumber) {
        this.accountName = accountName;
        this.accountNumber = accountNumber;
    }
}

class AccountRepository{
    Map<String,Account> accountMap = new ConcurrentHashMap<>();

    public void addAccount(String accountName, String accountNumber) {
        accountMap.put(accountName, new Account(accountName, accountNumber));
    }
}



