package ru.faang.school.task_2.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import ru.faang.school.task_2.clientInteraction.ResourceRequest;
import ru.faang.school.task_2.dataStorage.DataCenter;
import ru.faang.school.task_2.exceptions.ServerAllocateResourcesException;
import ru.faang.school.task_2.loadOptimization.LoadBalancingOptimizationStrategy;
import ru.faang.school.task_2.loadOptimization.OptimizationStrategy;
import ru.faang.school.task_2.model.Server;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;


@Service
public class DataCenterService implements DataService {

    private final Logger log = Logger.getLogger(DataCenterService.class.getName());
    private final DateTimeFormatter logTimeFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    private final DataCenter dataCenter;
    private final OptimizationStrategy optimization = new LoadBalancingOptimizationStrategy();

    @Autowired
    public DataCenterService(DataCenter dataCenter) {
        this.dataCenter = dataCenter;
    }

    public void addServer(@RequestBody Server server) {
        dataCenter.addServer(server);
        log.info(LocalDateTime.now().format(logTimeFormat) + " : Client added the server " + server);
    }

    public void removeServer(@RequestBody Server server) {
        dataCenter.removeServer(server);
        log.info(LocalDateTime.now().format(logTimeFormat) + " : Client removed the server " + server);
    }

    public double getTotalEnergyConsumption() {
        log.info(LocalDateTime.now().format(logTimeFormat) + " : Client received data on the load on the server");
        return dataCenter.getServers().stream().mapToDouble(Server::getEnergyConsumption).sum();
    }

    public void allocateResources(@RequestBody ResourceRequest request) {//для выделения ресурсов на запрос
        for (Server server : dataCenter.getServers()) {
            if ((server.getLoad() + request.getLoad() / dataCenter.getServers().size()) < server.getMaxLoad()) {
                server.addLoad(request.getLoad());
                optimization.optimize(dataCenter);
                log.info(LocalDateTime.now().format(logTimeFormat) + " : client allocated resources in server " + request.getLoad());
                return;
            }
        }
        log.info(LocalDateTime.now().format(logTimeFormat) + " : Client was unable to add load to the server because there was a shortage of resources." + "Client's load: " + request.getLoad() + " actual load " + getActualServerLoad());
        throw new ServerAllocateResourcesException("Unable to add load to the server");

    }

    private List<Double> getActualServerLoad() {
        return dataCenter.getServers().stream().map(Server::getLoad).collect(Collectors.toList());
    }

    public void releaseResources(@RequestBody ResourceRequest request) {
        double requestLoad = request.getLoad();
        for (Server server : dataCenter.getServers()) {
            double serverLoad = server.getLoad();
            if (server.releaseLoad(requestLoad) < 0) {
                requestLoad = (serverLoad - requestLoad) * -1;
                server.setLoad(0);
                optimization.optimize(dataCenter);
                log.info(LocalDateTime.now().format(logTimeFormat) + " : Client release resources in server " + request.getLoad());
            } else {
                server.releaseLoad(requestLoad);
                optimization.optimize(dataCenter);
                log.info(LocalDateTime.now().format(logTimeFormat) + " : Client release resources in server " + request.getLoad());
                return;
            }
        }
    }
}
