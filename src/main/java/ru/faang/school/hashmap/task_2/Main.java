package ru.faang.school.hashmap.task_2;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Main {
    Map<Book, String> bookshelves = new HashMap<>();

    public void putBookOnShelf(Book book, String numberOfShelf) {
        bookshelves.put(book, numberOfShelf);
    }

    public void removeBookByAttributes(String name, String author, String year) {
            Book book = new Book(name, author, year);
            if (bookshelves.remove(book) != null) {
                System.out.println("You've removed : " + book.toString());
            } else {
                System.out.println("There is no a book with these attributes");
            }
    }

    public void findBookByAttributes(String name, String author, String year) {
        Book book = new Book(name, author, year);
        if (bookshelves.containsKey(book)) {
            System.out.println("You've found : " + book.toString() + "number of shelf - " + bookshelves.get(book));
        } else {
            System.out.println("There is no a book with these attributes");
        }
    }

    public void printWholeLibrary() {
        System.out.println("\nYour library contains:");
        bookshelves.forEach((book, shelf) -> System.out.println(book + " stays at shelf number - " + shelf));
    }

    public static void main(String[] args) {


        /*library.putBookOnShelf(new Book("Core Java(TM), Volume I", "Cay S. Horstmann", "2007"), "2");
        library.removeBookByAttributes("Effective Java", "Joshua Bloch", "2011");
        library.findBookByAttributes("Java Concurrency in Practice", "Brian Goetz", "2006");
        library.printWholeLibrary();
        library.findBookByAttributes("Effective Java", "Joshua Bloch", "2011");*/
    }



}
class Book{
    final private String name;
    final private String author;
    final private String year;

    public Book(String name, String author, String year) {
        this.name = name;
        this.author = author;
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return name.equals(book.name) && author.equals(book.author) && year.equals(book.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, author, year);
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", year='" + year + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getYear() {
        return year;
    }

}