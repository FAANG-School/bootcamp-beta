package ru.faang.school.task_2.data;

import ru.faang.school.task_2.server.Server;

import java.util.Set;

public class DataCenter {
    private final Set<Server> servers;
    public DataCenter(Set<Server> servers) {
        this.servers = servers;
    }

    public Set<Server> getServers() {
        return servers;
    }
}
