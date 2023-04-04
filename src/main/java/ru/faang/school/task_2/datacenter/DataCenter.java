package ru.faang.school.task_2.datacenter;

import ru.faang.school.task_2.server.Server;

import java.util.ArrayList;
import java.util.List;

public class DataCenter {
    private List<Server> servers;

    public DataCenter() {
        this.servers = new ArrayList<>();
    }

    public List<Server> getServers() {
        return this.servers;
    }

    public void addServer(Server server) {
        this.servers.add(server);
    }

    public void removeServer(Server server) {
        this.servers.remove(server);
    }
}
