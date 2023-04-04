package ru.faang.school;

import ru.faang.school.task_2.DataCenter;
import ru.faang.school.task_2.DataCenterService;
import ru.faang.school.task_2.ResourceRequest;

public class App {
    public static void main(String[] args) {
        ResourceRequest request = new ResourceRequest();
        request.setLoad(300);

        DataCenterService dataCenterService = new DataCenterService();

        DataCenter dataCenter = new DataCenter();

        dataCenterService.releaseResources(request);

        System.out.println("TOTAL ENERGY CONSUMPTION BEFORE OPTIMIZATION : " + dataCenter.allEnergyConsumption());

        dataCenterService.optimize(dataCenter,request);

        System.out.println("TOTAL ENERGY CONSUMPTION AFTER OPTIMIZATION : " + dataCenter.allEnergyConsumption());

    }
}
