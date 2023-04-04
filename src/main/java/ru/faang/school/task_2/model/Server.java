package ru.faang.school.task_2.model;

import ru.faang.school.task_2.model.ResourceRequest;

import java.util.ArrayList;
import java.util.List;

public class Server {
    private double load;
    private double maxLoad;
    private double energyConsumption;
    private List<ResourceRequest> resourceRequests;

    public Server(double maxLoad, double energyConsumption) {
        load = 0D;
        this.maxLoad = maxLoad;
        this.energyConsumption = energyConsumption;
        resourceRequests = new ArrayList<>();
    }

    public List<ResourceRequest> getResourceRequests() {
        return resourceRequests;
    }

    public boolean addRequest(ResourceRequest resourceRequest) {
        boolean requestAdded = false;
        double resourceLoad = resourceRequest.getLoad();
        if (load + resourceLoad <= maxLoad) {
            resourceRequests.add(resourceRequest);
            load += resourceLoad;
            requestAdded = true;
        }
        return requestAdded;
    }

    public boolean removeRequest(ResourceRequest resourceRequest) {
        return resourceRequests.remove(resourceRequest);
    }

    public void cleanResources() {
        resourceRequests = new ArrayList<>();
    }

    public double getLoad() {
        return load;
    }

    public double getMaxLoad() {
        return maxLoad;
    }

    public double getEnergyConsumption() {
        return energyConsumption;
    }
}
