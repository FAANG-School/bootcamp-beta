package ru.faang.school.task_2;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class DataCenter {

    private final List<Server> servers;

    public DataCenter() {
        this.servers = new LinkedList<>();
    }

    public boolean saveServer(Server server) {
        return servers.add(server);
    }

    public boolean removeServer(Server server) {
        return servers.remove(server);
    }

    public List<Double> getEnergyConsumptionValue() {
        return servers.stream().map(Server::getEnergyConsumption).collect(Collectors.toList());
    }

    public Server getAvailableServer(double load) {
        for (Server server : servers) {
            if (server.getAvailableLoad() >= load) {
                server.addLoad(load);
                return server;
            }
        }
        return null;
    }

    public void releaseResources(double load, Server server) {
        servers.get(servers.indexOf(server)).removeLoad(load);
    }
}
