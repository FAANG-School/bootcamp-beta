package ru.faang.school.task_2.model;

public class Server {
    private double load;
    private double maxLoad;
    private double energyConsumption;

    public String name;

    public Server(double load, double maxLoad, double energyConsumption, String name) {
        this.load = load;
        this.maxLoad = maxLoad;
        this.energyConsumption = energyConsumption;
        this.name = name;
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

    public void setLoad(double load) {
        this.load = load;
    }

    public void addLoad(double load){
            this.load += load;
    }

    public void releaseLoad(double load){
        this.load -= load;
    }
}
