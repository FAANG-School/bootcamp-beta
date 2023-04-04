package ru.faang.school.task_2.service;

import ru.faang.school.task_2.data.DataCenter;
import ru.faang.school.task_2.data.ResourceRequest;
import ru.faang.school.task_2.data.Server;
import ru.faang.school.task_2.optimization.LoadBalancingOptimizationStraregy;
import ru.faang.school.task_2.optimization.OptimizationStrategy;

public class DataCenterService {
    DataCenter dataCenter;
    OptimizationStrategy optimizationStrategy = new LoadBalancingOptimizationStraregy();

    public DataCenterService(DataCenter dataCenter) {
        this.dataCenter = dataCenter;
    }

    public void addServer(Server server){
        dataCenter.servers.add(server);
    }

    public void deleteServer(int index){
        dataCenter.servers.remove(index);
    }

    public double getTotalEnergyConsumption(){
        double total = 0;
        for (Server server: dataCenter.servers) {
            total+=server.energyConsumption;
        }
        return total;
    }

    public void allocateResource(ResourceRequest resourceRequest){
        for (Server server: dataCenter.servers) {
            if(server.maxLoad - server.load>resourceRequest.load){
                server.load += resourceRequest.load;
                break;
            }
        }
    }

    public void optomize(){
        optimizationStrategy.optomize(dataCenter);
    }


}
