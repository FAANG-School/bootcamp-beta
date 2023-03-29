package ru.faang.school.task_2.solution;

import java.util.List;

public class DataCenter {
    private final List<Server> servers; // список для хранения серверов

    public DataCenter(List<Server> servers) {
        this.servers = servers;
    }

    // Геттер для получения списка серверов
    public List<Server> getServers() {
        return servers;
    }
    
}
