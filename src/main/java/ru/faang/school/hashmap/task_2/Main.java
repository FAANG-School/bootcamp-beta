package ru.faang.school.hashmap.task_2;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<Book, String> books = new HashMap<>();

    public static void addBook(Book book, String location) {
        books.put(book, location);
    }

    public static void removeBook(String title, String author, Integer year) {
        books.remove(new Book(title, author, year));
    }

    public static void printBook(String title, String author, Integer year) {
        System.out.println(books.get(new Book(title, author, year)));
    }

    public static void printAllBooks() {
        for (Map.Entry<Book, String> map : books.entrySet()) {
            System.out.println("Information: " + map.getKey().getInfo());
            System.out.println("Location: " + map.getValue());
        }
    }

    public static void main(String[] args) {
        addBook(new Book("Name1", "I", 2043), "first shelf");
        addBook(new Book("Name2", "You", 2023), "second shelf");
        addBook(new Book("Name3", "They", 2054), "third shelf");
        printBook("Name2", "You", 2023);
        removeBook("Name2", "You", 2023);
        printAllBooks();
    }
}
