package ru.faang.school.task_2;

import java.security.InvalidParameterException;

public class Server {

    private double load;                // - reflects the current server load
    private final double maxLoad;       // - reflects the maximum server load
    private double energyConsumption;   // - reflects the current power consumption of the server

    public Server(double load, double maxLoad, double energyConsumption) {
        if (load < 0 || maxLoad < 0 || energyConsumption < 0) {
            throw new InvalidParameterException("Server configuration parameters must be positive");
        }
        this.load = load;
        this.maxLoad = maxLoad;
        this.energyConsumption = energyConsumption;
    }

    public void addLoad(double load) {
        if (load < 0) {
            throw new InvalidParameterException("Parameter must be positive");
        }
        this.load += load;
    }

    public void removeLoad(double load) {
        if (load < 0) {
            throw new InvalidParameterException("Parameter must be positive");
        }
        this.load -= load;
    }

    public double getAvailableLoad() {
        return maxLoad - load;
    }

    public double getLoadCoeff() {
        return load / maxLoad;
    }

    public double getLoad() {
        return load;
    }

    public double getMaxLoad() {
        return maxLoad;
    }

    public double getEnergyConsumption() {
        return energyConsumption;
    }

    @Override
    public String toString() {
        return "Server{" +
                "load=" + load +
                ", maxLoad=" + maxLoad +
                ", loadCoeff=" + getLoadCoeff() +
                '}';
    }
}
