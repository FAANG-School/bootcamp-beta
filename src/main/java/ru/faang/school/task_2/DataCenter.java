package ru.faang.school.task_2;

import java.util.Comparator;
import java.util.List;

public class DataCenter {

    private final List<Server> servers;

    public DataCenter(List<Server> servers) {
        this.servers = servers;
    }

    public void addServer(Server server) {
        servers.add(server);
    }

    public boolean removeServer(Server server) {
        return servers.remove(server);
    }

    public double getDataCenterEnergyConsumption() {
        return servers.stream()
                .map(Server::getEnergyConsumption)
                .reduce(Double::sum)
                .orElse(0.);
    }

    public double getTotalFreeLoad() {
        return servers.stream()
                .map(s -> s.getMaxLoad() - s.getLoad())
                .reduce(Double::sum)
                .orElse(0.);
    }

    public boolean allocateResources(ResourceRequest resourceRequest) {
        if (getTotalFreeLoad() < resourceRequest.getLoad()) {
            return false;
        }
        for (Server server : servers) {
            if (resourceRequest.getLoad() + server.getLoad() <= server.getMaxLoad()) {
                server.setLoad(server.getLoad() + resourceRequest.getLoad());
                return true;
            }
            server.setLoad(server.getMaxLoad());
            resourceRequest.setLoad(resourceRequest.getLoad() - (server.getMaxLoad() - server.getLoad()));
        }
        return false;
    }

    public double getTotalLoad() {
        return servers.stream()
                .map(Server::getLoad)
                .reduce(Double::sum)
                .orElse(0.);
    }

    public boolean releaseResources(ResourceRequest resourceRequest) {
        if (getTotalLoad() < resourceRequest.getLoad()) {
            return false;
        }
        for (Server server : servers) {
            if (server.getLoad() - resourceRequest.getLoad() >= 0) {
                server.setLoad(server.getLoad() - resourceRequest.getLoad());
                return true;
            }
            resourceRequest.setLoad(resourceRequest.getLoad() - server.getLoad());
            server.setLoad(0.);
        }
        return false;
    }

    public int getCountServers() {
        return servers.size();
    }

    public void rebalanceLoad(double averageLoad) {
        servers.forEach(server -> server.setLoad(averageLoad));
    }

    public void rebalanceEnergyEfficiency() {
        servers.sort(Comparator.comparing(Server::getEnergyEfficiency));
        double totalLoad = getTotalLoad();
        for (Server server : servers) {
            if (totalLoad - server.getMaxLoad() > 0) {
                totalLoad -= server.getMaxLoad();
                server.setLoad(server.getMaxLoad());
                continue;
            }
            server.setLoad(totalLoad);
            totalLoad = 0;
        }
    }

    @Override
    public String toString() {
        return servers.toString();
    }
}
