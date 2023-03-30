package ru.faang.school.task_2.optimization;

import ru.faang.school.task_2.model.DataCenter;
import ru.faang.school.task_2.model.ResourceRequest;
import ru.faang.school.task_2.model.Server;

import java.util.*;

public class EnergyEfficencyOptimizationStrategy implements OptimizationStrategy {
    private Queue<Server> serverQueue;
    private Queue<ResourceRequest> requestQueue;

    @Override
    public void optimize(DataCenter dataCenter) {
        collectAllServersAndRequests(dataCenter);

        for (Server server : serverQueue) {
            for (ResourceRequest request : requestQueue) {
                if (server.addRequest(request)) {
                    requestQueue.remove(request);
                } else {
                    break;
                }
            }
        }

        if (!requestQueue.isEmpty()) {
            throw new RuntimeException("Not enough servers for all requests allocation or algorithm not good enough");
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
