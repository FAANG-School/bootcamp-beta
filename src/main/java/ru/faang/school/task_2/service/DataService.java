package ru.faang.school.task_2.service;

import org.springframework.web.bind.annotation.RequestBody;
import ru.faang.school.task_2.clientInteraction.ResourceRequest;
import ru.faang.school.task_2.model.Server;

import java.util.List;

public interface DataService {

    void addServer(@RequestBody Server server);

    void removeServer(@RequestBody Server server);

    double getTotalEnergyConsumption();

    void allocateResources(@RequestBody ResourceRequest request);

    void releaseResources(@RequestBody ResourceRequest request);
}
