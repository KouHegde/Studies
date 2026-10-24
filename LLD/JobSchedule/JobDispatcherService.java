package org.example.Study.LLD.JobSchedule;

import java.time.LocalDateTime;

public class JobDispatcherService {

    private final JobQueue jobQueue;
    private final JobExecutor jobExecutor;
    private final Thread dispatcherThread;

    private volatile boolean isRunning;

    public JobDispatcherService(
            JobQueue jobQueue,
            JobExecutor jobExecutor) {

        this.jobQueue = jobQueue;
        this.jobExecutor = jobExecutor;

        this.dispatcherThread = new Thread(
                this::dispatchJobs,
                "job-dispatcher"
        );
    }

    public void start() {
        isRunning = true;
        dispatcherThread.start();
    }

    private void dispatchJobs() {
        while (isRunning) {
            try {
                Job job = jobQueue.getQueue().take();

                jobExecutor.execute(job);

                if (job.getJobType() == JobType.RECURRING) {
                    LocalDateTime nextExecution =
                            job.getExecutionTime()
                                    .plusMinutes(
                                            job.getRecurringIntervalMs()
                                    );

                    job.setExecutionTime(nextExecution);
                    jobQueue.addJob(job);
                }
            } catch (InterruptedException interrupted) {
                Thread.currentThread().interrupt();
                break;
            } catch (Exception exception) {
                System.err.println(
                        "Error dispatching job: "
                                + exception.getMessage()
                );
            }
        }
    }

    public void stop() {
        isRunning = false;
        dispatcherThread.interrupt();
    }
}