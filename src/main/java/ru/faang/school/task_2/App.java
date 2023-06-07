package ru.faang.school.task_2;

public class App {
    public static void main(String[] args) {
        try {
            DataCenter dataCenter = new DataCenter();
            DataCenterService dataCenterService = new DataCenterService(dataCenter);

            for (int i = 0; i < 2; i++) {
                dataCenter.addNewServer(new Server(30));
            }
            System.out.println(dataCenter);

            dataCenterService.allocateResources(new ResourceRequest(150));
            System.out.println(dataCenter);

            dataCenterService.releaseResources(new ResourceRequest(100));
            System.out.println(dataCenter);

            dataCenterService.balanceLoad();
            System.out.println(dataCenter);
            dataCenter.showState();
            System.out.printf("Потребление энергии дата центром: %.2f МВт\n\n", dataCenterService.getTotalEnergyConsumption());
            dataCenterService.allocateResources(new ResourceRequest(150));
            System.out.println(dataCenter);
            dataCenter.showState();

            dataCenterService.balanceLoad();
            System.out.println(dataCenter);
            dataCenter.showState();

        } catch (IllegalArgumentException ex) {
            System.out.println("Завершено с ошибкой.");
            System.out.println(ex);
        }
    }
}
