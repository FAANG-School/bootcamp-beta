package ru.faang.school.task_2.model;

import java.util.Objects;

public class Server {
    private  double load;
    private final double maxLoad;
    private double energyConsumption;

    public Server(double load, double maxLoad, double energyConsumption) {
        this.load = load;
        this.maxLoad = maxLoad;
        this.energyConsumption = energyConsumption;
    }

    public double getLoad() {
        return load;
    }


    public double getMaxLoad() {
        return maxLoad;
    }

    public void addLoad(double load) {
        this.load += load;
    }

    public double releaseLoad(double load) {
        return this.load -= load;
    }

    public void setLoad(double load) {
        this.load = load;
    }

    public double getEnergyConsumption() {
        return energyConsumption;
    }

    public void setEnergyConsumption(double energyConsumption) {
        this.energyConsumption = energyConsumption;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Server server = (Server) o;
        return Double.compare(server.load, load) == 0 && Double.compare(server.maxLoad, maxLoad) == 0 && Double.compare(server.energyConsumption, energyConsumption) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(load, maxLoad, energyConsumption);
    }

    @Override
    public String toString() {
        return "Server{" +
                "load=" + load +
                ", maxLoad=" + maxLoad +
                ", energyConsumption=" + energyConsumption +
                '}';
    }
}
