package ru.faang.school.task_2;

import javax.xml.crypto.Data;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DataCenterService implements OptimizationStrategy, Runnable{

    //метод для экстренной ситуации, когда пошла перегрузка сервера, где его находят и снимают нагрузку
    @Override
    public void optimize(DataCenter dataCenter) {
            List<Server> overloadServers = dataCenter.getListOfServers().stream()
                    .filter(server1 -> (server1.getLoad()) > server1.getMaxLoad())
                    .collect(Collectors.toList());

            Double overLoad = overloadServers.stream()
                    .mapToDouble(server -> server.getLoad() - server.getMaxLoad())
                    .sum();

            List<Server> allAvailableServers = dataCenter.getListOfServers().stream()
                    .filter(serverOfDataCenter -> (serverOfDataCenter.getLoad()) < serverOfDataCenter.getMaxLoad())
                    .collect(Collectors.toList());

            for (Server server : allAvailableServers) {
                if (overLoad > 0) {
                    double availableLoad = server.getMaxLoad() - server.getLoad();
                    server.addLoad(Math.min(availableLoad, overLoad));
                    overLoad -= availableLoad;
                }
            }
    }
    //обычная оптимизация для периодической проверки
    public void optimization(DataCenter dataCenter){
        double loadOnAllServers = 0;
        for(Server eachServer : dataCenter.getListOfServers()){
            loadOnAllServers += eachServer.getLoad();
        }
        double loadForEachServer = loadOnAllServers/dataCenter.getListOfServers().size();
        for(Server eachServer : dataCenter.getListOfServers()) {
            eachServer.setLoad(loadForEachServer);
        }
    }

    public void allocateResources(DataCenter dataCenter, ResourceRequest request){    //распределение новой нагрузки
        Server existingServer = dataCenter.getListOfServers().stream()
                .filter(server -> (server.getLoad()+ request.getLoad()) < server.getMaxLoad())
                .findFirst().get();
        dataCenter.getListOfServers().get(dataCenter.getListOfServers().indexOf(existingServer))
                .setLoad(existingServer.getLoad() + request.getLoad());
    }

    public void releaseResources(DataCenter dataCenter, ResourceRequest request){
        Server server = dataCenter.getListOfServers().stream()
                .max(Comparator.comparing(Server::getLoad))
                .get();
        dataCenter.getListOfServers().get(dataCenter.getListOfServers().indexOf(server))
                .setLoad(server.getLoad() + request.getLoad());
    }

    public void addServer(Server server, DataCenter dataCenter){
        dataCenter.getListOfServers().add(server);
    }

    public void deleteServer(Server server, DataCenter dataCenter){
        dataCenter.getListOfServers().remove(server);
    }

    public double getTotalEnergyConsumption(DataCenter dataCenter){
        double result = dataCenter.getListOfServers().stream()
                .map(Server::getEnergyConsumption)
                .mapToDouble(cons -> cons)
                .sum();
        return result;
    }

    @Override
    public void run() {
        DataCenter dataCenter = new DataCenter(); //не понял, где взять этот дата-центр для периодической оптимизации
        while(!Thread.currentThread().isInterrupted()) {
            optimization(dataCenter);
            try {
                Thread.sleep(180000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }
}
