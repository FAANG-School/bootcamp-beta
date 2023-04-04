package ru.faang.school.task_2;

import java.util.List;

public class DataCenterService {
    private DataCenter dataCenter;

    public DataCenterService(DataCenter dataCenter) {
        this.dataCenter = dataCenter;
    }

    public DataCenter getDataCenter() {
        return dataCenter;
    }

    public void setDataCenter(DataCenter dataCenter) {
        this.dataCenter = dataCenter;
    }
    public void addServer(Server server) {
        dataCenter.addServer(server);
    }
    public void removeServer(Server server) {
        dataCenter.getServerList().remove(server);
    }
    public void removeServer(int index) {
        dataCenter.getServerList().remove(index);
    }
    public List<Server> getServerList() {
        return dataCenter.getServerList();
    }
    public double getTotalEnergyConsumption() {
        return dataCenter.getServerList().stream().mapToDouble(Server::getEnergyConsumption).sum();
    }
    public double getTotalMaxLoad() {
        return dataCenter.getServerList().stream().mapToDouble(Server::getMaxLoad).sum();
    }

    public void releaseResources(ResourceRequest request) {
        double totalRelease = request.getLoad();
        for (Server server : dataCenter.getServerList()) {
            if (totalRelease==0) {
                break;
            }
            if (server.getLoad() < totalRelease) {
                totalRelease -= server.getLoad();
                server.setLoad(0);
            }
            else {
                server.setLoad(server.getLoad() - totalRelease);
                totalRelease = 0;
            }
        }
    }
    public void allocateResources(ResourceRequest request) {
        double totalAllocate = request.getLoad();
        if (totalAllocate > getTotalMaxLoad())
            throw new IllegalArgumentException("Not enough resources for your request");

        for (Server server : dataCenter.getServerList()) {
            if (totalAllocate >= server.getMaxLoad() - server.getLoad()) {
                totalAllocate -= server.getMaxLoad() - server.getLoad();
                server.setLoad(server.getMaxLoad());
            } else {
                server.addLoad(totalAllocate);
                totalAllocate = 0;
            }
        }
    }
    public void optimize(OptimizationStrategy strategy) {
        strategy.optimize(dataCenter);
    }
}
