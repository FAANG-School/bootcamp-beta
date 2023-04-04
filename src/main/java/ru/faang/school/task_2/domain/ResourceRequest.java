package ru.faang.school.task_2.domain;

import java.util.Objects;

public class ResourceRequest {

    private final double load;

    public ResourceRequest(double load) {
        this.load = load;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResourceRequest request = (ResourceRequest) o;
        return Double.compare(request.load, load) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(load);
    }

    @Override
    public String toString() {
        return "ResourceRequest{" +
                "load=" + load +
                '}';
    }

    public double getLoad() {
        return load;
    }
}
