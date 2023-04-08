package ru.faang.school.hashmap.task_2;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Library {

    public boolean addNewBook(Map<Book, String> map, Book book, String shelf) {
        if (!map.containsKey(book)) {
            map.put(book, shelf);
            return true;
        }
        return false;
    }

    public boolean removeBook(Map<Book, String> map, String title, String author, int year) {
        for (Map.Entry<Book, String> entry : map.entrySet()) {
            boolean equalsByTitle = entry.getKey().getTitle().equals(title);
            boolean equalsByAuthor = entry.getKey().getAuthor().equals(author);
            if (equalsByTitle && equalsByAuthor && entry.getKey().getYear() == year) {
                map.remove(entry.getKey());
                return true;
            }
        }
        return false;
    }

    public String getBookLocation(Map<Book, String> map, String title, String author, int year) {
        String location = "";
        for (Map.Entry<Book, String> entry : map.entrySet()) {
            boolean equalsByTitle = entry.getKey().getTitle().equals(title);
            boolean equalsByAuthor = entry.getKey().getAuthor().equals(author);
            if (equalsByTitle && equalsByAuthor && entry.getKey().getYear() == year) {
                location = entry.getValue();
            }
        }
        return location;
    }

    public Map<Book, String> getAllBook(Map<Book, String> map) {
        return map.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
