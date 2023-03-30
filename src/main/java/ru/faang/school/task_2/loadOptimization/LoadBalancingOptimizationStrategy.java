package ru.faang.school.task_2.loadOptimization;

import ru.faang.school.task_2.dataStorage.DataCenter;
import ru.faang.school.task_2.model.Server;


public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {

    @Override
    public void optimize(DataCenter dataCenter) {
        double averageLoad = dataCenter.getServers().stream().mapToDouble(Server::getLoad).average().getAsDouble();
        dataCenter.getServers().forEach(server -> server.setLoad(averageLoad));
    }
}
