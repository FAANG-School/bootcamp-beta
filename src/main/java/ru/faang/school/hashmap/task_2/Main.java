package ru.faang.school.hashmap.task_2;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private final Map<Book, String> bookMap = new HashMap<>();

    public Map<Book, String> getBookMap() {
        return bookMap;
    }

    public void addBook(final Book book, final String shelfNumber) {
        if (shelfNumber == null || shelfNumber.isBlank()) {
            throw new IllegalArgumentException("shelfNumber cannot be null or empty");
        }
        bookMap.putIfAbsent(book, shelfNumber);
    }

    public void removeBook(final Book book) {
        if (book == null) {
            throw new IllegalArgumentException("book cannot be null");
        }
        bookMap.remove(book);
    }

    public String getShelfByBook(final Book book) {
        if (book == null) {
            throw new IllegalArgumentException("book cannot be null");
        }
        return bookMap.get(book);
    }

    public void printAllBooks() {
        bookMap.forEach((k, v) -> System.out.println(k + ": Shelf = " + v));
    }
}
