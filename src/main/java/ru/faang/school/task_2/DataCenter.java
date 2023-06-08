package ru.faang.school.task_2;

import java.util.ArrayList;
import java.util.List;

public class DataCenter {
    private List<Server> servers = new ArrayList<>();

    public List<Server> getListOfServers() {
        return servers;
    }

    public void setListOfServers(List<Server> listOfServers) {
        this.servers = listOfServers;
    }
    public void addServer(Server server){
        servers.add(server);
    }
    public void deleteServer(Server server){
        servers.remove(server);
    }
}
