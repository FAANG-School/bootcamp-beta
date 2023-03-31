package ru.faang.school.task_2;

import ru.faang.school.task_2.strategy.OptimizationStrategy;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class DataCenterService {
    private final DataCenter dataCenter;
    private OptimizationStrategy optimizationStrategy;
    private final ScheduledExecutorService executor;

    public DataCenterService(DataCenter dataCenter) {
        this.dataCenter = dataCenter;
        this.executor = Executors.newSingleThreadScheduledExecutor();
    }

    public void addServer(Server server) {
        dataCenter.addServer(server);
    }

    public boolean removeServer(Server server) {
        return dataCenter.removeServer(server);
    }

    public OptimizationStrategy getOptimizationStrategy() {
        return optimizationStrategy;
    }

    public void setOptimizationStrategy(OptimizationStrategy optimizationStrategy) {
        this.optimizationStrategy = optimizationStrategy;
    }

    public double getTotalEnergyConsumption() {
        return dataCenter.getDataCenterEnergyConsumption();
    }

    public boolean allocateResources(ResourceRequest resourceRequest) {
        return dataCenter.allocateResources(resourceRequest);
    }

    public boolean releaseResources(ResourceRequest resourceRequest) {
        return dataCenter.releaseResources(resourceRequest);
    }

    public void startOptimize(int timePeriod) {
        executor.scheduleAtFixedRate(this::optimizeInOwnThread, 0, timePeriod, TimeUnit.SECONDS);
    }

    private synchronized void optimizeInOwnThread() {
        optimizationStrategy.optimize(this.dataCenter);
    }

    public void stopOptimize() {
        executor.shutdown();
    }

    @Override
    public String toString() {
        return dataCenter.toString();
    }
}
