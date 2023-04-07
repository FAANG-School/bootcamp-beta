package ru.faang.school.hashmap.task_2;

public record Book(String title, String author, int year) {
    public Book {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("title cannot be null or empty");
        }
        if (author == null || author.isBlank()) {
            throw new IllegalArgumentException("author cannot be null or empty");
        }
        if (year <= 0) {
            throw new IllegalArgumentException("year cannot be <= 0");
        }
    }
}
