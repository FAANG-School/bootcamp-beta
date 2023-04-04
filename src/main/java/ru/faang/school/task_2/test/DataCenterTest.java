package ru.faang.school.task_2.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.faang.school.task_2.model.DataCenter;
import ru.faang.school.task_2.model.ResourceRequest;
import ru.faang.school.task_2.model.Server;
import ru.faang.school.task_2.service.DataCenterService;

import static org.junit.jupiter.api.Assertions.*;

public class DataCenterTest {
    private DataCenter dataCenter;
    @BeforeEach
    void setUp() {
        dataCenter = new DataCenter();
    }

    @Test
    void addServer() {
        Server server = new Server(100, 50);
        dataCenter.addServer(server);
        assertTrue(dataCenter.getServerList().contains(server));
    }

    @Test
    void removeServer() {
        Server server = new Server(100, 50);
        dataCenter.addServer(server);
        dataCenter.removeServer(server);
        assertFalse(dataCenter.getServerList().contains(server));
    }

    @Test
    void gettingTotalEnergy() {
        Server smallServer = new Server(100, 50);
        Server mediumServer = new Server(100, 100);

        dataCenter.addServer(smallServer);
        dataCenter.addServer(mediumServer);

        double energyFromServers = smallServer.getEnergyConsumption() + mediumServer.getEnergyConsumption();

        assertEquals(energyFromServers, dataCenter.getTotalEnergyConsumption());
    }

    @Test
    void resourceAllocation() {
        Server server = new Server(100, 50);
        dataCenter.addServer(server);

        ResourceRequest request = new ResourceRequest(10);

        assertDoesNotThrow(() -> dataCenter.allocateResources(request));
    }

    @Test
    void resourceAllocationFail() {
        Server server = new Server(100, 50);
        dataCenter.addServer(server);

        ResourceRequest request = new ResourceRequest(10000);

        assertThrows(RuntimeException.class, () -> dataCenter.allocateResources(request));
    }

}
