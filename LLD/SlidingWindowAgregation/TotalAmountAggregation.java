package org.example.Study.LLD.SlidingWindowAgregation;

import java.util.concurrent.atomic.AtomicReferenceArray;

public class TotalAmountAggregation {

    private static Integer WINDOW_SIZE = 60;
    private AtomicReferenceArray<Bucket> buckets = new AtomicReferenceArray<>(WINDOW_SIZE);


    public boolean record(Transaction txn, long currentTimeStamp){
        long txnSecond = txn.timeStamp/1000;
        long currentSecond = currentTimeStamp/1000;


        if(currentSecond - txnSecond >= WINDOW_SIZE){
            return false;
        }

        int bucketIndex = (int) txnSecond % 60;

        
        while(true){
            Bucket bucket = buckets.get(bucketIndex);
            if (bucket != null && currentSecond - (bucket.timeStamp / 1000) < WINDOW_SIZE && bucket.timeStamp / 1000 != txnSecond) {
                return false;
            }
            Bucket updatedBucket = getBucket(txn, currentSecond, bucket);
            if(buckets.compareAndSet(bucketIndex,bucket,updatedBucket)){
                return true;
            }
        }
    }

    private Bucket getBucket(Transaction txn, long currentSecond, Bucket bucket) {

        if (bucket == null || currentSecond - (bucket.timeStamp / 1000) >= WINDOW_SIZE) {

            return new Bucket(txn.timeStamp, txn.amount, 1, txn.amount, txn.amount, txn.amount);
        }

        return new Bucket(bucket.timeStamp, bucket.sum + txn.amount, bucket.count + 1, (bucket.sum + txn.amount) / (bucket.count + 1), Math.min(bucket.min, txn.amount), Math.max(bucket.max, txn.amount));
    }

    public Statistics getStatisticsForLastMinute(long currentTime) {

        long currentSecond = currentTime / 1000;
        Statistics stats = new Statistics();

        for (int i = 0; i < WINDOW_SIZE; i++) {

            Bucket bucket = buckets.get(i);

            if (bucket == null) {
                continue;
            }

            if (currentSecond - (bucket.timeStamp / 1000) >= WINDOW_SIZE) {
                continue;
            }

            stats.count += bucket.count;
            stats.sum += bucket.sum;
            stats.max = Math.max(stats.max, bucket.max);
            stats.min = Math.min(stats.min, bucket.min);
        }

        if (stats.count > 0) {
            stats.average = stats.sum / stats.count;
        } else {
            stats.max = 0.0;
            stats.min = 0.0;
        }

        return stats;
    }

}

class Bucket{
    public long getTimeStamp() {
        return timeStamp;
    }

    public Double getSum() {
        return sum;
    }

    public Integer getCount() {
        return count;
    }

    public Double getAverage() {
        return average;
    }

    public Double getMin() {
        return min;
    }

    public Double getMax() {
        return max;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public void setAverage(Double average) {
        this.average = average;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public void setMin(Double min) {
        this.min = min;
    }

    public void setMax(Double max) {
        this.max = max;
    }

    long timeStamp;
    Double sum;
    Integer count;
    Double average;
    Double min = Double.MAX_VALUE;
    Double max = Double.MIN_VALUE;

    public Bucket(long timeStamp, Double sum, Integer count, Double average, Double min, Double max) {
        this.timeStamp = timeStamp;
        this.sum = sum;
        this.count = count;
        this.average = average;
        this.min = min;
        this.max = max;
    }

  

    public boolean isExpired(long current ){
        return current - timeStamp  >= 60;
    }
}

class Statistics{
    Double sum;
    Integer count;
    Double average;
    Double min = Double.MAX_VALUE;
    Double max = Double.MIN_VALUE;

    public Statistics() {
        this.sum = 0.0;
        this.count = 0;
        this.average = 0.0;
    }
}

final class Transaction{
    public Transaction(long timeStamp, Double amount) {
        this.timeStamp = timeStamp;
        this.amount = amount;
    }

    long timeStamp;
    Double amount;
}
