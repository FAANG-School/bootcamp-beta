package ru.faang.school.task_2.service;

import ru.faang.school.task_2.model.DataCenter;
import ru.faang.school.task_2.strategy.OptimizationStrategy;
import ru.faang.school.task_2.ResourceRequest;
import ru.faang.school.task_2.model.Server;

import java.util.List;

public class DataCenterService{
    private DataCenter dataCenter;


    public DataCenterService(DataCenter dataCenter) {
        this.dataCenter = dataCenter;
    }

    public void addServer(Server server){
        List<Server> serverList = dataCenter.getServerList();
        serverList.add(server);
    };

    public void deleteServer(Server server){
        List<Server> serverList = dataCenter.getServerList();
        serverList.remove(server);
    }

    public List<Server> getServerList(){
        return dataCenter.getServerList();
    }

    public double getTotalEnergyConsumption(){
        double totalEnergyConsumption = 0;
        for (Server server : dataCenter.getServerList()){
            totalEnergyConsumption += server.getEnergyConsumption();
        }
        return totalEnergyConsumption;
    }

    public double getTotalLoad(){
        double totalLoad = 0;
        for (Server server : dataCenter.getServerList()){
            totalLoad += server.getLoad();
        }
        return totalLoad;
    }

    public double getTotalMaxLoad(){
        double totalMaxLoad = 0;
        for (Server server : dataCenter.getServerList()){
            totalMaxLoad += server.getMaxLoad();
        }
        return totalMaxLoad;
    }



    public void allocateResources(ResourceRequest request){
        double totalAllocate = request.getLoad();
        if (totalAllocate > getTotalMaxLoad())
            throw new IllegalArgumentException("Not enough resources for your request");

        for (Server server : dataCenter.getServerList()){
            if (totalAllocate >= server.getMaxLoad() - server.getLoad()){
                totalAllocate -= server.getMaxLoad() - server.getLoad();
                server.setLoad(server.getMaxLoad());
            } else {
                server.addLoad(totalAllocate);
                totalAllocate = 0;
            }
        }



    }

    public void releaseResources(ResourceRequest request){
        double totalRelease = request.getLoad();
        for (Server server : dataCenter.getServerList()){
            if (server.getLoad() < totalRelease){
                totalRelease -= server.getLoad();
                server.setLoad(0);
            } else {
                server.setLoad(server.getLoad()-totalRelease);
                totalRelease = 0;
            }
        }
    }

    public void optimize(OptimizationStrategy optimizationStrategy) {
        optimizationStrategy.optimize(this.dataCenter);
    }
}
