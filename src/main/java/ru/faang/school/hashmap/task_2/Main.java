package ru.faang.school.hashmap.task_2;

import ru.faang.school.hashmap.task_1.House;

import java.util.*;

public class Main {
    public static final Map<Book, String> map = new HashMap<>();

    public static void main(String[] args) {
        Book Harry_Potter = new Book("Harry Potter", "Joanne Rowling", 1998);
        Book Moby_Dick = new Book("Moby-Dick", "Herman Melville", 1851);
        Book War_and_Peace = new Book("War and Peace", "Leo Tolstoy", 1996);

        map.put(Harry_Potter, "второй ряд, четвёртая полка");
        map.put(Moby_Dick, "восьмой ряд, вторая полка");
        map.put(War_and_Peace, "первый ряд, первая полка");

        all_books();
        new_book(new Book("Test","Test",-1),"Test Test Test");
        delete_book("Harry Potter", "Joanne Rowling", 1998);
        find_book("War and Peace", "Leo Tolstoy", 1996);
        all_books();

    }

    private static void new_book(Book book, String location) {
        map.put(book, location);
    }

    private static void delete_book(String title, String author, Integer year) {
        Iterator<Book> iter = map.keySet().iterator();
        while (iter.hasNext()) {
            Book book = iter.next();
            if (book.same_book(title, author, year)) {
                iter.remove();
            }
        }
    }

    private static String find_book(String title, String author, Integer year) {
        for (Book book : map.keySet()) {
            if (book.same_book(title, author, year))
                return book.getInfo() + map.get(book);
        }
        return String.format("Книги c названием %s нет", title);
    }

    private static void all_books() {
        if (map.size() == 0) {
            System.out.println("Пока книг нет :(");
            return;
        }
        for (Book book : map.keySet()) {
            System.out.println(book.getInfo() + "Местоположение - " + map.get(book));
        }

    }
}
