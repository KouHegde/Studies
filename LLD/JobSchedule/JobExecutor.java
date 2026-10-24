package org.example.Study.LLD.JobSchedule;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JobExecutor {

    private final ExecutorService executorService;
    private final JobQueue jobQueue;

    public JobExecutor(int threadPoolSize, JobQueue jobQueue) {
        this.executorService = Executors.newFixedThreadPool(threadPoolSize);
        this.jobQueue = jobQueue;
    }

    public void execute(Job job) {
        executorService.submit(() -> {
            LocalDateTime startTime = LocalDateTime.now();
            try {
                System.out.println("Executing Job: " + job.getJobName() + " (ID: " + job.getJobId() + ")");

                simulateWork(job);

                LocalDateTime endTime = LocalDateTime.now();
                JobExecution execution = new JobExecution(
                        generateExecutionId(), ExecutionStatus.SUCCESS, job.getJobId(), startTime, endTime, null);
                System.out.println("Job " + job.getJobId() + " completed successfully. Execution saved.");

            } catch (Exception e) {
                LocalDateTime endTime = LocalDateTime.now();
                JobExecution execution = new JobExecution(
                        generateExecutionId(), ExecutionStatus.FAILURE, job.getJobId(), startTime, endTime,
                        e.getMessage());
                System.err.println("Job " + job.getJobId() + " failed: " + e.getMessage() + ". Execution saved.");

                if (job.getRetryCount() > 0) {
                    job.decrementRetryCount();
                    System.out
                            .println("Retrying Job " + job.getJobId() + ". Remaining retries: " + job.getRetryCount());

                    job.setExecutionTime(LocalDateTime.now().plusSeconds(5));
                    jobQueue.addJob(job);
                } else {
                    System.err.println("Job " + job.getJobId() + " exceeded max retries. Dropping.");
                }
            }
        });
    }

    private void simulateWork(Job job) throws Exception {
        System.out.println("...[Simulation] Working on " + job.getJobName());

        if (Math.random() < 0.4) {
            throw new RuntimeException("Simulated processing error!");
        }
    }

    private int generateExecutionId() {
        return (int) (System.currentTimeMillis() % Integer.MAX_VALUE);
    }

    public void shutdown() {
        executorService.shutdown();
    }
}
