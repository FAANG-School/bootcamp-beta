package ru.faang.school.hashmap.task_2;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Main {
    private final Map<Book, String> bookMap = new HashMap<>();

    {
        bookMap.put(new Book("Title-1", "Author-1", 1970), "Shelf-1");
        bookMap.put(new Book("Title-2", "Author-2", 1971), "Shelf-2");
        bookMap.put(new Book("Title-3", "Author-3", 1972), "Shelf-3");
        bookMap.put(new Book("Title-4", "Author-4", 1973), "Shelf-4");
    }

    public static void main(String[] args) {
        Main main = new Main();

        main.addBook(new Book("Title-5", "Author-5", 1974), "Shelf-5");

        main.removeBook("Title-2", "Author-2", 1971);

        main.showBook("Title-4", "Author-4", 1973);

        main.showAllBooks();
    }

    private void addBook(Book book, String location) {
        bookMap.putIfAbsent(book, location);
    }

    private void removeBook(String title, String author, int year) {
        bookMap.remove(new Book(title, author, year));
    }

    private void showBook(String title, String author, int year) {
        String location = bookMap.get(new Book(title, author, year));
        if (Objects.isNull(location)) {
            System.out.println("Book not found");
        } else {
            System.out.println(location);
        }
    }

    private void showAllBooks() {
        if (bookMap.isEmpty()) {
            System.out.println("Books not found");
        } else {
            for (Map.Entry<Book, String> entry : bookMap.entrySet()) {
                System.out.println(entry.getKey().toString() + ' ' + entry.getValue());
            }
        }
    }
}