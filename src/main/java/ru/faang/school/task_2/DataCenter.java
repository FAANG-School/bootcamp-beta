package ru.faang.school.task_2;

import org.w3c.dom.ls.LSOutput;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

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

    public Stream<Double> getEnergyConsumptionStream() {
        return servers.stream().map(Server::getEnergyConsumption);
    }

    public void releaseResources(double load) {
        double reminderLoad = load;
        for (Server server : servers) {
            if (server.getLoad() >= reminderLoad) {
                server.removeLoad(reminderLoad);
                return;
            } else {
                reminderLoad -= server.getLoad();
                server.removeLoad(server.getLoad());
            }
        }
    }

    public boolean allocateResources(double load) {
        double reminderLoad = load;
        for (Server server : servers) {
            if (server.getAvailableLoad() >= reminderLoad) {
                server.addLoad(reminderLoad);
                return true;
            } else {
                reminderLoad -= server.getAvailableLoad();
                server.addLoad(server.getAvailableLoad());
            }
        }
        return reminderLoad <= 0;
    }

    public List<Server> getServers() {
        return servers;
    }

    public int getServersCount() {
        return servers.size();
    }
}
