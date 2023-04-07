package ru.faang.school.task_2;

public class DataCenterService {
    private final DataCenter dataCenter;

    public DataCenterService(DataCenter dataCenter) {
        this.dataCenter = dataCenter;
    }

    public void addServer(Server server) {
        dataCenter.getServers().add(server);

    }

    public void removeServer(Server server) {
        dataCenter.getServers().remove(server);

    }

    public double getTotalEnergyConsumption(DataCenter dataCenter) {
       return dataCenter.getTotalEnergyConsumption();
    }

    public double getAverageLoad(DataCenter dataCenter) {
        return dataCenter.getAverageLoad();
    }
}
