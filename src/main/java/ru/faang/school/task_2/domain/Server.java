package ru.faang.school.task_2.domain;

public class Server {

    private double load;
    private double maxLoad;
    private double energyConsumption;

    public Server(double load, double maxLoad, double energyConsumption) {
        this.load = load;
        this.maxLoad = maxLoad;
        this.energyConsumption = energyConsumption;
    }

    @Override
    public String toString() {
        return "Server{" +
                "load=" + load +
                ", maxLoad=" + maxLoad +
                ", energyConsumption=" + energyConsumption +
                '}';
    }

    public void increaseLoad(double load) {
        this.load += load;
    }

    public void reduceLoad(double load) {
        if(this.load < load) {
            this.load = 0;
        }
        this.load -= load;
    }

    public double getLoad() {
        return load;
    }

    public void setLoad(double load) {
        this.load = load;
    }

    public double getMaxLoad() {
        return maxLoad;
    }

    public void setMaxLoad(double maxLoad) {
        this.maxLoad = maxLoad;
    }

    public double getEnergyConsumption() {
        return energyConsumption;
    }

    public void setEnergyConsumption(double energyConsumption) {
        this.energyConsumption = energyConsumption;
    }
}
