package ru.faang.school.hashmap.task_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static final Map<Book, String> bookMap;

    static {
        bookMap = new LinkedHashMap<>();

        try (Scanner scanner = new Scanner(
                new File("src/main/java/ru/faang/school/hashmap/task_2/sample.csv"));) {
            scanner.useDelimiter("\n");
            while (scanner.hasNext()) {
                String[] book = scanner.next().split(";");
                bookMap.put(
                        new Book(book[0], book[1], Integer.parseInt(book[2])),
                        String.valueOf((int) (Math.random() *  5) + 1)
                );
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        printAllBooks();
        System.out.println();

        addBook(new Book("My Book 1","Danil Pudovkin", 2023), "1");
        addBook(new Book("My Book 2","Danil Pudovkin", 2022), "2");
        addBook(new Book("My Book 3","Danil Pudovkin", 2021), "3");
        addBook(new Book("rv", "vdv", 1), "1");
        printAllBooks();
        System.out.println();

        delBook(new Book("A Game of Thrones", "George R. R. Martin", 1996));
        delBook(new Book("A Clash of Kings", "George R. R. Martin", 1998));
        delBook(new Book("A Storm of Swords", "George R. R. Martin", 2000));
        printAllBooks();
        System.out.println();

        getBookShelf(new Book("My Book 3","Danil Pudovkin", 2021));
        getBookShelf(new Book("Kingdom of Ash","Sarah J. Maas", 2022));
        getBookShelf(new Book("The Eye of the World","Robert Jordan", 1990));
        getBookShelf(new Book("My book 10", "Danil Pudovkin", 2015));
    }

    private static String addBook(final Book book, final String shelfNumber) {
        if (shelfNumber == null || shelfNumber.isBlank()) {
            throw new IllegalArgumentException("shelfNumber cannot be null or empty");
        }
        return bookMap.put(book, shelfNumber);
    }

    private static String delBook(final Book book) {
        if (book == null) {
            throw new IllegalArgumentException("book cannot be null");
        }
        return bookMap.remove(book);
    }

    private static String getBookShelf(final Book book) {
        if (book == null) {
            throw new IllegalArgumentException("book cannot be null");
        }
        return bookMap.get(book);
    }

    private static void printAllBooks() {
        bookMap.forEach((k, v) -> System.out.println(k + ": Shelf = " + v));
    }
}
