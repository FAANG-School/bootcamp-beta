package ru.faang.school.task_2;

public class Server {
    private final double COEF = 0.5;

    private double load;

    private double maxLoad;

    private double energyConsumption;

    public Server(double load, double maxLoad) {
        this.load = load;
        this.maxLoad = maxLoad;
        this.energyConsumption = calcEnergy();
    }

    public Server(double load) {
        this.load = load;
        this.maxLoad = 100.00;
        this.energyConsumption = calcEnergy();
    }

    public Server() {
    }

    public static int compareByLoad (Server s1, Server s2){
        if(s1.getLoad() > s2.getLoad())
            return 1;
        return -1;
    }

    public void setLoad(double load) {
        if (load > maxLoad){
            throw new IllegalArgumentException("Попытка установить значение load выше maxLoad");
        }
        this.load = load;
        energyConsumption = calcEnergy();
    }

    public double freeResources() {
        return maxLoad - load;
    }

    private double calcEnergy() {
        return load * COEF;
    }
    @Override
    public String toString() {
        return String.format("Состояние %.2f / %.2f\tэнергопотребление: %.2f МВт", load, maxLoad, energyConsumption);
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
}
