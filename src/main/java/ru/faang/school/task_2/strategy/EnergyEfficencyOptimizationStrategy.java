package ru.faang.school.task_2.strategy;

import ru.faang.school.task_2.ResourceRequest;
import ru.faang.school.task_2.model.DataCenter;
import ru.faang.school.task_2.model.Server;
import ru.faang.school.task_2.service.DataCenterService;

import java.util.List;

public class EnergyEfficencyOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        DataCenterService dataCenterService = new DataCenterService(dataCenter);
        double totalLoad = dataCenterService.getTotalLoad();
        dataCenterService.getServerList().sort((s1, s2) ->
                (int) (s2.getMaxLoad() / s2.getEnergyConsumption() - s1.getMaxLoad() / s1.getEnergyConsumption()));
        for (Server server : dataCenter.getServerList()){
            server.setLoad(0);
        }
        dataCenterService.allocateResources(new ResourceRequest(totalLoad));


    }
}
