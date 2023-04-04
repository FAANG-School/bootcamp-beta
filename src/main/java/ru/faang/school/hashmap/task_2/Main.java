package ru.faang.school.hashmap.task_2;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private final Map<Book, String> LIBRARY = new HashMap<>();

    public void putBook(Book book, String shelfNumber) {
        LIBRARY.put(book, shelfNumber);
    }

    public void removeBook(String title, String author, String year) {
        for (Book book : LIBRARY.keySet()) {
            if (book.title.equals(title) && book.author.equals(author) && book.year.equals(year)) {
                LIBRARY.remove(new Book(title, author, year));
                return;
            }
        }
        System.out.println("The book is not found");
    }

    public void findBook(String title, String author, String year) {
        for (Book book : LIBRARY.keySet()) {
            if (book.title.equals(title) && book.author.equals(author) && book.year.equals(year)) {
                System.out.println("Book \"" + title + "\". Author \"" + author + "\". Year \"" + year + "\". On the shelf number " + LIBRARY.get(book));
                return;
            }
        }
        System.out.println("The book is not found");
    }

    public void showAllBookInfo() {
        for (Map.Entry<Book, String> entry : LIBRARY.entrySet()) {
            final Book book = entry.getKey();
            System.out.println("Book \"" + book.title + "\". Author \"" + book.author + "\". Year \"" + book.year + "\". On the shelf number " + entry.getValue());
        }
    }
}
