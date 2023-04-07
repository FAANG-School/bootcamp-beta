package ru.faang.school.hashmap.task_1;

public record House(String name, String sigil) {
    public House {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name cannot be null or empty");
        }
        if (sigil == null || sigil.isBlank()) {
            throw new IllegalArgumentException("sigil cannot be null or empty");
        }
    }
}
