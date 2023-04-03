package ru.faang.school.task_2.data;

import ru.faang.school.task_2.optimize.OptimizationStrategy;
import ru.faang.school.task_2.server.Server;

import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataCenterService  implements OptimizationStrategy {
    private final Logger logger = Logger.getLogger(getClass().getName());
    private final DataCenter dataCenter;
    private final ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
    public DataCenterService(DataCenter dataCenter) {
        this.dataCenter = dataCenter;
    }
    public void serverCreate(double load, double maxLoad, double energyConsumption, Server.ServerStatus status) {
        if (load < 0 || maxLoad < 0 || energyConsumption < 0) {
            logger.log(Level.WARNING, "IllegalArgumentException occurred");
            throw new IllegalArgumentException("must be non-negative");
        }
        dataCenter.getServers().add(new Server(load, maxLoad, energyConsumption, status));
    }

    public void serverRemove(Server server) {
        checkSet();
        dataCenter.getServers().remove(server);
    }

    public void allocateResources(ResourceRequest request) {
        checkRequest(request);

        checkSet();

        double load = request.getLoad();
        double activeLoad = getTotalMaxLoad(Server.ServerStatus.ACTIVE);

        allocChecker(activeLoad, load);

    }
    public void releaseResources(ResourceRequest request) {
        checkRequest(request);

        checkSet();

        double load = request.getLoad();

        if (load > getTotalLoad()) {
            return;
        }
        releaseResourceUpdate(load);
    }

    @Override
    public void optimize(DataCenter dataCenter) {
        service.scheduleAtFixedRate(() -> {
            checkSet();

            Set<Server> serverList = dataCenter.getServers();

            double averageLoad = getTotalLoad();

            releaseResources(new ResourceRequest(averageLoad));
            allocateResources(new ResourceRequest(averageLoad));

            serverList.forEach(server -> System.out.println(server.getLoad()));
            serverList.stream()
                    .filter(server -> server.getLoad() == 0)
                    .forEach(server -> server.setStatus(Server.ServerStatus.SLEEP));

        }, 0, 30, TimeUnit.MINUTES);
    }
    public double getTotalEnergyConsumption() {
        return dataCenter.getServers().stream().filter(server -> server.getStatus() == Server.ServerStatus.ACTIVE).mapToDouble(Server::getEnergyConsumption).sum();
    }
    public double getTotalLoad() {
        return dataCenter.getServers().stream().filter(server -> server.getStatus() == Server.ServerStatus.ACTIVE).mapToDouble(Server::getLoad).sum();
    }
    public double getTotalMaxLoad(Server.ServerStatus status) {
        return dataCenter.getServers().stream().filter(server -> server.getStatus() == status).mapToDouble(Server::getMaxLoad).sum();
    }
    private void checkSet() {
        if (dataCenter.getServers().size() == 0) {
            logger.log(Level.WARNING, "NullPointerException occurred");
            throw new NullPointerException("No servers available");
        }
    }
    private void checkRequest(ResourceRequest request) {
        if (request.getLoad() < 0) {
            logger.log(Level.WARNING, "IllegalArgumentException occurred");
            throw new IllegalArgumentException("must be non-negative");
        }
    }
    private void allocChecker(double activeLoad, double load) {
        if (activeLoad < load + getTotalLoad()) {
            if (activeLoad + getTotalMaxLoad(Server.ServerStatus.SLEEP) < load) {
                logger.warning("not enough resources");
                return;
            }
            dataCenter.getServers()
                    .stream()
                    .filter(server -> server.getStatus() == Server.ServerStatus.SLEEP)
                    .forEach(server -> server.setStatus(Server.ServerStatus.ACTIVE));
        }

        allocateResourceUpdate(load);
    }
    private void releaseResourceUpdate(double load) {
        for (Server server : dataCenter.getServers()) {

            if (server.getStatus() != Server.ServerStatus.ACTIVE) {
                continue;
            }

            if (load <= 0) {
                return;
            }
            double l = server.getLoad();

            if (load >= l) {

                load -= l;
                server.setLoad(0);
                continue;

            }

            server.setLoad(server.getLoad() - load);
            load = 0;
        }
    }
    private void allocateResourceUpdate(double load) {
        for (Server server : dataCenter.getServers()) {

            if (server.getStatus() != Server.ServerStatus.ACTIVE) {
                continue;
            }

            if (load <= 0) {
                return;
            }

            double residue = server.getMaxLoad() - server.getLoad();

            if (load >= residue) {

                load -= residue;
                server.setLoad(server.getMaxLoad());
                continue;

            }

            server.setLoad(server.getLoad() + load);
            load = 0;
        }
    }

    public DataCenter getDataCenter() {
        return dataCenter;
    }
}
