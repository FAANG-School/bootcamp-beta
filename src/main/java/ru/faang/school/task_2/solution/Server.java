package ru.faang.school.task_2.solution;

public class Server {
    // Не стал делать переменные final, т.к. думаю, что значения полей могут меняться, тот же load
    private Double load;
    private Double maxLoad;
    private Double energyConsumption;

    public Server(Double load, Double maxLoad, Double energyConsumption) {
        this.load = load;
        this.maxLoad = maxLoad;
        this.energyConsumption = energyConsumption;
    }


   // Геттеры
    public Double getLoad() {
        return load;
    }

    public Double getMaxLoad() {
        return maxLoad;
    }

    public Double getEnergyConsumption() {
        return energyConsumption;
    }


    // Сеттер для реализции логики.
    public void setLoad(Double load) {
        this.load = load;
    }
}
