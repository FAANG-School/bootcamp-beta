package ru.faang.school.hashmap.task_2;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Book, String> bookMap = new HashMap<>();

        bookMap.put(new Book("Волшебный корабль", "Робин Хобб", "1999"), "3");
        bookMap.put(new Book("Ловец на хлебном поле", "Дж. Д. Сэлинджер", "1979"), "4");
        bookMap.put(new Book("Грокаем Алгоритмы", "Адитья Бхаргава", "2016"), "5");
        bookMap.put(new Book("Ещё один великолепный МИФ", "Роберт Асприн", "1978"), "5");

        bookMap.remove(new Book("Ловец на хлебном поле", "Дж. Д. Сэлинджер", "1979"));

        String shelfNumber = bookMap.get(new Book("Волшебный корабль", "Робин Хобб", "1999"));
        System.out.println("номер полки: " + shelfNumber);

        bookMap.forEach((book, s) -> System.out.println(s + " полка, " + book));
    }
}
