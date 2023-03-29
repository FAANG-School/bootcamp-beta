package ru.faang.school.task_2.solution;

public class Server {
    private Double load;
    private Double maxLoad;
    private Double energyConsumption;

    public Server(Double load, Double maxLoad, Double energyConsumption) {
        this.load = load;
        this.maxLoad = maxLoad;
        this.energyConsumption = energyConsumption;
    }

    public Double getLoad() {
        return load;
    }

    public Double getMaxLoad() {
        return maxLoad;
    }

    public Double getEnergyConsumption() {
        return energyConsumption;
    }

    public void setLoad(Double load) {
        this.load = load;
    }
}
