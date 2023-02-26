package model;

public class Dependency {
    int dependencyId;
    int jobId;
    int userId;
    int name;

    public Dependency() {
    }

    public Dependency(int dependencyId, int jobId,int userId, int name) {
        this.dependencyId = dependencyId;
        this.jobId = jobId;
        this.name = name;
        this.userId=userId;
    }

    public int getDependencyId() {
        return dependencyId;
    }

    public void setDependencyId(int dependencyId) {
        this.dependencyId = dependencyId;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
