package ru.faang.school.task_2;

public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {

    @Override
    public void optimize(DataCenter dataCenter) {
        double averageLoad = dataCenter.getAverageLoad();
        for (Server s : dataCenter.getServers()) {
            if (s.getLoad() > averageLoad) {
                s.removeLoad(s.getLoad() - averageLoad);
            } else if (s.getLoad() < averageLoad) {
                s.addLoad(averageLoad - s.getLoad());
            }
        }
    }

}
