package ru.faang.school.task_2.datacenter.utils;

import ru.faang.school.task_2.server.ResourceRequest;
import ru.faang.school.task_2.server.Server;

@FunctionalInterface
public interface ServerLoadCalculator {
    Double apply(Server a, ResourceRequest b);
}