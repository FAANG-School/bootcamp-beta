package ru.faang.school.task_2;

import ru.faang.school.task_2.model.DataCenter;
import ru.faang.school.task_2.model.Server;
import ru.faang.school.task_2.service.DataCenterService;
import ru.faang.school.task_2.strategy.EnergyEfficencyOptimizationStrategy;
import ru.faang.school.task_2.strategy.LoadBalancingOptimizationStrategy;

public class Test {
    public static void main(String[] args) {
        Server server1 = new Server(0, 500, 100, "1");
        Server server2 = new Server(0, 50, 300, "2");
        Server server3 = new Server(0, 325, 400, "3");

        DataCenter dataCenter = new DataCenter();

        DataCenterService dataCenterService = new DataCenterService(dataCenter);
        dataCenterService.addServer(server1);
        dataCenterService.addServer(server2);
        dataCenterService.addServer(server3);

        ResourceRequest resourceRequest1 = new ResourceRequest(300);
        ResourceRequest resourceRequest2 = new ResourceRequest(500);
        ResourceRequest resourceRequest3 = new ResourceRequest(71);

        dataCenterService.allocateResources(resourceRequest1);
        dataCenterService.allocateResources(resourceRequest2);
        dataCenterService.allocateResources(resourceRequest3);

        printServers(dataCenterService);

        dataCenterService.optimize(new EnergyEfficencyOptimizationStrategy());

        System.out.println();
        System.out.println("AFTER OPTIMIZING");
        System.out.println();

        printServers(dataCenterService);

        dataCenterService.releaseResources(new ResourceRequest(150));

        System.out.println();
        System.out.println("After releasing");
        System.out.println();

        printServers(dataCenterService);


        System.out.println("DONE!");
    }

    private static void printServers(DataCenterService dataCenterService) {
        for (Server server : dataCenterService.getServerList()) {
            System.out.println(server.name);
            System.out.println("Load: " + server.getLoad());
            System.out.println("Max load:  " + server.getMaxLoad());
            System.out.println("Energy consumption: " + server.getEnergyConsumption());
            System.out.println("Energy effectivity: " + server.getMaxLoad()/ server.getEnergyConsumption());
            System.out.println();
        }
    }
}

