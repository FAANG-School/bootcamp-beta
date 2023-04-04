package ru.faang.school.task_2.datacenter;

import ru.faang.school.task_2.datacenter.optimization.OptimizationStrategy;
import ru.faang.school.task_2.datacenter.utils.ServerLoadCalculator;
import ru.faang.school.task_2.exceptions.NoAvailableResourcesException;
import ru.faang.school.task_2.exceptions.NoBusyResourcesException;
import ru.faang.school.task_2.server.ResourceRequest;
import ru.faang.school.task_2.server.Server;

import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.function.BiPredicate;

/**
 * DataCenterService class handles operations on the data center, such as adding/removing servers,
 * allocating/releasing resources, and managing energy consumption.
 */
public class DataCenterService {
    private DataCenter dataCenter;
    private OptimizationStrategy optimizationStrategy;

    private double totalEnergyConsumption;

    /**
     * Constructs a DataCenterService instance with the given data center and optimization strategy.
     */
    public DataCenterService(DataCenter dataCenter, OptimizationStrategy optimizationStrategy) {
        this.dataCenter = dataCenter;
        this.optimizationStrategy = optimizationStrategy;
        this.totalEnergyConsumption = 0.0;
    }

    public double getTotalEnergyConsumption() {
        return this.totalEnergyConsumption;
    }

    /**
     * Adds a server to the data center and updates the total energy consumption.
     */
    public void addServer(Server server) {
        this.dataCenter.addServer(server);
        this.addEnergyConsumption(server.getEnergyConsumption());
    }

    /**
     * Removes a server from the data center and updates the total energy consumption.
     */
    public void removeServer(Server server) {
        this.dataCenter.removeServer(server);
        this.removeEnergyConsumption(server.getEnergyConsumption());
    }

    /**
     * Allocates resources to the given request based on the server load calculation
     * and throws an exception if there are no available resources.
     */
    public void allocateResources(ResourceRequest request) throws Exception {
        ServerLoadCalculator calculateServerLoad = (server, resourceRequest) -> server.getLoad() + resourceRequest.getLoad();
        BiPredicate<Server, ResourceRequest> hasEnoughResourcesMatch = (server, resourceRequest) -> (server.getLoad() + request.getLoad()) <= server.getMaxLoad();
        Callable<Void> throwException = () -> {
            throw new NoAvailableResourcesException();
        };
        this.processResources(request, hasEnoughResourcesMatch, calculateServerLoad, throwException);
    }

    /**
     * Releases resources from the given request based on the server load calculation
     * and throws an exception if there are no busy resources.
     */
    public void releaseResources(ResourceRequest request) throws Exception {
        ServerLoadCalculator calculateServerLoad = (server, resourceRequest) -> server.getLoad() - resourceRequest.getLoad();
        BiPredicate<Server, ResourceRequest> hasEnoughResourcesMatch = (server, resourceRequest) -> (server.getLoad() - resourceRequest.getLoad()) > 0;
        Callable<Void> throwException = () -> {
            throw new NoBusyResourcesException();
        };
        this.processResources(request, hasEnoughResourcesMatch, calculateServerLoad, throwException);
    }

    /**
     * Optimizes the data center using the provided optimization strategy.
     */
    public void optimize(DataCenter dataCenter) {
        this.optimizationStrategy.optimize(dataCenter);
    }

    /**
     * Processes resource requests based on the provided conditions, load calculations,
     * and exception handling.
     */
    private void processResources(
            ResourceRequest request,
            BiPredicate<Server, ResourceRequest> serverMatchCondition,
            ServerLoadCalculator calculateLoad,
            Callable<Void> throwException) throws Exception {
        Optional<Server> maybeServerMatch = this.findServerWithCondition(serverMatchCondition, request);
        if (maybeServerMatch.isEmpty()) {
            throwException.call();
        } else {
            Server server = maybeServerMatch.get();
            server.setLoad(calculateLoad.apply(server, request));
        }
    }

    /**
     * Finds a server in the data center that meets the provided condition.
     */
    private Optional<Server> findServerWithCondition(
            BiPredicate<Server, ResourceRequest> condition,
            ResourceRequest request) {
        return this.dataCenter.getServers().stream().filter(server -> condition.test(server, request)).findAny();
    }

    /**
     * Adds the server's energy consumption to the total energy consumption and checks the consumption level.
     */
    private void addEnergyConsumption(double serverEnergyConsumption) {
        this.totalEnergyConsumption += serverEnergyConsumption;
        this.checkEnergyConsumptionLevel();
    }

    /**
     * Removes the server's energy consumption from the total energy consumption and checks the consumption level.
     */
    private void removeEnergyConsumption(double serverEnergyConsumption) {
        this.totalEnergyConsumption -= serverEnergyConsumption;
        this.checkEnergyConsumptionLevel();
    }

    /**
     * Checks and adjusts the total energy consumption level to ensure it stays within valid bounds.
     */
    private void checkEnergyConsumptionLevel() {
        if (this.totalEnergyConsumption < 0) {
            this.totalEnergyConsumption = 0;
        }
    }
}
