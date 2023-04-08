package ru.faang.school.hashmap.task_2;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Main {

    private static final Map<Book, String> BOOK_MAP = new HashMap<>();

    public static void main(String[] args) {
        addBook("Effective Java", "Joshua Bloch", 2001, "shelf #1");
        addBook("Java Concurrency in Practice", "Brian Goetz", 2006, "shelf #2");
        addBook("Head First Java", "Bert Bates", 2003, "shelf #1");
        addBook("Head First Java", "Bert Bates", 2003, "shelf #5");

        removeBook("Effective Java", "Joshua Bloch", 2001);
        removeBook("Effective Java", "Joshua Bloch", 2001);

        findBook("Head First Java", "Bert Bates", 2003);
        findBook("Head First Java", "Bert Bates", 3003);

        printAll();
    }

    public static void addBook(String title, String author, Integer year, String position) {
        Book book = new Book(title, author, year);
        if (!BOOK_MAP.containsKey(book)) {
            BOOK_MAP.put(book, position);
        } else {
            System.out.println(book + " already exists!");
        }
    }

    public static void removeBook(String title, String author, Integer year) {
        Book book = new Book(title, author, year);
        if (BOOK_MAP.remove(book) == null) {
            System.out.println("There's no such book: " + book);
        }
    }

    public static void findBook(String title, String author, Integer year) {
        Book bookToFind = new Book(title, author, year);
        String destination = Optional.ofNullable(BOOK_MAP.get(bookToFind))
                .orElse("not found!");

        System.out.printf("Destination of book %s: %s\n", bookToFind, destination);
    }

    public static void printAll() {
        BOOK_MAP.forEach((book, dest) -> System.out.printf("Destination of book %s: %s\n", book, dest));
    }
}
