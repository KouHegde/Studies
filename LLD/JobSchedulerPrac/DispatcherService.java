package org.example.Study.LLD.JobSchedulerPrac;

import org.example.Study.LLD.IdRepository;

import java.time.LocalDateTime;
import java.util.List;

public class DispatcherService implements  Runnable {

    public DispatcherService(JobQueue jobQueue, IdRepository idRepository, DispatchPolicy dispatchPolicy, ExecutorRegistry executorRegistry) {
        this.jobQueue = jobQueue;
        this.idRepository = idRepository;
        this.dispatchPolicy = dispatchPolicy;
        this.executorRegistry = executorRegistry;
    }

    private final JobQueue jobQueue;
    private final IdRepository idRepository;
    private final DispatchPolicy dispatchPolicy;
    private final ExecutorRegistry executorRegistry;
    private volatile boolean isRunning = true;

    @Override
    public void run() {
        while (isRunning) {
            try {
                Job job = jobQueue.jobDelayQueue.take();
                if (job.getJobPriority() == JobPriority.NORMAL && job.getRequestedDestinationKeys().isEmpty()) {
                    System.err.println("NORMAL priority job has no destination. Skipping job: " + job.getJobId());
                    continue;
                }

                List<JobExecutor> targetExecutors = dispatchPolicy.resolveExecutors(job, executorRegistry);
                if (targetExecutors.isEmpty()) {
                    System.err.println("No destination executor found for job: " + job.getJobId());
                } else {
                    for (JobExecutor targetExecutor : targetExecutors) {
                        Job destinationScopedJob = job.withDispatchDestination(targetExecutor.getDestinationKey());
                        targetExecutor.executeJob(destinationScopedJob);
                    }
                }

                if (job.getJobType() == JobType.RECURRING) {
                    Job recurringJob = getNewRecurringJob(job);
                    jobQueue.addJob(recurringJob);
                }

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("The Dispatcher thread interrupted. Stopping.");
                break;

            } catch (RuntimeException e) {
                System.err.println("Error dispatching job: " + e.getMessage());
            }
        }
    }

    private Job getNewRecurringJob(Job job) {

        LocalDateTime nextExecutionTime = job.getExecutionTime()
                .plusHours(job.getRecurringIntervalInHours());

        return new Job(idRepository.generateId(),
                job.getJobName(),
                job.getJobType(),
                nextExecutionTime,
                (int) job.getRecurringIntervalInHours(),
                job.getRetries(),
                job.getJobPriority(),
                job.getDestinationKeys());
    }

    public void stop(){
        isRunning = false;
        executorRegistry.shutDownAll();
    }

}
