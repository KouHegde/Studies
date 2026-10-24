package org.example.Study.LLD;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class IdRepository {


    private final AtomicInteger lastId = new AtomicInteger(0);
    private final Map<Integer, String> idToTaskMap = new ConcurrentHashMap<>();

    public int generateId() {
        return lastId.incrementAndGet();
    }

    public void save(int id, String task) {
        idToTaskMap.put(id, task);
    }

    public String get(int id) {
        return idToTaskMap.get(id);
    }


}
