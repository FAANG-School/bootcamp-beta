package ru.faang.school.task_2.service.impl;

import ru.faang.school.task_2.domain.DataCenter;
import ru.faang.school.task_2.domain.ResourceRequest;
import ru.faang.school.task_2.domain.Server;
import ru.faang.school.task_2.service.OptimizationStrategy;

import java.util.*;

public class DataCenterService implements OptimizationStrategy {

    private final static int LOAD_FACTOR = 25;

    private final static int FREQUENCY_OF_OPTIMIZATIONS = 1800000;

    private final DataCenter dataCenter;

    private final Queue<Server> lowLoadedServers = new ArrayDeque<>();

    private final Queue<Server> highLoadedServers = new ArrayDeque<>();

    public DataCenterService(DataCenter dataCenter) {
        this.dataCenter = dataCenter;
    }

    @Override
    public void optimize(DataCenter dataCenter) {
        Runnable scheduler = () -> {
            while (dataCenter.getServers() != null) {
                System.out.println("Optimization has begun...");
                for (Map.Entry<Server, List<ResourceRequest>> entry : dataCenter.getServers().entrySet()) {
                    Server server = entry.getKey();
                    if(server.getMaxLoad() - server.getLoad() < server.getMaxLoad() / 2) {
                        lowLoadedServers.add(entry.getKey());
                    }
                    if(server.getMaxLoad() - server.getLoad() < LOAD_FACTOR) {
                        highLoadedServers.add(entry.getKey());
                    }
                }
                while (!lowLoadedServers.isEmpty() && !highLoadedServers.isEmpty()) {
                    Server notLoadedServer = lowLoadedServers.poll();
                    Server highLoadedServer = highLoadedServers.poll();

                    ResourceRequest requestToSwitch = dataCenter.getServers().get(highLoadedServer).remove(0);
                    highLoadedServer.reduceLoad(requestToSwitch.getLoad());

                    dataCenter.getServers().get(notLoadedServer).add(requestToSwitch);
                    notLoadedServer.increaseLoad(requestToSwitch.getLoad());
                }
                System.out.println("Optimization is over...");
                try {
                    Thread.sleep(FREQUENCY_OF_OPTIMIZATIONS);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        if(dataCenter.getServers() != null) {
            new Thread(scheduler).start();
        } else {
            printNotAvailable();
        }
    }

    public void addServer(Server server) {
        if(dataCenter.getServers() == null) {
            Map<Server, List<ResourceRequest>> serverListMap = new HashMap<>();
            serverListMap.put(server, new ArrayList<>());
            dataCenter.setServers(serverListMap);
        } else {
            dataCenter.getServers().put(server, new ArrayList<>());
        }
    }

    public void deleteServer(Server server) {
        List<ResourceRequest> resourcesForDistribution = dataCenter.getServers().get(server);
        dataCenter.getServers().remove(server);
        for (ResourceRequest resource : resourcesForDistribution) {
            allocateResources(resource);
        }
    }

    public double getTotalEnergyConsumption() {
        return dataCenter.getServers().values()
                .stream().flatMap(Collection::stream).mapToDouble(ResourceRequest::getLoad).sum();
    }

    public void allocateResources(ResourceRequest request) {
        if(dataCenter.getServers() == null) {
            printNotAvailable();
            return;
        }
        for (Server server : dataCenter.getServers().keySet()) {
            if(request.getLoad() <= server.getMaxLoad() - server.getLoad()) {
                server.setLoad(server.getLoad() + request.getLoad());
                dataCenter.getServers().get(server).add(request);
                return;
            }
        }
        printNotAvailable();
    }
    public void releaseResources(ResourceRequest request) {
        Server searchingServer = null;
        for (Map.Entry<Server, List<ResourceRequest>> entry : dataCenter.getServers().entrySet()) {
            for (ResourceRequest req : entry.getValue()) {
                if(request.equals(req)) {
                    searchingServer = entry.getKey();
                    break;
                }
            }
        }
        if(searchingServer != null) {
            dataCenter.getServers().get(searchingServer).remove(request);
            searchingServer.reduceLoad(request.getLoad());
        }
    }
    
    public void printAllServers() {
        for (Map.Entry<Server, List<ResourceRequest>> entry : dataCenter.getServers().entrySet()) {
            System.out.println(entry);
        }
    }

    private void printNotAvailable() {
        System.out.println("No available servers");
    }
}
