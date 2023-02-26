package model;

public class Job {
    private int jobId;
    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    private String name;
    public Job(){}

    public Job(int jobId, String name,int userId) {
        this.jobId = jobId;
        this.name = name;
        this.userId=userId;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
