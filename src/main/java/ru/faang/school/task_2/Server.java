package ru.faang.school.task_2;

import java.util.Objects;

public class Server {
    static int count = 1;
    int id;
    private double load;

    private double maxLoad;

    private double energyConsumption;

    public Server(double maxLoad) {
        if (maxLoad < 20 || maxLoad > 1000) {
            throw new IllegalArgumentException("The server is too weak or too powerful.");
        }
        this.maxLoad = maxLoad;
        this.id = count++;
    }

    public double getPossibleLoad() {
        return maxLoad - load;
    }

    public double getMaxLoad() {
        return maxLoad;
    }

    public void addLoadTheServer(double load) throws IllegalArgumentException {
        if (load + this.load < maxLoad && load + this.load > 0) {
            setLoad(this.load + load);
            setEnergyConsumption(load * 5);
        } else {
            throw new IllegalArgumentException("Too much load on the server.");
        }
    }

    public double relieveLoadOnServer(double load) {
        if (load >= 0) {
            if (this.load - load > 0) {
                setLoad(this.load - load);
                setEnergyConsumption(getEnergyConsumption() - (load * 5));
                return 0;
            } else if (getLoad() == 0) {
                System.out.println("All servers are free.");
                return 0;
            } else {
                double temp = getLoad();
                double removedLoad = load - temp;
                setLoad(0);
                setEnergyConsumption(0);
                return removedLoad;
            }
        } else {
            throw new IllegalArgumentException("The load cannot be negative.");
        }
    }

    public void setLoad(double load) {
        this.load = load;
    }

    public void setEnergyConsumption(double energyConsumption) {
        this.energyConsumption = energyConsumption;
    }


    public double getLoad() {
        return load;
    }


    public void unloadServer() {
        setLoad(0);
        setEnergyConsumption(0);
    }

    public double getEnergyConsumption() {
        return energyConsumption;
    }

    @Override
    public String toString() {
        return "Server_" + id + "{" +
                "load=" + load +
                ", maxLoad=" + maxLoad +
                ", energyConsumption=" + energyConsumption +
                '}';
    }

    public boolean isEmpty() {
        return getLoad() == 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Server server = (Server) o;
        return id == server.id && Double.compare(server.load, load) == 0 && Double.compare(server.maxLoad, maxLoad) == 0 && Double.compare(server.energyConsumption, energyConsumption) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, load, maxLoad, energyConsumption);
    }
}
