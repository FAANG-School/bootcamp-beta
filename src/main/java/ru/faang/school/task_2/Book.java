package ru.faang.school.task_2;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Book {
    private String title;
    private String author;
    private short year;

    public Book(String title, String author, short year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public short getYear() {
        return year;
    }

    public void setYear(short year) {
        this.year = year;
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

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title +
                ", author='" + author +
                ", year=" + year +
                "'} shelf =  "
                ;
    }

    public static void main (String[] args ) {
        Map<Book, String> data = new HashMap<>();

        data.put(new Book("ABC", "Tom", (short) 1900), "1");
        data.put(new Book("C++", "Richi", (short) 1980), "2");
        data.put(new Book("ABC", "Tom", (short)2000), "3");


    }

    static void addBook(Map<Book, String> data, Book book, String shelf) {
        data.put(book, shelf);
    }

    static void deleteBook(Map<Book, String> data, Book book) {
        data.remove(book);
    }

    static String findBook(Map<Book, String> data, Book book) {
        return data.get(book);
    }

    static void printAllBook(Map<Book, String> data) {
        for (Map.Entry<Book, String> d : data.entrySet()) {
            System.out.println(d.getKey() + " : " + d.getValue());
        }
    }
}
