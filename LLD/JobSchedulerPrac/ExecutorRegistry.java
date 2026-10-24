package org.example.Study.LLD.JobSchedulerPrac;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ExecutorRegistry {
    private final Map<String, JobExecutor> executorsByDestination = new LinkedHashMap<>();

    public void register(String destinationKey, JobExecutor jobExecutor) {
        if (destinationKey == null || destinationKey.isBlank()) {
            throw new IllegalArgumentException("Destination key cannot be null/blank");
        }
        if (jobExecutor == null) {
            throw new IllegalArgumentException("Job executor cannot be null");
        }
        executorsByDestination.put(destinationKey, jobExecutor);
    }

    public JobExecutor getByDestination(String destinationKey) {
        if (destinationKey == null || destinationKey.isBlank()) {
            return null;
        }
        return executorsByDestination.get(destinationKey);
    }

    public List<JobExecutor> getAll() {
        return new ArrayList<>(executorsByDestination.values());
    }

    public void shutDownAll() {
        for (JobExecutor jobExecutor : executorsByDestination.values()) {
            jobExecutor.shutDown();
        }
    }
}
