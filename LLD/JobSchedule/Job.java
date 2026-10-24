package org.example.Study.LLD.JobSchedule;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class Job implements Delayed {
    Integer jobId;
    String jobName;
    JobType jobType;
    LocalDateTime executionTime;
    int retryCount;
    long recurringIntervalMs;

    public Job(Integer jobId, String jobName, JobType jobType, LocalDateTime executionTime, int retryCount,
            long recurringIntervalMs) {
        this.jobId = jobId;
        this.jobName = jobName;
        this.jobType = jobType;
        this.executionTime = executionTime;
        this.retryCount = retryCount;
        this.recurringIntervalMs = recurringIntervalMs;
    }

    public Integer getJobId() {
        return jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public JobType getJobType() {
        return jobType;
    }

    public int getRetryCount() {
        return retryCount;
    }

    public void decrementRetryCount() {
        if (this.retryCount > 0) {
            this.retryCount--;
        }
    }

    public LocalDateTime getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(LocalDateTime executionTime) {
        this.executionTime = executionTime;
    }

    public long getRecurringIntervalMs() {
        return recurringIntervalMs;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        LocalDateTime now = LocalDateTime.now();
        long diff = ChronoUnit.MILLIS.between(now, executionTime);
        return unit.convert(diff, TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        Job other = (Job) o;
        if (this.executionTime.isBefore(other.executionTime)) {
            return -1;
        }
        if (this.executionTime.isAfter(other.executionTime)) {
            return 1;
        }
        return this.jobId.compareTo(other.jobId);
    }
}
