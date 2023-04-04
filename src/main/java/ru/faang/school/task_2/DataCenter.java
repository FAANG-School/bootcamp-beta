package ru.faang.school.task_2;

import java.util.List;

public class DataCenter {
    private List<Server> serverList;

    public DataCenter(List<Server> serverList) {
        this.serverList = serverList;
    }

    public List<Server> getServerList() {
        return serverList;
    }

    public void setServerList(List<Server> serverList) {
        this.serverList = serverList;
    }
    public void addServer(Server server) {
        serverList.add(server);
    }
    public void removeServer(Server server) {
        serverList.remove(server);
    }
}
