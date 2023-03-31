package ru.faang.school.task_2.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.faang.school.task_2.data.DataCenter;
import ru.faang.school.task_2.data.DataCenterService;
import ru.faang.school.task_2.data.ResourceRequest;
import ru.faang.school.task_2.server.Server;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.*;

class DataCenterServiceTest {
    private DataCenterService dataCenterService;

    @BeforeEach
    public void creator() {
        Set<Server> servers = new HashSet<>();
        dataCenterService = new DataCenterService(new DataCenter(servers));

        dataCenterService.serverCreate(10, 20, 100, Server.ServerStatus.ACTIVE);
        dataCenterService.serverCreate(10, 20, 100, Server.ServerStatus.ACTIVE);
        dataCenterService.serverCreate(0, 20, 0, Server.ServerStatus.SLEEP);
    }
    @Test
    @DisplayName("ServerCreate")
    void serverCreate() {
        int startSize = dataCenterService.getDataCenter().getServers().size();

        dataCenterService.serverCreate(30, 100, 100, Server.ServerStatus.ACTIVE);

        assertEquals(startSize + 1, dataCenterService.getDataCenter().getServers().size());
    }

    @Test
    @DisplayName("ServerRemove")
    void serverRemove() {
        Set<Server> servers = dataCenterService.getDataCenter().getServers();
        int startSize = servers.size();

        dataCenterService.serverRemove(servers.iterator().next());

        assertEquals(startSize - 1, dataCenterService.getDataCenter().getServers().size());
    }

    @Test
    @DisplayName("AllocateResources")
    void allocateResources() {
        double load = 30;
        double oldTotalLoad = dataCenterService.getTotalLoad();
        ResourceRequest request = new ResourceRequest(load);
        dataCenterService.allocateResources(request);
        double totalLoad = dataCenterService.getTotalLoad();
        assertEquals(oldTotalLoad + load, totalLoad);
    }

    @Test
    @DisplayName("ReleaseResources")
    void releaseResources() {
        double load = 20;
        double totalLoad = dataCenterService.getTotalLoad();
        ResourceRequest request = new ResourceRequest(load);
        dataCenterService.releaseResources(request);
        assertEquals(totalLoad - load, dataCenterService.getTotalLoad());
    }

    @Test
    @DisplayName("Optimize")
    void optimize() {
        Set<Server> servers = dataCenterService.getDataCenter().getServers();

        long oldActiveSize = servers.stream().filter(server -> server.getStatus() == Server.ServerStatus.ACTIVE).count();
        long oldSleepSize = servers.stream().filter(server -> server.getStatus() == Server.ServerStatus.SLEEP).count();

        dataCenterService.optimize(dataCenterService.getDataCenter());
    }
}