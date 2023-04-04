package ru.faang.school.task_2.domain;

import java.util.List;
import java.util.Map;

public class DataCenter {

    private Map<Server, List<ResourceRequest>> servers;

    public DataCenter(Map<Server, List<ResourceRequest>> servers) {
        this.servers = servers;
    }

    public DataCenter() {

    }

    public Map<Server, List<ResourceRequest>> getServers() {
        return servers;
    }

    public void setServers(Map<Server, List<ResourceRequest>> servers) {
        this.servers = servers;
    }
}
