package ru.faang.school.task_2;

import ru.faang.school.task_2.domain.DataCenter;
import ru.faang.school.task_2.domain.ResourceRequest;
import ru.faang.school.task_2.domain.Server;
import ru.faang.school.task_2.service.impl.DataCenterService;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Start");

        DataCenter dataCenter = new DataCenter();
        DataCenterService dataCenterService = new DataCenterService(dataCenter);

        Server server1 = new Server(0, 110.0, 4.0);
        Server server2 = new Server(0, 110.0, 4.0);

        dataCenterService.addServer(server1);
        dataCenterService.addServer(server2);

        ResourceRequest request = new ResourceRequest(21);

        dataCenterService.allocateResources(request);
        dataCenterService.allocateResources(new ResourceRequest(20));
        dataCenterService.allocateResources(new ResourceRequest(20));
        dataCenterService.allocateResources(new ResourceRequest(20));
        dataCenterService.allocateResources(new ResourceRequest(20));
        dataCenterService.allocateResources(new ResourceRequest(20));

        dataCenterService.deleteServer(server1);

        dataCenterService.optimize(dataCenter);

        dataCenterService.printAllServers();

        dataCenterService.releaseResources(request);

        dataCenterService.printAllServers();
        System.out.println(dataCenterService.getTotalEnergyConsumption());
    }
}
