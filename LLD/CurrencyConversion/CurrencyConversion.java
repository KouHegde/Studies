package org.example.Study.LLD.CurrencyConversion;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class CurrencyConversion {

}


class DirectCurrencyConversion implements CurrencyConverter {

    private final RateRepository repository;

    DirectCurrencyConversion(RateRepository repository) {
        this.repository = repository;
    }


    @Override
    public <T> T convert(CurrencyConversionRequest request) {
        if(Objects.isNull(repository)) return (T) getErrorReponse(request);
        List<Rate> rates = repository.getAllRates();
        double finalAmount = 1;
        for(Rate rate :rates){
            if(request.from.equals(rate.from) && request.to.equals(rate.to)){
               finalAmount =  request.amount * rate.rate;
            }
            if(request.to.equals(rate.from) && request.from.equals(rate.to)){
                finalAmount = request.amount * (1/rate.rate);
            }
        }
        return (T) getSuccessResponse(request,finalAmount);
    }

    private CurrencyConversionResponse getSuccessResponse(CurrencyConversionRequest request, double finalAmount) {
        return new CurrencyConversionResponse(finalAmount,request.from,request.to, request.amount,null,null);
    }

    private CurrencyConversionResponse getErrorReponse(CurrencyConversionRequest request) {
        return new CurrencyConversionResponse(request.amount,request.from,request.to, request.amount,null,new RepositoryErrors("conversionRepository is null"));
    }
}

class IndirectDependencyConversion implements CurrencyConverter{
    private final RateRepository repository;
    private final ConcurrentHashMap<String,Map<String,Double>> adj;

    IndirectDependencyConversion(RateRepository repository, ConcurrentHashMap<String, Map<String, Double>> adj) {
        this.repository = repository;
        this.adj = adj = getAdjMap(repository.getAllRates());
    }
    @Override
    public CurrencyConversionResponse convert(CurrencyConversionRequest request) {
        try {
            if (Objects.isNull(repository)) throw new NullRateRepositoryException("Null repository");

            Queue<String> queue = new ArrayDeque<>();
            double finalAmount = 1;
            Map<String,Double> conversionMap = new HashMap<>();
            conversionMap.put(request.from,1.0);

            queue.add(request.from);

            while(!queue.isEmpty()){
                String curr = queue.poll();

                if(conversionMap.get(request.to) != null) {
                    finalAmount = conversionMap.get(request.to) * request.amount;
                    break;
                }

                for (Map.Entry<String ,Double> entries : adj.get(curr).entrySet()){
                    if(!conversionMap.containsKey(entries.getKey())) {
                        Double intermittetAmount = entries.getValue() * conversionMap.get(curr);
                        conversionMap.put(entries.getKey(),intermittetAmount);
                        queue.add(entries.getKey());
                    }
                }
            }

            if(!conversionMap.containsKey(request.to)) throw new RuntimeException("Conversion Can not be done");

            return new CurrencyConversionResponse(finalAmount,request.from,request.to, request.amount,conversionMap,null);


        }catch (NullRateRepositoryException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    private ConcurrentHashMap<String, Map<String, Double>> getAdjMap(List<Rate> rates) {
        ConcurrentHashMap<String,Map<String,Double>> adj = new ConcurrentHashMap<>();

        for(Rate rate :rates){
            adj.computeIfAbsent(rate.from, k -> new HashMap<>()).put(rate.to, rate.rate);
            adj.computeIfAbsent(rate.to, k -> new HashMap<>()).put(rate.from, 1/rate.rate);
        }
        return adj;
    }
}

class NullRateRepositoryException extends Exception{
    public NullRateRepositoryException(String message) {
        super(message);
    }
}

class Rate{

    String from;
    String to;
    double rate;

    public Rate(String from , String to, double rate){
        this.from = from;
        this.to = to;
        this.rate = rate;
    }
}

interface RateRepository{
    public List<Rate> getAllRates();
}

class DefaultRateRepository implements  RateRepository{

    @Override
    public List<Rate> getAllRates() {
        return List.of();
    }
}

interface CurrencyConverter{
    <T> T convert(CurrencyConversionRequest request);
}

class CurrencyConversionResponse{
    public CurrencyConversionResponse(Double finalAmount, String from, String to, Double requestAmount, Map<String, Double> conversionMap,Errors errors) {
        this.finalAmount = finalAmount;
        this.from = from;
        this.to = to;
        this.requestAmount = requestAmount;
        this.conversionMap = conversionMap;
        this.errors = errors;
    }

    Double finalAmount;
    String from;
    String to;
    Double  requestAmount;
    Map<String,Double> conversionMap;
    Errors errors;

}

class CurrencyConversionRequest{
    String from;
    String to;
    Double amount;
    Long timeStamp;

    public CurrencyConversionRequest(String from, String to,Double amount){
        this.from = from;
        this.to = to;
        this.amount = amount;
        timeStamp = System.currentTimeMillis();
    }
}

abstract class Errors{
    String errorMessage;
    public Errors(String errorMessage){
        this.errorMessage = errorMessage;
    }
}

class RepositoryErrors extends Errors{
    public RepositoryErrors(String message) {
        super(message);
    }
}



