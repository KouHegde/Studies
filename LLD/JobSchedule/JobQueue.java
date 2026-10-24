package org.example.Study.LLD.JobSchedule;

import java.util.concurrent.DelayQueue;

public class JobQueue {

    public static final Integer SCHEDULER_CAPACITY = 25;

    private DelayQueue<Job> queue;
    private Integer capacity;

    public JobQueue() {
        queue = new DelayQueue<>();
        capacity = SCHEDULER_CAPACITY;
    }

    public DelayQueue<Job> getQueue() {
        return queue;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public Integer addJob(Job job) {
        if (queue.size() >= capacity) {
            throw new RuntimeException("Job Queue is full currently");
        }
        queue.add(job);
        return job.getJobId();
    }
}
