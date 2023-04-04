package ru.faang.school.task_2.server;

public class Server {
    private double load;
    private double maxLoad;
    private double energyConsumption;

    public Server(double maxLoad, double energyConsumption, double load) {
        this.maxLoad = Math.max(0, maxLoad);
        this.energyConsumption = Math.max(0, energyConsumption);
        this.load = Math.max(0, load);
    }

    public double getLoad() {
        return load;
    }

    public void setLoad(double load) {
        this.load = load;
    }

    public double getMaxLoad() {
        return this.maxLoad;
    }

    public double getEnergyConsumption() {
        return this.energyConsumption;
    }
}
