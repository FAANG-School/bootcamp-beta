package ru.faang.school.task_2.datacenter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.faang.school.task_2.datacenter.optimization.OptimizationStrategy;
import ru.faang.school.task_2.exceptions.NoAvailableResourcesException;
import ru.faang.school.task_2.exceptions.NoBusyResourcesException;
import ru.faang.school.task_2.server.ResourceRequest;
import ru.faang.school.task_2.server.Server;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DataCenterServiceTest {
    private DataCenter dataCenter;
    private OptimizationStrategy optimizationStrategy;
    private DataCenterService dataCenterService;

    @BeforeEach
    public void setUp() {
        dataCenter = new DataCenter();
        optimizationStrategy = dataCenter -> {
        };
        dataCenterService = new DataCenterService(dataCenter, optimizationStrategy);
    }

    /**
     * Tests if a server is correctly added to the data center service and its energy consumption is accounted for.
     */
    @Test
    public void testAddServer() {
        Server server = new Server(100, 200, 50);
        dataCenterService.addServer(server);
        assertEquals(200, dataCenterService.getTotalEnergyConsumption());
    }

    /**
     * Tests if a server is correctly removed from the data center service and its energy consumption is removed.
     */
    @Test
    public void testRemoveServer() {
        Server server = new Server(100, 200, 50);
        dataCenterService.addServer(server);
        dataCenterService.removeServer(server);
        assertEquals(0, dataCenterService.getTotalEnergyConsumption());
    }

    /**
     * Tests if resources are allocated correctly to a server when the requested resources are available.
     */
    @Test
    public void testAllocateResources() throws Exception {
        Server server = new Server(100, 200, 50);
        dataCenterService.addServer(server);

        ResourceRequest request = new ResourceRequest(50);
        dataCenterService.allocateResources(request);
        assertEquals(100, server.getLoad());
    }

    /**
     * Tests if an exception is thrown when attempting to allocate resources that are not available.
     */
    @Test
    public void testAllocateResourcesNoAvailableResources() {
        Server server = new Server(100, 200, 50);
        dataCenterService.addServer(server);

        ResourceRequest request = new ResourceRequest(200);
        assertThrows(NoAvailableResourcesException.class, () -> dataCenterService.allocateResources(request));
    }

    /**
     * Tests if resources are released correctly from a server when the requested resources are busy.
     */
    @Test
    public void testReleaseResources() throws Exception {
        Server server = new Server(100, 200, 50);
        dataCenterService.addServer(server);

        ResourceRequest request = new ResourceRequest(50);
        dataCenterService.allocateResources(request);
        dataCenterService.releaseResources(request);
        assertEquals(50, server.getLoad());
    }

    /**
     * Tests if an exception is thrown when attempting to release resources that are not busy.
     */
    @Test
    public void testReleaseResourcesNoBusyResources() {
        Server server = new Server(100, 200, 50);
        dataCenterService.addServer(server);

        ResourceRequest request = new ResourceRequest(50);
        assertThrows(NoBusyResourcesException.class, () -> dataCenterService.releaseResources(request));
    }
}
