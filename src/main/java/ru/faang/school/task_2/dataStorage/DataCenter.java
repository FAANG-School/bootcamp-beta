package ru.faang.school.task_2.dataStorage;

import org.springframework.stereotype.Service;
import ru.faang.school.task_2.model.Server;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataCenter {
    private final List<Server> servers = new ArrayList<>();

    public List<Server> getServers() {
        return servers;
    }

    public void addServer(Server server) {
        servers.add(server);
    }
    public void removeServer(Server server) {
        servers.remove(server);
    }


}
