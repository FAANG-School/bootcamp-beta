package ru.faang.school.hashmap.task_2;

import java.util.HashMap;
import java.util.Map;

public class BookDAO {
    private final Map<Book, String> books = new HashMap<>();

    public void add(Book book, String location) {
        checkIsValid(book, location);
        books.put(book, location);
    }

    public void remove(String title, String author, int year) {
        Book book = find(title, author, year);
        books.remove(book);
    }

    public Book find(String title, String author, int year) {
        checkIsValid(title, author);
        Book book = books
                .keySet()
                .stream()
                .filter(b -> b.getTitle().equals(title)
                        && b.getAuthor().equals(author)
                        && b.getYear() == year)
                .findAny().orElseThrow(BookNotFoundException::new);

        print(book, books.get(book));
        return book;
    }

    private void checkIsValid(String title, String author){
        if((title == null || title.isEmpty()) || (author == null || author.isEmpty()))
            throw new IllegalArgumentException();
    }

    private void checkIsValid(Book book, String location){
        if (book == null || (location == null || location.isEmpty()))
            throw new IllegalArgumentException();
    }

    public void printAll(){
        books.forEach(this::print);
    }

    private void print(Book book, String location){
        System.out.println(book + ", Shelve: " + location);
    }
}
