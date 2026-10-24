package org.example.Study.LLD.TokenManager;

import java.time.Clock;
import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class TokenManager{

}

interface TokenClient {
    Token fetchToken(String clientId);
}


final class Token {

    private final String value;
    private final Instant expiresAt;

    private Token(String value, Instant expiresAt) {
        this.value = value;
        this.expiresAt = expiresAt;
    }

    public String getValue() {
        return value;
    }

    public boolean isExpired(Clock clock, long refreshBufferSeconds) {
        return expiresAt.isBefore(clock.instant().plusSeconds(refreshBufferSeconds));
    }
}

class TokenManagerImpl {

    private final TokenClient tokenClient;
    private final Clock clock;
    private final long refreshBufferSeconds;

    private final Map<String, Token> cache = new ConcurrentHashMap<>();

    public TokenManagerImpl(TokenClient tokenClient,
                            Clock clock,
                            long refreshBufferSeconds) {

        this.tokenClient = tokenClient;
        this.clock = clock;
        this.refreshBufferSeconds = refreshBufferSeconds;
    }


    public Token getToken(String clientId) {

        return cache.compute(clientId, (key, existingToken) -> {

            if (existingToken != null && !existingToken.isExpired(clock, refreshBufferSeconds)) {
                return existingToken;
            }

            return tokenClient.fetchToken(clientId);

        });
    }


    public void invalidate(String clientId) {
        cache.remove(clientId);
    }
}