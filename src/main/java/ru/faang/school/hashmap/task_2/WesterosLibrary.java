package ru.faang.school.hashmap.task_2;

import java.util.Arrays;
import java.util.HashMap;

final class WesterosLibrary {

    private final HashMap<Book, String> books = new HashMap<>();

    public WesterosLibrary() {

    }

    public void addBook(Book book, String shelf) {
        books.put(book, shelf);
    }

    public void removeBook(String title, String author, String year) {
        Book book = new Book(title, author, year);

        books.remove(book);
    }

    public String findBookshelf(String title, String author, String year) {
        Book book = new Book(title, author, year);

        return books.get(book);
    }

    public Book findBook(String title, String author, String year) {
        Book book = new Book(title, author, year);

        if (books.containsKey(book)) {
            return book;
        } else {
            return null;
        }
    }

    public void print() {
        System.out.println(Arrays.toString(books.entrySet().toArray()));
    }
}
