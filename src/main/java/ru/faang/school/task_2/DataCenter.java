package ru.faang.school.task_2;

import java.util.ArrayList;
import java.util.List;

public class DataCenter {

    List<Server> servers = new ArrayList<>();
// заполнил для тестирования
    {
        servers.add(new Server());
        servers.add(new Server());
        servers.add(new Server());
        servers.add(new Server());



    }

    public List<Server> getServers() {
        return servers;
    }

    public void setServers(List<Server> servers) {
        this.servers = servers;
    }

    public double allEnergyConsumption(){

        double allEnergyConsumption = servers.stream().mapToDouble(e -> e.getEnergyConsumption()).sum();

        return allEnergyConsumption;
    }

    public double maxLoadOfDataCenter(){
        return servers.stream().mapToDouble(e -> e.getMaxLoad()).sum();

    }


}
