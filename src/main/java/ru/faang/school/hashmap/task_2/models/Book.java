package ru.faang.school.hashmap.task_2.models;

import java.util.Date;
import java.util.Objects;

public class Book {
    private final String _title;
    private final String _author;
    private final Date _year;

    public Book(String title, String author, Date year) {
        _title = title;
        _author = author;
        _year = year;
    }

    public String getTitle() {
        return _title;
    }
    public String getAuthor() {
        return _author;
    }
    public Date getYear() {
        return _year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Book book = (Book) o;
        return Objects.equals(_title, book._title) && Objects.equals(_author, book._author) && Objects.equals(_year, book._year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_title, _author, _year);
    }
}
