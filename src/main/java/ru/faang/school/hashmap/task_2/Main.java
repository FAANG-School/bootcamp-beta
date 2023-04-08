package ru.faang.school.hashmap.task_2;

import java.util.HashMap;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        Map<Book, String> map = new HashMap<>();
        add(map, "1984", "Джордж Оурелл", 1943, "полка 1");
        add(map, "Скотный двор", "Джордж Оурелл", 1958, "полка 2");
        add(map, "Бойцовский клуб", "Чак Палланик", 1982, "полка 3");
        showAll(map);
        remove(map, "1984", "Джордж Оурелл", 1943);
        showAll(map);
        search(map, "Бойцовский клуб", "Чак Палланик", 1982);

    }

    public static void add(Map<Book, String> bookMap, String bookTitle, String bookAuthor, int bookYear, String bookPosition) {
        bookMap.put(new Book(bookTitle, bookAuthor, bookYear), bookPosition);
    }

    public static void remove(Map<Book, String> bookMap, String bookTitle, String bookAuthor, int bookYear) {
        Book book = new Book(bookTitle, bookAuthor, bookYear);
        bookMap.remove(book);
    }

    public static void search(Map<Book, String> bookMap, String bookTitle, String bookAuthor, int bookYear) {
        Book book = new Book(bookTitle, bookAuthor, bookYear);
        System.out.println(bookMap.get(book));
        System.out.println();
    }

    public static void showAll(Map<Book, String> bookMap) {
        for (Map.Entry<Book, String> bookStringEntry : bookMap.entrySet()) {
            System.out.println(bookStringEntry.getKey() + "\n" + "Местоположение: " + bookStringEntry.getValue());
            System.out.println();
        }
    }
}
