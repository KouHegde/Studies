package org.example.Study.LLD.JobSchedule;

public enum JobType {
    ONE_TIME("ONE_TIME"), RECURRING("RECURRING");
    String name;

    JobType(String name) {
        this.name = name;
    }
}
