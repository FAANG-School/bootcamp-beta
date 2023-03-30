package ru.faang.school.task_2.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.faang.school.task_2.model.DataCenter;
import ru.faang.school.task_2.model.ResourceRequest;
import ru.faang.school.task_2.model.Server;
import ru.faang.school.task_2.optimization.EnergyEfficencyOptimizationStrategy;
import ru.faang.school.task_2.optimization.LoadBalancingOptimizationStrategy;
import ru.faang.school.task_2.service.DataCenterService;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DataCenterServiceTest {
    private DataCenter dataCenter;
    private DataCenterService service;

    @BeforeEach
    void setUp() {
        dataCenter = new DataCenter();
        service = new DataCenterService(dataCenter);

        Server smallServer1 = new Server(50, 100);
        Server smallServer2 = new Server(50, 100);
        Server smallServer3 = new Server(50, 100);
        Server smallServer4 = new Server(50, 100);
        Server mediumServer = new Server(60, 300);
        Server largeServer = new Server(70, 1000);

        service.addServer(smallServer1);
        service.addServer(smallServer2);
        service.addServer(smallServer3);
        service.addServer(smallServer4);
        service.addServer(mediumServer);
        service.addServer(largeServer);
    }

    @Test
    void optimizationByEnergy() {
        setUpCorrectRequests();
        assertDoesNotThrow(() -> service.optimize(new EnergyEfficencyOptimizationStrategy()));
    }

    @Test
    void optimizationByLoad() {
        setUpCorrectRequests();
        assertDoesNotThrow(() -> service.optimize(new LoadBalancingOptimizationStrategy()));
    }

    @Test
    void optimizationByEnergyFail() {
        setUpTooManyRequests();
        assertThrows(RuntimeException.class, () -> service.optimize(new EnergyEfficencyOptimizationStrategy()));
    }

    @Test
    void optimizationByLoadFail() {
        setUpTooManyRequests();
        assertThrows(RuntimeException.class, () -> service.optimize(new LoadBalancingOptimizationStrategy()));
    }

    private void setUpCorrectRequests() {
        ResourceRequest request1 = new ResourceRequest(10);
        ResourceRequest request2 = new ResourceRequest(10);
        ResourceRequest request3 = new ResourceRequest(10);
        ResourceRequest request4 = new ResourceRequest(10);
        ResourceRequest request5 = new ResourceRequest(10);
        ResourceRequest request6 = new ResourceRequest(10);

        service.allocateResources(request1);
        service.allocateResources(request2);
        service.allocateResources(request3);
        service.allocateResources(request4);
        service.allocateResources(request5);
        service.allocateResources(request6);
    }

    private void setUpTooManyRequests() {
        for (int i = 0; i < 30; i++) {
            service.allocateResources(new ResourceRequest(10));
        }
    }

}
