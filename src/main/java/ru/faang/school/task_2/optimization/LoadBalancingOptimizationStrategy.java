package ru.faang.school.task_2.optimization;

import ru.faang.school.task_2.model.DataCenter;
import ru.faang.school.task_2.model.ResourceRequest;
import ru.faang.school.task_2.model.Server;

import java.util.*;

public class LoadBalancingOptimizationStrategy implements OptimizationStrategy {
    private Queue<Server> serverQueue;
    private Queue<ResourceRequest> requestQueue;

    @Override
    public void optimize(DataCenter dataCenter) {
        collectAllServersAndRequests(dataCenter);

        double totalLoad = 0D;
        double totalMaxLoad = 0D;
        for (Server server : serverQueue) {
            totalLoad += server.getLoad();
            totalMaxLoad += server.getMaxLoad();
        }
        double totalLoadCoefficient = totalLoad / totalMaxLoad;

        while (!requestQueue.isEmpty()) {
            for (Server server : serverQueue) {
                while (server.getLoad() / server.getMaxLoad() < totalLoadCoefficient) {
                    try {
                        if (server.addRequest(requestQueue.element())) {
                            requestQueue.remove();
                        } else {
                            serverQueue.remove(server);
                            break;
                        }
                    } catch (NoSuchElementException e) {
                        break;
                    }
                }
                serverQueue.remove(server);
                break;
            }
            if (serverQueue.isEmpty()) {
                break;
            }
        }

        if (!requestQueue.isEmpty()) {
            throw new RuntimeException(("Not enough servers for all requests allocation or algorithm not good enough"));
        }
    }

    private void collectAllServersAndRequests(DataCenter dataCenter) {
        serverQueue = new ArrayDeque<>(dataCenter.getServerList());
        requestQueue = new ArrayDeque<>();
        for (Server server : serverQueue) {
            requestQueue.addAll(server.getResourceRequests());
            server.cleanResources();
        }
    }
}
