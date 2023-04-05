package ru.faang.school.hashmap.task_2.solution;


import java.io.IOException;
import java.util.Objects;

public class Book {
    private final String title;
    private final String author;
    private final int year;

    public Book(String title, String author, int year) throws IOException {
        this.title = title;
        this.author = author;
        if(year < 1 || year > java.time.LocalDate.now().getYear())
            throw new IOException("year must be between 1 and current year");
        this.year = year;
    }

    public Book(Book o){
        this.title = o.title;
        this.author = o.author;
        this.year = o.year;
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

    @Override
    public String toString() {
        return "Book:" +
                " title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year + ' ';
    }
}
