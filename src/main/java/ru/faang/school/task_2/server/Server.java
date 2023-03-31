package ru.faang.school.task_2.server;

public class Server {
    private double load;
    private double maxLoad;
    private double energyConsumption;
    private ServerStatus status;
    public Server(double load, double maxLoad, double energyConsumption, ServerStatus status) {
        this.load = load;
        this.maxLoad = maxLoad;
        this.energyConsumption = energyConsumption;
        this.status = status;
    }

    public double getEnergyConsumption() {
        return energyConsumption;
    }

    public double getLoad() {
        return load;
    }

    public double getMaxLoad() {
        return maxLoad;
    }

    public void setEnergyConsumption(double energyConsumption) {
        this.energyConsumption = energyConsumption;
    }

    public void setLoad(double load) {
        this.load = load;
    }

    public void setMaxLoad(double maxLoad) {
        this.maxLoad = maxLoad;
    }

    public ServerStatus getStatus() {
        return status;
    }

    public void setStatus(ServerStatus status) {
        this.status = status;
    }

    public enum ServerStatus {
        ACTIVE,
        SLEEP,
    }
}
