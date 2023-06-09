package ru.faang.school.task_2;


import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;

public class DataCenterServiceTest {
    private DataCenter dataCenter;

    @Before
    public void setUp() {
        dataCenter = new DataCenter();
        DataCenterService dataCenterService = new DataCenterService(dataCenter);
        dataCenterService.addServer(new Server(45));
        dataCenterService.addServer(new Server(65));
        dataCenterService.addServer(new Server(77));
        dataCenterService.addServer(new Server(62));
        dataCenterService.addServer(new Server(51));
    }

    @Test
    public void getTotalEnergyConsumptionTest() {
        assertEquals(6000, dataCenter.getTotalEnergyConsumption(), 0);
    }

    @Test
    public void getAverageLoadTest() {
        assertEquals(60, dataCenter.getAverageLoad(), 0);
    }

    @Test
    public void allocateResourcesTest() {
        dataCenter.allocateResources(new ResourceRequest(30));
        assertEquals(75, dataCenter.getServers().get(0).getLoad(), 0);
        assertEquals(95, dataCenter.getServers().get(1).getLoad(), 0);
        assertEquals(77, dataCenter.getServers().get(2).getLoad(), 0);
        assertEquals(92, dataCenter.getServers().get(3).getLoad(), 0);
        assertEquals(81, dataCenter.getServers().get(4).getLoad(), 0);

    }
    @Test
    public void releaseResources() {
        dataCenter.releaseResources(new ResourceRequest(20));
        assertEquals(25, dataCenter.getServers().get(0).getLoad(), 0);
        assertEquals(45, dataCenter.getServers().get(1).getLoad(), 0);
        assertEquals(57, dataCenter.getServers().get(2).getLoad(), 0);
        assertEquals(42, dataCenter.getServers().get(3).getLoad(), 0);
        assertEquals(31, dataCenter.getServers().get(4).getLoad(), 0);
    }


    @Test
    public void allServersLoadShouldBeEqualToAverageLoad() {
        OptimizationStrategy oS = new LoadBalancingOptimizationStrategy();
        oS.optimize(dataCenter);
        for (Server s : dataCenter.getServers()) {
            assertEquals(dataCenter.getAverageLoad(), s.getLoad(), 0);
        }
    }

    @Test
    public void beforeOptimizationAndAfter() {
        OptimizationStrategy oS = new LoadBalancingOptimizationStrategy();
        //before
        System.out.println(dataCenter);
        oS.optimize(dataCenter);
        //after
        System.out.println(dataCenter);
    }
}