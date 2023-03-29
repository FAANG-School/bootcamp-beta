package ru.faang.school.task_2.solution;

import java.util.List;

public class DataCenter {
    private final List<Server> servers;

    public DataCenter(List<Server> servers) {
        this.servers = servers;
    }

    public List<Server> getServers() {
        return servers;
    }
    
}
