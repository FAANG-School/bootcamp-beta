package ru.faang.school.task_2.exceptions;

public class NoAvailableResourcesException extends Exception {
    public NoAvailableResourcesException() {
        super("No available resources to handle the request");
    }

    public NoAvailableResourcesException(String message) {
        super(message);
    }
}