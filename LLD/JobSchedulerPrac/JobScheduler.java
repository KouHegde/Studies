package org.example.Study.LLD.JobSchedulerPrac;

public class JobScheduler {
    private final JobQueue jobQueue;
    private final DispatcherService dispatcherService;

    public JobScheduler(JobQueue jobQueue, DispatcherService dispatcherService) {
        this.jobQueue = jobQueue;
        this.dispatcherService = dispatcherService;
    }

    public Integer schedule(Job job){
        if (job == null || job.getExecutionTime() == null) {
            throw new RuntimeException("invalid request");
        }
        validateDestinations(job);
        try {
            return jobQueue.addJob(job);
        } catch (Exception e){
            throw  new RuntimeException("Could not add the jobs to queue");
        }
    }

    public void stop() {
        dispatcherService.stop();
    }

    private void validateDestinations(Job job) {
        if (job.getJobPriority() == JobPriority.URGENT) {
            return; // URGENT can be broadcast when no specific destination is provided.
        }

        if (job.getJobPriority() == JobPriority.NORMAL && job.getRequestedDestinationKeys().isEmpty()) {
            throw new RuntimeException("NORMAL priority job requires at least one destination");
        }
    }
}
