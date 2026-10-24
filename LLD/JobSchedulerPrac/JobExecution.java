package org.example.Study.LLD.JobSchedulerPrac;

import org.example.Study.LLD.JobSchedule.ExecutionStatus;

import java.time.LocalDateTime;

public class JobExecution {
    public JobExecution(Integer executionId, LocalDateTime lastExecutionTime, ExecutionStatus executionStatus, Integer jobId, String destinationKey, LocalDateTime startTime, LocalDateTime endTime, String errorMessage) {
        this.executionId = executionId;
        this.lastExecutionTime = lastExecutionTime;
        this.executionStatus = executionStatus;
        this.jobId = jobId;
        this.destinationKey = destinationKey;
        this.startTime = startTime;
        this.endTime = endTime;
        this.errorMessage = errorMessage;
    }

    Integer executionId;

    public LocalDateTime getLastExecutionTime() {
        return lastExecutionTime;
    }

    public Integer getExecutionId() {
        return executionId;
    }

    public ExecutionStatus getExecutionStatus() {
        return executionStatus;
    }

    public Integer getJobId() {
        return jobId;
    }

    public String getDestinationKey() {
        return destinationKey;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    LocalDateTime lastExecutionTime;
    ExecutionStatus executionStatus;
    Integer jobId;
    String destinationKey;
    LocalDateTime startTime;
    LocalDateTime endTime;
    String errorMessage;
}
