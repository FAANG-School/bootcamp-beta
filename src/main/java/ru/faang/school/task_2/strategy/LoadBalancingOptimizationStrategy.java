package ru.faang.school.task_2.strategy;

import ru.faang.school.task_2.DataCenter;

public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {
    @Override
    public void optimize(DataCenter dataCenter) {
        double totalLoad = dataCenter.getTotalLoad();
        double averageLoad = totalLoad / dataCenter.getCountServers();
        dataCenter.rebalanceLoad(averageLoad);
    }
}
