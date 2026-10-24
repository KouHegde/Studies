package org.example.Study.LLD.CircuitBreaker;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;

public class CircuitBreaker {

    private final int failureThreshold;
    private final int halfOpenThreshold;
    private final BackOffStrategy backOffStrategy;


    public CircuitBreaker(int failureThreshold, int halfOpenThreshold, BackOffStrategy backOffStrategy) {
        if(halfOpenThreshold <= 0 || failureThreshold <= 0){
            throw new IllegalArgumentException("Thresholds must be positive");
        }
        this.failureThreshold = failureThreshold;
        this.halfOpenThreshold = halfOpenThreshold;
        this.backOffStrategy = backOffStrategy;
    }

    private final AtomicReference<State> state = new AtomicReference<>(State.CLOSED);
    private final AtomicInteger continuousFailure = new AtomicInteger(0);
    private final AtomicInteger halfOpen = new AtomicInteger(0);
    private volatile long openedAt = 0L;

    public <T> T execute(Supplier<T> call) {
        transitFromOpenIfReady();

        if (state.get().equals(State.OPEN)) {
            throw new CircuitOpenException("The circuit is open rejecting the call");
        }

        try {
            T result = call.get();
            onSuccess();
            return result;
        } catch(RuntimeException e){
            onFailure();
            throw e;
        }
    }

    public void transitFromOpenIfReady(){
        if(state.get() == State.CLOSED){
            return;
        }
        if(state.get().equals(State.OPEN) && System.currentTimeMillis() - openedAt >= backOffStrategy.openDurationInMilliSeconds()){
                state.set(State.HALF_OPEN);
                halfOpen.set(0);
        }
    }

    private void onSuccess() {
        State currentState = state.get();
        if(currentState.equals(State.HALF_OPEN) && halfOpen.incrementAndGet() >= halfOpenThreshold){
            closeCircuit();
        } else if(State.CLOSED.equals(currentState)){
            continuousFailure.set(0);
        }
    }

    private void onFailure(){
        State currentState = state.get();
        if(currentState.equals(State.HALF_OPEN) ||(currentState.equals(State.CLOSED) && continuousFailure.incrementAndGet() >= failureThreshold) ){
            openCircuit();
        }
    }

    private void openCircuit(){
        state.set(State.OPEN);
        openedAt = System.currentTimeMillis();
        continuousFailure.set(0);
    }

    private void closeCircuit(){
        state.set(State.CLOSED);
        continuousFailure.set(0);
        halfOpen.set(0);
    }
}

enum State{
    CLOSED, OPEN, HALF_OPEN;
}

interface BackOffStrategy{
    long openDurationInMilliSeconds();
}

class FixedBackOff implements  BackOffStrategy{

    private final long millis;

    public FixedBackOff(long millis) {
        this.millis = millis;
    }

    @Override
    public long openDurationInMilliSeconds() {
        return  millis;
    }
}

class CircuitOpenException extends RuntimeException{
    public CircuitOpenException(String message){
        super(message);
    }
}
