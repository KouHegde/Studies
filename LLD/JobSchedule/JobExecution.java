package org.example.Study.LLD.JobSchedule;

import java.time.LocalDateTime;

public class JobExecution {
    int executionId;
    ExecutionStatus executionStatus;
    Integer jobId;
    LocalDateTime startTime;
    LocalDateTime endTime;
    String errorMessage;

    public JobExecution(int executionId, ExecutionStatus executionStatus, Integer jobId, LocalDateTime startTime,
            LocalDateTime endTime, String errorMessage) {
        this.executionId = executionId;
        this.executionStatus = executionStatus;
        this.jobId = jobId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.errorMessage = errorMessage;
    }

    public int getExecutionId() {
        return executionId;
    }

    public ExecutionStatus getExecutionStatus() {
        return executionStatus;
    }

    public Integer getJobId() {
        return jobId;
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
}
