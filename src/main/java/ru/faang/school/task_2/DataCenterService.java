package ru.faang.school.task_2;

import java.util.Comparator;
import java.util.Optional;

public class DataCenterService {
    DataCenter dataCenter;

    public DataCenterService(DataCenter dataCenter) {
        this.dataCenter = dataCenter;
    }

    public void addServer(Server server) {
        dataCenter.getServers().add(server);
    }

    public void removeServer(Server server) {
        if (!server.isEmpty()) {
            System.out.println("You cannot delete a busy server.");
            return;
        }
        if (dataCenter.getServers().contains(server)) {
            dataCenter.getServers().remove(server);
        } else {
            System.out.println("Server not found.");
        }
    }

    public double getTotalEnergyConsumption() {
        double total = dataCenter.getServers().stream()
                .mapToDouble(server -> server.getEnergyConsumption())
                .sum();
        return total;
    }

    public void allocateResources(ResourceRequest request) {
        double maxLoadonDataCentre = dataCenter.getMaxLoadOnDataCenter();
        double resourseBuffer = (maxLoadonDataCentre * 3) / 100;
        if (maxLoadonDataCentre - resourseBuffer < request.getLoad()) {
            System.out.println("Need more servers to work");
            return;
        }
        Server current = getFreeServer();
        double newPossibleLoad = current.getPossibleLoad();
        if (newPossibleLoad > request.getLoad()) {
            addLoadToCurrentServer(current, request);
        } else {
            // This is a very rough and incorrect formula, it can be calculated accurately.
            double solitTasks = request.getLoad() / 2;
            for (int i = 0; i < 2; i++) {
                allocateResources(new ResourceRequest(solitTasks));
            }
        }
    }

    private void addLoadToCurrentServer(Server server, ResourceRequest request) {
        try {
            server.addLoadTheServer(request.getLoad());
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void releaseResources(ResourceRequest request) {
        Server current = getMostBusyServer();
        double residualLoad = current.relieveLoadOnServer(request.getLoad());
        if (residualLoad > 0) {
            releaseResources(new ResourceRequest(residualLoad));
        }
    }

    public Server getMostBusyServer() {
        return dataCenter.getServers().stream()
                .max(Comparator.comparingDouble(Server::getLoad)).get();
    }

    public Server getFreeServer() {
        return dataCenter.getServers().stream()
                .min(Comparator.comparingDouble(Server::getLoad)).get();
    }
}
