package ru.faang.school.task_2;

public class Server {

    double load;
    double maxLoad = 100;
    double energyConsumption=1;

    public void setMaxLoad(double maxLoad) {
        this.maxLoad = maxLoad;
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

    public void setEnergyConsumption(double energyConsumption) {
        this.energyConsumption = energyConsumption;
    }





}
