package ru.faang.school.hashmap.task_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private Map<Book, String> books = new HashMap<>() {{
        put(new Book("Title1", "Author1", 2023), "1");
        put(new Book("Title2", "Author2", 2023), "1");
        put(new Book("Title3", "Author3", 2021), "2");
        put(new Book("Title4", "Author4", 2003), "3");
    }};

    public Map<Book, String> getBooks() {
        return books;
    }

    public void addNewBook(Book book, String shelfNumber) {
        books.put(book, shelfNumber);
    }

    public void deleteBook(String title, String author, int year) {
        books.entrySet().removeIf(entry -> entry.getKey().getTitle().equals(title) && entry.getKey().getAuthor().equals(author) &&
                entry.getKey().getYear() == year);
    }

    public String getBookShelfNumber(String title, String author, int year) {
        for (Map.Entry<Book, String> entry : books.entrySet()) {
            if (entry.getKey().getTitle().equals(title) && entry.getKey().getAuthor().equals(author) &&
                    entry.getKey().getYear() == year) {
                return entry.getValue();
            }
        }
        throw new IllegalArgumentException();
    }

    public List<String> getAllBooksInfo() {
        List<String> res = new ArrayList<>();
        for (Map.Entry<Book, String> entry : books.entrySet()) {
            res.add(entry.getKey() + entry.getValue());
        }
        return res;
    }
}
