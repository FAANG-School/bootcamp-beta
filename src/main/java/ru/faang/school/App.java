package ru.faang.school;

import ru.faang.school.task_2.DataCenter;
import ru.faang.school.task_2.DataCenterService;
import ru.faang.school.task_2.ResourceRequest;
import ru.faang.school.task_2.Server;

public class App {
    public static void main(String[] args) {
        DataCenter dataCenter = new DataCenter();
        dataCenter.saveServer(new Server(10, 25, 10));
        dataCenter.saveServer(new Server(0, 25, 10));
        dataCenter.saveServer(new Server(5, 15, 10));
        DataCenterService dataCenterService = new DataCenterService(dataCenter);
        dataCenterService.optimize();

        dataCenterService.allocateResources(new ResourceRequest(10));
        dataCenterService.optimize();

        dataCenterService.releaseResources(new ResourceRequest(20));
        dataCenterService.optimize();
    }
}
