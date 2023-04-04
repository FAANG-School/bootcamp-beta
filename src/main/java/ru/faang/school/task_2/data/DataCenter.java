package ru.faang.school.task_2.data;

import java.util.ArrayList;
import java.util.List;

public class DataCenter {
    public List<Server> servers = new ArrayList<>();

    public DataCenter(){}


    public List<Server> getServers() {
        return servers;
    }
}
