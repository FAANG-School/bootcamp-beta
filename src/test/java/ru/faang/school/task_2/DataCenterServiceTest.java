package ru.faang.school.task_2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataCenterServiceTest {

    private static DataCenter dataCenter;

    @BeforeAll
    public static void initializeDataCenter() {
        dataCenter = new DataCenter();
        dataCenter.saveServer(new Server(1, 6, 2));
        dataCenter.saveServer(new Server(1, 6, 4));
        dataCenter.saveServer(new Server(1, 6, 4));
    }

    @Test
    void afterSaveServerCountMustBeFour() {
        DataCenterService dataCenterService = new DataCenterService(dataCenter);
        dataCenterService.saveServer(new Server(1, 1,1));
        assertEquals(4, dataCenterService.getServersCount());
    }

    @Test
    void totalEnergyConsumptionShouldBeTen() {
        DataCenterService dataCenterService = new DataCenterService(dataCenter);
        assertEquals(10, dataCenterService.getTotalEnergyConsumption());
    }
}