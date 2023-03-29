package ru.faang.school.task_2.exceptions;

public class NoBusyResourcesException extends Exception {
    public NoBusyResourcesException() {
        super("No more allocated resources");
    }
}