package ru.faang.school.hashmap.task_2.AlexTtkn_task_2;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<Book, String> map = new HashMap<>();
    public static void main(String[] args) {
        map.put(new Book("Harry Potter and philosophic stone", "J. Rowling", 1997), "Полка 1");
        map.put(new Book("Колобок", "А. Н. Афанасьева",1873), "Полка 10");
        map.put(new Book("Horror", "S. King",1983), "Полка 13");

    }
    public static void addBook(Book book, String shelf) {
        map.put(book, shelf);
    }

    public static void deleteBook(String title, String author, int year) {
        Book check = new Book(title, author, year);
        Book deleteBook = null;
        for (Book book : map.keySet()) {
            if (book.getAuthor().equals(check.getAuthor()) && book.getTitle().equals(check.getTitle()) && book.getYear() == check.getYear()) {
                deleteBook = check;
            }
        }
        if (deleteBook != null) {
            map.remove(deleteBook);
        }
    }

    public static void searchBook(String title, String author, int year) {
        Book check = new Book(title, author, year);
        Book searchBook = null;
        for (Book book : map.keySet()) {
            if (book.getAuthor().equals(check.getAuthor()) && book.getTitle().equals(check.getTitle()) && book.getYear() == check.getYear()) {
                searchBook = check;
            }
        }
        if (searchBook != null) {
            System.out.println(map.get(searchBook));
        }
    }

    public static void getBooks() {
        for (Map.Entry<Book,String> entry : map.entrySet()) {
            System.out.println(entry.getKey().getTitle() + ", " + entry.getKey().getAuthor() + ", " +
                    entry.getKey().getYear() + ", Находиться на: " + entry.getValue());
        }
    }
}
