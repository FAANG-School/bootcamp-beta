package ru.faang.school.task_2;

public class Server {

    private double load;                // - отражает текущую нагрузку на сервер
    private final double maxLoad;       // - отражает максимальную нагрузку на сервер
    private double energyConsumption;   // - отражает текущие энергозатраты сервера

    public Server(double load, double maxLoad, double energyConsumption) {
        this.load = load;
        this.maxLoad = maxLoad;
        this.energyConsumption = energyConsumption;
    }

    public void addLoad(double load) {
        this.load += load;
    }

    public void removeLoad(double load) {this.load -= load;}

    public double getAvailableLoad() {
        return maxLoad - load;
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
                ", energyConsumption=" + energyConsumption +
                '}';
    }
}
