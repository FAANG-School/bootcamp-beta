package ru.faang.school.task_2;

public class Server {
    private double load;
    private double energyConsumption;
    private static final double MAX_LOAD = 100;
    private static final double WATT = 20;

    public Server(double load) {
        if (load < 0 || load > MAX_LOAD) {
            throw new RuntimeException("Не корректное значение");
        }
        this.load = load;
        energyConsumption = load * WATT;
    }

    public double getAvailableLoad() {
        return MAX_LOAD - load;
    }

    public boolean addLoad(double load) {
        if (load < 0) {
            throw new RuntimeException("Не корректное значение");
        }
        if (load > getAvailableLoad()) {
            System.out.println("Перегрузка");
            return false;
        } else {
            this.load += load;
            this.energyConsumption += load*WATT;
            return true;
        }
    }

    public void removeLoad(double load) {
        if (load < 0) {
            throw new RuntimeException("Не корректное значение");
        }
        if (load > this.load) {
            this.load = 0;
        } else {
            this.load -= load;
            this.energyConsumption -= load*WATT;
        }
    }

    public double getEnergyConsumption() {
        return energyConsumption;
    }

    public double getLoad() {
        return load;
    }

    @Override
    public String toString() {
        return "Server {" +
                "load=" + load +
                ", energy Consumption=" + energyConsumption +
                '}';
    }
}
