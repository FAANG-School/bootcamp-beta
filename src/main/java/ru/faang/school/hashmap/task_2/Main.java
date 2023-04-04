package ru.faang.school.hashmap.task_2;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private static Map<Book, String> books = new HashMap<>();

    public static void main(String[] args) {
        books.put(new Book("First book", "Unknown", 250), "Bookshelf №1");
        books.put(new Book("Funny book", "Famous author", 228), "Bookshelf №146");
        books.put(new Book("Old book", "John Show", 153), "Bookshelf №9");

        addBook(new Book("Mysterious book", "Strange Old Man", 1), "Bookshelf №31");

        removeBook(new Book("Funny book", "Famous author", 228));

        findBookLocation("Mysterious book", "Strange Old Man", 1);

        printAllBooks();
    }

    private static void addBook(Book book, String location) {
        books.put(book, location);
    }

    private static void removeBook(Book book) {
        books.remove(book);
    }

    private static void findBookLocation(String title, String author, int year) {
        System.out.println(books.get(new Book(title, author, year)));
    }

    private static void printAllBooks() {
        for (Map.Entry<Book, String> entry : books.entrySet()) {
            System.out.println("Book " + entry.getKey() + "Located at: " + entry.getValue());
        }
    }
}
