package ru.faang.school;

import ru.faang.school.task_2.DataCenter;
import ru.faang.school.task_2.DataCenterService;

public class App {
    public static void main(String[] args) {
        DataCenterService dataCenterService = new DataCenterService();
        Thread optimizationThread = new Thread(dataCenterService);
        optimizationThread.start();
    }
}
