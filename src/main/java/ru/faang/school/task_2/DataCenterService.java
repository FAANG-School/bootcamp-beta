package ru.faang.school.task_2;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DataCenterService implements OptimizationStrategy{
    private double load;

    public DataCenterService(double load) {
        this.load = load;
    }

    @Override
    public void optimize(DataCenter dataCenter) {
            List<Server> overloadServers = dataCenter.getListOfServers().stream()
                    .filter(server1 -> (server1.getLoad()) > server1.getMaxLoad())
                    .collect(Collectors.toList());

            Double overLoad = overloadServers.stream()
                    .mapToDouble(server -> server.getLoad() - server.getMaxLoad())
                    .sum();

            List<Server> allAvailableServers = dataCenter.getListOfServers().stream()
                    .filter(server1 -> (server1.getLoad()) < server1.getMaxLoad())
                    .collect(Collectors.toList());

            for (Server server : allAvailableServers) {
                if (overLoad > 0) {
                    double availableLoad = server.getMaxLoad() - server.getLoad();
                    server.addLoad(Math.min(availableLoad, overLoad));
                    overLoad -= availableLoad;
                }
            }
    }

    public void setNewLoad(DataCenter dataCenter){    //распределение новой нагрузки
        Server server = dataCenter.getListOfServers().stream()
                .filter(server1 -> (server1.getLoad()+load) < server1.getMaxLoad())
                .findFirst().get();
        dataCenter.getListOfServers().remove(server);
        server.setLoad(server.getLoad() + load);
        dataCenter.getListOfServers().add(server);
    }

    public void freeLoad(DataCenter dataCenter){
        Server server = dataCenter.getListOfServers().stream()
                .max(Comparator.comparing(Server::getLoad))
                .get();
        dataCenter.getListOfServers().remove(server);
        server.setLoad(server.getLoad() + load);
        dataCenter.getListOfServers().add(server);
    }
}
