package org.example.Study.LLD.JobSchedulerPrac;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class Job implements Delayed {
    public Job(){}

    public Job(Integer jobId,
               String jobName,
               JobType jobType,
               LocalDateTime executionTime,
               int recurringIntervalInHours,
               Integer retries,
               JobPriority jobPriority,
               List<String> destinationKeys) {
        this(jobId,
                jobName,
                jobType,
                executionTime,
                recurringIntervalInHours,
                retries,
                jobPriority,
                destinationKeys,
                null);
    }

    private Job(Integer jobId,
                String jobName,
                JobType jobType,
                LocalDateTime executionTime,
                int recurringIntervalInHours,
                Integer retries,
                JobPriority jobPriority,
                List<String> destinationKeys,
                String scopedDestinationKey) {
        this.jobId = jobId;
        this.jobName = jobName;
        this.jobType = jobType;
        this.executionTime = executionTime;
        this.recurringIntervalInHours = recurringIntervalInHours;
        this.retries = retries;
        this.jobPriority = jobPriority == null ? JobPriority.NORMAL : jobPriority;
        this.destinationKeys = destinationKeys == null ? Collections.emptyList() : List.copyOf(destinationKeys);
        this.scopedDestinationKey = scopedDestinationKey;
    }

    Integer jobId;
    String jobName;
    JobType jobType;
    LocalDateTime executionTime;
    Integer retries;
    int recurringIntervalInHours;
    JobPriority jobPriority;
    List<String> destinationKeys;
    String scopedDestinationKey;

    public String getJobName() {
        return jobName;
    }

    public Integer getJobId() {
        return jobId;
    }

    public JobType getJobType() {
        return jobType;
    }

    public LocalDateTime getExecutionTime() {
        return executionTime;
    }

    public Integer getRetries() {
        return retries;
    }

    public void decrementRetry(){
        if(retries > 0){
            retries--;
        }

    }

    @Override
    public long getDelay(TimeUnit unit) {
        long millis = Duration.between(LocalDateTime.now(), executionTime).toMillis();
        return unit.convert(millis, TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        Job newJob = (Job) o;

        if(this.executionTime.isBefore(newJob.executionTime)){
            return -1;
        }
        if(this.executionTime.isAfter(newJob.executionTime)){
            return 1;
        }
        return this.jobId.compareTo(newJob.jobId);
    }

    public long getRecurringIntervalInHours() {
        return this.recurringIntervalInHours;
    }

    public JobPriority getJobPriority() {
        return jobPriority;
    }

    public List<String> getDestinationKeys() {
        return destinationKeys;
    }

    public List<String> getRequestedDestinationKeys() {
        if (scopedDestinationKey != null && !scopedDestinationKey.isBlank()) {
            return List.of(scopedDestinationKey);
        }

        return destinationKeys;
    }

    public Job withDispatchDestination(String targetDestinationKey) {
        return new Job(
                this.jobId,
                this.jobName,
                this.jobType,
                this.executionTime,
                this.recurringIntervalInHours,
                this.retries,
                this.jobPriority,
                this.destinationKeys,
                targetDestinationKey
        );
    }
}
