package ru.faang.school.hashmap.task_2;

import java.util.Objects;

public class Book {
    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }


    @Override
    public int hashCode(){
        return Objects.hash(title,author,year);
    }


    @Override
    public boolean equals(Object object) {
        Book book = (Book) object;
        return (this.title.equals(book.title) &&
                this.author.equals(book.author) &&
                this.year == book.year);
    }

    @Override
    public String toString(){
        return "Title: " + "\"" + this.title + "\" Author " + this.author + " Year " + this.year;
    }


}
