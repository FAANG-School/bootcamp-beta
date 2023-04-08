package ru.faang.school.hashmap.task_3;

public record Student(String name, Faculty faculty, int year) {

    @Override
    public String toString() {
        return String.format("Student: %s, %s, studies in %d course.", name, faculty, year);
    }
}
