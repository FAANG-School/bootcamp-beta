package ru.faang.school.hashmap.task_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public Map<Book, String> map = new HashMap<>() {{
        put(new Book("Spring in Action, 6th Edition", "Craig Walls", 2022), "1");
        put(new Book("Thinking in java", "Bruce Eckel", 2006), "4");
        put(new Book("Introduction to Algorithms", " Thomas H. Cormen", 2009), "2");
    }};

    public void addBook(Book book, String shelf) {
        map.put(book, shelf);
    }

    public void removeBook(Book book) {
        if (map.containsKey(book))
            map.remove(book);
        else
            throw new IllegalArgumentException();
    }

    public String getShelf(Book book) {
        if (map.containsKey(book))
            return map.get(book);
        else
            throw new IllegalArgumentException();
    }

    public List<String> getBooks() {
        List<String> list = new ArrayList<>();
        for (Map.Entry<Book, String> book : map.entrySet()) {
            list.add(book.getKey() + book.getValue());
        }
        return list;
    }

}
