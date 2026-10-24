package org.example.Study.LLD.JobSchedulerPrac;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class PriorityDispatchPolicy implements DispatchPolicy {
    @Override
    public List<JobExecutor> resolveExecutors(Job job, ExecutorRegistry executorRegistry) {
        if (job == null) {
            return Collections.emptyList();
        }

        List<String> requestedDestinationKeys = job.getRequestedDestinationKeys();

        if (!requestedDestinationKeys.isEmpty()) {
            Set<JobExecutor> resolvedExecutors = new LinkedHashSet<>();
            for (String destinationKey : requestedDestinationKeys) {
                JobExecutor selectedExecutor = executorRegistry.getByDestination(destinationKey);
                if (selectedExecutor != null) {
                    resolvedExecutors.add(selectedExecutor);
                }
            }
            return List.copyOf(resolvedExecutors);
        }

        if (job.getJobPriority() == JobPriority.URGENT) {
            return executorRegistry.getAll();
        }

        return Collections.emptyList();
    }
}
