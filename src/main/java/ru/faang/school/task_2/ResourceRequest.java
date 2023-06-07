package ru.faang.school.task_2;

public class ResourceRequest {

    private double load;

    public ResourceRequest(double load) {
        this.load = load;
    }

    public double getLoad() {
        return load;
    }

    public void addServer(Server server, DataCenter dataCenter){
        dataCenter.getListOfServers().add(server);
    }

    public void deleteServer(Server server, DataCenter dataCenter){
        dataCenter.getListOfServers().remove(server);
    }

    public double getTotalEnergyConsumption(DataCenter dataCenter){
        double result = dataCenter.getListOfServers().stream()
                .map(Server::getEnergyConsumption)
                .mapToDouble(cons -> cons)
                .sum();
        return result;
    }
    public void allocateResources(ResourceRequest request, DataCenter dataCenter){
        DataCenterService dataCenterService = new DataCenterService(request.getLoad());
        dataCenterService.setNewLoad(dataCenter);
    }
    public void releaseResources(ResourceRequest request, DataCenter dataCenter){
        DataCenterService dataCenterService = new DataCenterService(request.getLoad());
        dataCenterService.freeLoad(dataCenter);
    }

}
