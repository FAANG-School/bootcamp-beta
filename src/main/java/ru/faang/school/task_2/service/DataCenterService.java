package ru.faang.school.task_2.service;

import ru.faang.school.task_2.model.DataCenter;
import ru.faang.school.task_2.optimization.OptimizationStrategy;
import ru.faang.school.task_2.model.ResourceRequest;
import ru.faang.school.task_2.model.Server;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

import static java.util.concurrent.TimeUnit.*;

public class DataCenterService {

    private DataCenter dataCenter;
    private static final int OPTIMIZATION_SCHEDULER_PERIOD = 30;
    private static final int OPTIMIZATION_SCHEDULER_PERIOD_FOR_CANCEL = 3;

    public DataCenterService(DataCenter dataCenter) {
        this.dataCenter = dataCenter;
    }

    public void optimize(OptimizationStrategy strategy) {
        strategy.optimize(dataCenter);
    }

    public void optimizeEveryStaticPeriod(OptimizationStrategy strategy) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        Runnable optimizationTask = () -> optimize(strategy);
        ScheduledFuture<?> optimizationHandle =
                scheduler.scheduleAtFixedRate(optimizationTask, 0, OPTIMIZATION_SCHEDULER_PERIOD, SECONDS);

        Runnable canceller = () -> optimizationHandle.cancel(false);
        scheduler.schedule(canceller, OPTIMIZATION_SCHEDULER_PERIOD_FOR_CANCEL, MINUTES);
    }

    public void addServer(Server server) {
        dataCenter.addServer(server);
    }

    public void removeServer(Server server) {
        dataCenter.removeServer(server);
    }

    public void allocateResources(ResourceRequest request) {
        dataCenter.allocateResources(request);
    }

    public void releaseResources(ResourceRequest request) {
        dataCenter.releaseResources(request);
    }
}
