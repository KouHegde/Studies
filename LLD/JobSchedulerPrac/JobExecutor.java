package org.example.Study.LLD.JobSchedulerPrac;

import org.example.Study.LLD.JobSchedule.ExecutionStatus;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class JobExecutor {

    private final ExecutorService executorService;
    private final JobQueue jobQueue;
    private final String destinationKey;

    public JobExecutor(int threadPoolSize, JobQueue jobQueue, String destinationKey) {
        this.executorService = Executors.newFixedThreadPool(threadPoolSize);
        this.jobQueue = jobQueue;
        this.destinationKey = destinationKey;
    }

    public Future<JobExecution> executeJob(Job job) {
        return executorService.submit(() -> {
            LocalDateTime startTime = LocalDateTime.now();

            try {
                System.out.println(
                        "Executing Job: " + job.getJobName() +
                                " (ID: " + job.getJobId() + ")"
                );

                simulateWork(job);

                LocalDateTime endTime = LocalDateTime.now();

                return new JobExecution(
                        generateExecutionId(),
                        LocalDateTime.now(),
                        ExecutionStatus.SUCCESS,
                        job.getJobId(),
                        destinationKey,
                        startTime,
                        endTime,
                        null
                );

            } catch (Exception e) {

                if (job.getRetries() > 0) {
                    jobQueue.addJob(createNewJob(job));
                }

                return new JobExecution(
                        generateExecutionId(),
                        LocalDateTime.now(),
                        ExecutionStatus.FAILURE,
                        job.getJobId(),
                        destinationKey,
                        startTime,
                        LocalDateTime.now(),
                        e.getMessage()
                );
            }
        });
    }



    private Job createNewJob(Job job) {
        job.decrementRetry();
        return new Job(
                job.getJobId(),
                job.getJobName(),
                job.getJobType(),
                LocalDateTime.now(),
                (int) job.getRecurringIntervalInHours(),
                job.getRetries(),
                job.getJobPriority(),
                job.getDestinationKeys()
        );
    }

    private int generateExecutionId() {
        return  (int) ( System.currentTimeMillis() % Integer.MAX_VALUE);
    }

    private void simulateWork(Job job) {
    }

    public void shutDown() {
        executorService.shutdown();
    }

    public String getDestinationKey() {
        return destinationKey;
    }
}
