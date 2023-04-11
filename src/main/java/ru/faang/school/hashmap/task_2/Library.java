package ru.faang.school.hashmap.task_2;

import ru.faang.school.hashmap.task_2.exception.LibraryNotEmptyException;

import java.util.HashMap;
import java.util.Map;

public class Library {
    private Map<Book, String> books = new HashMap<>();

    public boolean isBookExist(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("book cannot be null");
        }
        return books.containsKey(book);
    }

    public void addBook(final Book book, final String shelfNumber) {
        if (shelfNumber == null || shelfNumber.isBlank()) {
            throw new IllegalArgumentException("shelfNumber cannot be null or empty");
        }
        books.putIfAbsent(book, shelfNumber);
    }

    public void removeBook(final Book book) {
        if (book == null) {
            throw new IllegalArgumentException("book cannot be null");
        }
        books.remove(book);
    }

    public String getShelfByBook(final Book book) {
        if (book == null) {
            throw new IllegalArgumentException("book cannot be null");
        }
        return books.getOrDefault(book, "unknown");
    }

    public void printAllBooks() {
        books.forEach((k, v) -> System.out.println(k + ": Shelf = " + v));
    }

    public Map<Book, String> getBooks() {
        return Map.copyOf(books);
    }

    public void setBooks(Map<Book, String> books) {
        if (books == null) {
            throw new IllegalArgumentException("books cannot be null");
        }
        if (!this.books.isEmpty()) {
            throw new LibraryNotEmptyException("library is not empty");
        } else {
            this.books = books;
        }
    }
}
