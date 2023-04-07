package ru.faang.school.hashmap.task_2;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private static final Map<Book, String> bookMap = new HashMap<>();

    public static void main(String[] args) {

        Book first = new Book("first", "me", 2000);
        Book second = new Book("second", "he", 3000);
        Book martini = new Book("Martini", "Martin", 1000);

        add(first, "1");
        add(second, "100");
        add(martini, "5");

        remove("second", "he", 3000);

        getInfo("Martini", "Martin", 1000);

        printAll();
    }

    private static void add(Book book, String shelf) {
        bookMap.put(book, shelf);
    }

    private static void remove(String title, String author, int year) {
        bookMap.remove(new Book(title, author, year));
    }

    private static void getInfo(String title, String author, int year) {
        System.out.println(bookMap.get(new Book(title, author, year)));
    }

    private static void printAll() {
        bookMap.forEach((book, s) -> System.out.println(book.toString() + " : " + s));
    }
}
