package ru.faang.school.task_2;

public class Main {

    public static void main(String[] args) {
        DataCenter dataCenter1 = new DataCenter();
        DataCenterService dataCenterService = new DataCenterService(dataCenter1);
        dataCenterService.addServer(new Server(100d));
        dataCenterService.addServer(new Server(100d));
        dataCenterService.allocateResources(new ResourceRequest(30.1));
        System.out.println(dataCenter1);
        dataCenterService.allocateResources(new ResourceRequest(21.1));
        System.out.println(dataCenter1);
        dataCenterService.allocateResources(new ResourceRequest(64.1));
        System.out.println(dataCenter1);
        dataCenterService.allocateResources(new ResourceRequest(85.9));
        System.out.println(dataCenter1);
        dataCenterService.releaseResources(new ResourceRequest(30));
        System.out.println(dataCenter1);
        System.out.println("Total energy consumption " + dataCenterService.getTotalEnergyConsumption());
        StandartOptimizationStrategy sos = new StandartOptimizationStrategy();
        dataCenterService.addServer(new Server(100d));
        Server serverForRemove = new Server(1000);
        dataCenterService.addServer(serverForRemove);
        System.out.println(dataCenter1);
        dataCenterService.removeServer(serverForRemove);
        sos.optimize(dataCenter1);
        System.out.println(dataCenter1);
    }
}
