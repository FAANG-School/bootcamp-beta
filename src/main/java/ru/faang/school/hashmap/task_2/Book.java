package ru.faang.school.hashmap.task_2;

import java.util.Objects;

public class Book {
    private final String title;
    private final String author;
    private final Integer year;


    public Book(String title,String author,int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }
    @Override
    public boolean equals (final Object obj){
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Book)) {
            return false;
        }
        Book o = (Book) obj;
        return Objects.equals(title, o.title) &&
                Objects.equals(author, o.author) &&
                year == o.year;
    }
    @Override
    public int hashCode() {
        return Objects.hash(title, author, year);
    }

    public Boolean same_book(String title,String author,int year){
        return Objects.equals(this.title, title) &&
                Objects.equals(this.author, author) &&
                this.year == year;
    }
    public String getInfo() {
        return String.format("Крига %s автора %s (выпущенная в %d). ", title, author,year);
    }
}
