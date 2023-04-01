package ru.faang.school.task_2.strategy;


import ru.faang.school.task_2.model.DataCenter;
import ru.faang.school.task_2.model.Server;
import ru.faang.school.task_2.service.DataCenterService;

public class LoadBalancingOptimizationStrategy implements OptimizationStrategy{

    @Override
    public void optimize(DataCenter dataCenter) {
        DataCenterService dataCenterService = new DataCenterService(dataCenter);
        double totalLoad = dataCenterService.getTotalLoad();
        double totalMaxLoad = dataCenterService.getTotalMaxLoad();

        for (Server server : dataCenter.getServerList()){
            server.setLoad(totalLoad/totalMaxLoad*server.getMaxLoad());
        }
    }
}
