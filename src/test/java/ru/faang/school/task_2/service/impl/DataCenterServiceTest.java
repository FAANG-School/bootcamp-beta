package ru.faang.school.task_2.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.faang.school.task_2.domain.DataCenter;
import ru.faang.school.task_2.domain.ResourceRequest;
import ru.faang.school.task_2.domain.Server;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DataCenterServiceTest {

    private DataCenterService service;
    private DataCenter dataCenter;

    @BeforeEach
    void setup() {
        dataCenter = new DataCenter();
        service = new DataCenterService(dataCenter);
    }

    @Test
    void addServer() {
        Server server = new Server(0, 100, 4);

        service.addServer(server);

        assertTrue(dataCenter.getServers().containsKey(server));
    }

    @Test
    void deleteServer() {
        Server server1 = new Server(0, 100, 4);
        Server server2 = new Server(0, 100, 4);
        List<ResourceRequest> firstServerRequests = new ArrayList<>();
        firstServerRequests.add(new ResourceRequest(20));
        List<ResourceRequest> secondServerRequests = new ArrayList<>();
        secondServerRequests.add(new ResourceRequest(20));
        Map<Server, List<ResourceRequest>> serverListMap = new HashMap<>();
        serverListMap.put(server1, firstServerRequests);
        serverListMap.put(server2, secondServerRequests);

        dataCenter.setServers(serverListMap);
        service.deleteServer(server1);

        assertFalse(dataCenter.getServers().containsKey(server1));
        assertTrue(dataCenter.getServers().containsKey(server2));
    }

    @Test
    void getTotalEnergyConsumption() {
        dataCenter.setServers(Map.of(
                new Server(30, 100, 4), List.of(new ResourceRequest(30)),
                new Server(45, 100, 4), List.of(new ResourceRequest(45))
        ));

        assertEquals(75, service.getTotalEnergyConsumption());
    }

    @Test
    void allocateResources() {
        Server server = new Server(0, 100, 4);
        Map<Server, List<ResourceRequest>> serverListMap = new HashMap<>();
        serverListMap.put(server, new ArrayList<>());
        ResourceRequest resourceRequest = new ResourceRequest(20);

        dataCenter.setServers(serverListMap);
        service.allocateResources(resourceRequest);

        assertEquals(resourceRequest, dataCenter.getServers().get(server).get(0));
    }

    @Test
    void releaseResources() {
        Server server = new Server(0, 100, 4);
        List<ResourceRequest> serverRequests = new ArrayList<>();
        ResourceRequest resourceRequest = new ResourceRequest(20);
        serverRequests.add(resourceRequest);
        Map<Server, List<ResourceRequest>> serverListMap = new HashMap<>();
        serverListMap.put(server, serverRequests);

        dataCenter.setServers(serverListMap);
        service.releaseResources(resourceRequest);

        assertEquals(0, dataCenter.getServers().get(server).size());
    }
}