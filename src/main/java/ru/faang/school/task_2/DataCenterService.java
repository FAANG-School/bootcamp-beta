package ru.faang.school.task_2;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DataCenterService {

    private static final Logger LOGGER = Logger.getLogger("DataCenter Service");

    private DataCenter dataCenter;
    private OptimizationStrategy optimizationStrategy;

    public DataCenterService(DataCenter dataCenter) {
        this.dataCenter = dataCenter;
        optimizationStrategy = new LoadBalancingOptimizationStrategy();     // Default balancer
    }

    public void saveServer(Server server) {
        if (dataCenter.saveServer(server)) {
            LOGGER.log(Level.INFO, "The server is successfully saved");
        } else {
            LOGGER.log(Level.WARNING, "Error. Server was not saved");
        }
    }

    public void removeServer(Server server) {
        if (dataCenter.removeServer(server)) {
            LOGGER.log(Level.INFO, "The server is successfully deleted");
        } else {
            LOGGER.log(Level.WARNING, "Error. Server was not deleted");
        }
    }

    public double getTotalEnergyConsumption() {
        return dataCenter.getEnergyConsumptionStream()
                .reduce(Double::sum)
                .get();
    }

    public boolean allocateResources(ResourceRequest request) {
        if (!dataCenter.allocateResources(request.load())) {
            LOGGER.log(Level.WARNING, "Error. There's no way to allocate as many resources");
            return false;
        }
        return true;
    }


    public void releaseResources(ResourceRequest request) {
        dataCenter.releaseResources(request.load());
    }

    public void optimize() {
        optimizationStrategy.optimize(dataCenter);
    }

    public int getServersCount() {
        return dataCenter.getServersCount();
    }

    public void setOptimizationStrategy(OptimizationStrategy optimizationStrategy) {
        this.optimizationStrategy = optimizationStrategy;
    }

    public void setDataCenter(DataCenter dataCenter) {
        this.dataCenter = dataCenter;
    }
}
