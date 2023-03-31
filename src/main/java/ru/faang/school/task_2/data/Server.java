package ru.faang.school.task_2.data;

public class Server {
    public double load;
    public double maxLoad;
    public double energyConsumption;


    public Server(double load, double maxLoad, double energyConsumption) {
        this.load = load;
        this.maxLoad = maxLoad;
        this.energyConsumption = energyConsumption;
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

    public double getEnergyConsumption() {
        return energyConsumption;
    }
}
