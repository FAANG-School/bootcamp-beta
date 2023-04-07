package ru.faang.school.task_2;

public class ResourceRequest {
   private final double load;

    public ResourceRequest(double load) {
        if (load < 0){ throw new RuntimeException("�� ���������� ��������");}
        this.load = load;
    }

    public double getLoad() {
        return load;
    }
}
