package ru.faang.school.task_2.server;

public class ResourceRequest {
    private double load;

    public ResourceRequest(double load){
        this.load = load;
    }

    public double getLoad() {
        return load;
    }

    public void setLoad(double load) {
        this.load = load;
    }
}
