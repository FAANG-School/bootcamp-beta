package ru.faang.school.task_2;

public class DataCenterService implements OptimizationStrategy{

    private final DataCenter dataCenter;

    public DataCenterService(DataCenter dataCenter) {
        this.dataCenter = dataCenter;
    }

    public void saveServer(Server server) {
        if (dataCenter.saveServer(server)) {
            System.out.println("The server is successfully saved");
        } else {
            System.out.println("Error. Server was not saved");
        }
    }

    public void removeServer(Server server) {
        if (dataCenter.removeServer(server)) {
            System.out.println("The server is successfully deleted");
        } else {
            System.out.println("Error. Server was not deleted");
        }
    }

    public double getTotalEnergyConsumption() {
        return dataCenter.getEnergyConsumptionValue()
                .stream()
                .reduce(Double::sum)
                .get();
    }

    public Server allocateResources(ResourceRequest request) {
        Server server = dataCenter.getAvailableServer(request.load());
        if (server == null) {
            System.out.println("No available servers");
        }
        return server;
    }

    public void releaseResources(ResourceRequest request, Server server) {
        dataCenter.releaseResources(request.load(), server);
    }

    @Override
    public void optimize(DataCenter dataCenter) {

    }
}
