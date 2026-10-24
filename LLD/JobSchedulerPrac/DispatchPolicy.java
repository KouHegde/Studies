package org.example.Study.LLD.JobSchedulerPrac;

import java.util.List;

public interface DispatchPolicy {
    List<JobExecutor> resolveExecutors(Job job, ExecutorRegistry executorRegistry);
}
