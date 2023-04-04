package ru.faang.school.task_2.model;

import java.util.*;

public class DataCenter {
    private List<Server> serverList;

    public DataCenter() {
        serverList = new ArrayList<>();
    }

    public void addServer(Server server) {
        serverList.add(server);
    }

    public void removeServer(Server server) {
        serverList.remove(server);
    }

    public double getTotalEnergyConsumption() {
        double totalEnergy = 0;
        for (Server server : serverList) {
            totalEnergy += server.getEnergyConsumption();
        }

        return totalEnergy;
    }

    public List<Server> getServerList() {
        return serverList;
    }

    public void allocateResources(ResourceRequest request) throws RuntimeException {
        for (Server server : serverList) {
            if (server.addRequest(request)) {
                return;
            }
        }
        throw new RuntimeException("No such server to allocate request");
    }

    public void releaseResources(ResourceRequest request) throws RuntimeException {
        for (Server server : serverList) {
            if (server.removeRequest(request)) {
                return;
            }
        }
        throw new RuntimeException("Request to remove not found");
    }
}
