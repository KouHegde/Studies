package org.example.Study.LLD;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicReference;

public class CircuitBreakerWithTime {
    private static final long MINUTES_TO_TRACK = 10 * 60 * 1000;
    private  AtomicReference<State> state = new AtomicReference<>(State.CLOSE);
    LinkedBlockingDeque<Long> failureQueue = new LinkedBlockingDeque<>();
    long openedAt;
    private static final Integer CIRCUIT_BREAKER_THRESHOLD = 3;

    private final CircuitBreakerStrategy circuitBreakerStrategy;

    public CircuitBreakerWithTime(CircuitBreakerStrategy circuitBreakerStrategy) {
        this.circuitBreakerStrategy = circuitBreakerStrategy;
    }


    public boolean allowRequest(){
        checkIfHalfOpenCanBeDone();
        return State.OPEN != state.get();
    }

    public void checkIfHalfOpenCanBeDone(){
        long now = System.currentTimeMillis();
        if(circuitBreakerStrategy != null && State.OPEN == state.get() && now - openedAt >= circuitBreakerStrategy.getBackOffDuration() ){
            state.set(State.HALF_OPEN);
        }
    }

    public void recordSuccess(){
        long now = System.currentTimeMillis();
        if(State.CLOSE == state.get()){
            return;
        }
        if(State.HALF_OPEN == state.get() && now - openedAt >= MINUTES_TO_TRACK ){
            circuitClose();
        }
    }

    public void recordFailure(){
        if(State.HALF_OPEN == state.get()){
            openCircuit();
        }
        if(!failureQueue.isEmpty() && failureQueue.size() > CIRCUIT_BREAKER_THRESHOLD){
            openCircuit();
        }
    }

    private void openCircuit(){
        openedAt = System.currentTimeMillis();
        failureQueue.clear();
        state.set(State.OPEN);
    }

    public void circuitClose(){
        state.set(State.CLOSE);
        failureQueue.clear();
    }

}

interface CircuitBreakerStrategy{
    long getBackOffDuration();
}

class FixedBackOffStrategy implements CircuitBreakerStrategy{
    long backOffDurationInMilliSeconds;

    public long getBackOffDuration(){
        return backOffDurationInMilliSeconds;
    }
}

enum State{
    OPEN,CLOSE,HALF_OPEN;
}

class Service{
    public String process(){
        return new String("");
    }
}


class ServiceClient{
    private final Service service;
    private final CircuitBreakerWithTime circuitBreakerWithTime;
    private Map<String, Object>apiToResponseMap = new ConcurrentHashMap<>();

    ServiceClient(Service service, CircuitBreakerWithTime circuitBreakerWithTime) {
        this.service = service;
        this.circuitBreakerWithTime = circuitBreakerWithTime;
    }

    public Object sendRequest(String clientId){


        if(!circuitBreakerWithTime.allowRequest()){
            if(apiToResponseMap.containsKey(clientId)){
                System.out.println(apiToResponseMap.get(clientId));
                return apiToResponseMap.get(clientId);
            }
            return "Service not available";
        }
        try{
            String response = service.process();
            apiToResponseMap.put(clientId, response);
            circuitBreakerWithTime.recordSuccess();
        }catch (Exception e){
            circuitBreakerWithTime.recordFailure();
            if(apiToResponseMap.containsKey(clientId)){
                return apiToResponseMap.get(clientId);
            }
            return "Service not available";
        }
        return null;
    }
}



