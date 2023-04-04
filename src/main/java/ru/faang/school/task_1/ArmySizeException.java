package ru.faang.school.task_1;

public class ArmySizeException extends RuntimeException {
    public ArmySizeException() {
        super("Army size can not be more than 7");
    }
}
