package org.example.Study.LLD.JobSchedule;

import org.example.Study.LLD.IdRepository;

public class JobSchedulerService {

    private final JobQueue jobQueue;
    private final JobDispatcherService dispatcherService;
    private final JobExecutor jobExecutor;
    private final IdRepository idRepository;

    public JobSchedulerService(IdRepository idRepository) {
        this.idRepository = idRepository;
        this.jobQueue = new JobQueue();
        this.jobExecutor = new JobExecutor(10, jobQueue);
        this.dispatcherService = new JobDispatcherService(jobQueue, jobExecutor);

        Thread dispatcherThread = new Thread(dispatcherService, "JobDispatcherThread");
        dispatcherThread.setDaemon(true);
        dispatcherThread.start();
    }

    public Integer schedule(Job job) {
        if (job.getJobId() == null && idRepository != null) {
            job.jobId = idRepository.generateId();
        }
        return jobQueue.addJob(job);
    }

    public void stop() {
        dispatcherService.stop();
        jobExecutor.shutdown();
    }
}
