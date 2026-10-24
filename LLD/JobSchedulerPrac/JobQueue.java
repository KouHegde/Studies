package org.example.Study.LLD.JobSchedulerPrac;

import java.util.concurrent.DelayQueue;

public class JobQueue {

    public JobQueue() {
        this.capacity = 25;
        this.jobDelayQueue = new DelayQueue<>();
    }

    int capacity;
    DelayQueue<Job> jobDelayQueue;

    public int addJob(Job job){
        if(jobDelayQueue.size() >= capacity){
            throw new RuntimeException("queue overflow");
        }
        jobDelayQueue.add(job);
        return job.jobId;
    }

}
