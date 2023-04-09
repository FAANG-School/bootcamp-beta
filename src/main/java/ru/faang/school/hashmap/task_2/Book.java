package ru.faang.school.hashmap.task_2;

import java.util.Objects;

public class Book {
    private String title;
    private String author;
    private Integer year;

    public Book(String title, String author, Integer year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getInfo() {
        return title + " " + author + " " + year;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return title.equals(book.title) && author.equals(book.author) && year.equals(book.year);
    }

    @Override
    public int hashCode() {
        return 21 * Objects.hash(title, author, year);
    }
}
