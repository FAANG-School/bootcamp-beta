package ru.faang.school.task_2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.faang.school.task_2.clientInteraction.ResourceRequest;
import ru.faang.school.task_2.model.Server;
import ru.faang.school.task_2.service.DataCenterService;
import ru.faang.school.task_2.service.DataService;

@RestController
@RequestMapping("/servers")
public class DataCenterController {

    private final DataService service;

    @Autowired
    public DataCenterController(DataCenterService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addServer(@RequestBody Server server) {
        service.addServer(server);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void removeServer(@RequestBody Server server) {
        service.removeServer(server);
    }

    @GetMapping("/energy")
    @ResponseStatus(HttpStatus.OK)
    public double getTotalEnergyConsumption() {
      return service.getTotalEnergyConsumption();
    }

    @PostMapping("/resources")
    public void allocateResources(@RequestBody ResourceRequest request) {
        service.allocateResources(request);
    }

    @DeleteMapping("/resources")
    public void releaseResources(@RequestBody ResourceRequest request) {
        service.releaseResources(request);
    }

}
