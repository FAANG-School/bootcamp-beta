package ru.faang.school.task_2.data;

import ru.faang.school.task_2.server.Server;

public class ResourceRequest {
    private final double load;
    public ResourceRequest(double load) {
        this.load = load;
    }

    public double getLoad() {
        return load;
    }
}
