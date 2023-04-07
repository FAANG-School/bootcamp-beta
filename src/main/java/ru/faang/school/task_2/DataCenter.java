package ru.faang.school.task_2;

import java.util.ArrayList;
import java.util.List;

public class DataCenter {
    private List<Server> servers;

    public DataCenter() {
        this.servers = new ArrayList<>();
    }

    public List<Server> getServers() {
        return servers;
    }

    public double getMaxLoadOnDataCenter(){
        return servers.stream()
                .mapToDouble(server -> server.getPossibleLoad()).sum();
    }

    @Override
    public String toString() {
        return "DataCenter{" +
                "servers=" + servers +
                '}';
    }
}
