package ru.faang.school.hashmap.task_2;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Main {
    public static void main(String[] args) {
        Map<Book, String> map = new HashMap<>();
        addBook(map, new Book("2", "2", 2), "w");

        lookAtBooks(map);

    }
    static void addBook(Map<Book, String> map, Book book, String location) {
        map.put(book, location);
    }

    static void deleteBook(Map<Book, String> map, Book book) {
        map.remove(book);
    }

    static void findBook(Map<Book, String> map, Book book) {
        System.out.println(map.get(book));
    }

    static void lookAtBooks(Map<Book, String> map) {
        for (Map.Entry<Book, String> entry : map.entrySet()) {
            System.out.println("Title: " + entry.getKey().getTitle() +
                    ", author: " + entry.getKey().getAuthor() +
                    ", year: " + entry.getKey().getYear() + ", location "+ entry.getValue() + ";");

        }
    }

}

class Book {
    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return year == book.year && Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year);
    }
}
