package ru.faang.school.task_2.process;

import ru.faang.school.task_2.data.DataCenter;
import ru.faang.school.task_2.data.ResourceRequest;
import ru.faang.school.task_2.data.Server;
import ru.faang.school.task_2.service.DataCenterService;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        DataCenter dataCenter = new DataCenter();
        DataCenterService dataCenterService = new DataCenterService(dataCenter);
        Server server1 = new Server(
                800 + (1000 - 800) * random.nextDouble(),
                2000 + (2500 - 2000) * random.nextDouble(),
                80 + (120 - 80) * random.nextDouble()
        );
        Server server2 = new Server(
                800 + (1000 - 800) * random.nextDouble(),
                2000 + (2500 - 2000) * random.nextDouble(),
                80 + (120 - 80) * random.nextDouble()
        );
        Server server3 = new Server(
                800 + (1000 - 800) * random.nextDouble(),
                2000 + (2500 - 2000) * random.nextDouble(),
                80 + (120 - 80) * random.nextDouble()
        );

        dataCenterService.addServer(server1);
        dataCenterService.addServer(server2);
        dataCenterService.addServer(server3);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                dataCenterService.optomize();
            }
        }, 0, 1800000);

        while (true){
            Thread.sleep(120000);
            ResourceRequest newRequest = new ResourceRequest(2 + (8 - 2) * random.nextDouble());
            dataCenterService.allocateResource(newRequest);
        }
    }
}
