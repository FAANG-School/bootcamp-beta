package ru.faang.school.task_2.solution;

public class DataCenterService implements OptimizationStrategy {
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

    public Double getTotalEnergyConsumption() {
        Double totalEnergyConsumption = 0d;
        for (Server server : dataCenter.getServers())
            totalEnergyConsumption += server.getEnergyConsumption();
        return totalEnergyConsumption;
    }

    public void allocateResources(ResourceRequest request) {
        dataCenter.getServers().forEach(server -> server.setLoad(server.getLoad() - request.getLoad()));
    }

    public void releaseResources(ResourceRequest request) {
        dataCenter.getServers().forEach(server -> server.setLoad(server.getLoad() + request.getLoad()));
    }


    @Override
    public void optimize() {
        Double averageEnergyConsumption = getTotalEnergyConsumption() / dataCenter.getServers().size();
        dataCenter.getServers().stream().forEach(server -> server.setLoad(averageEnergyConsumption));
    }
}
