package ru.faang.school.hashmap.task_2;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Как управлять Вселенной, не привлекая внимания сантиаров", "Неизвестен", 1888);
        Book book2 = new Book("Охота на крокодилов на спиннинг на средней Волге", "Крокодил Данди", 2000);
        Book book3 = new Book("Вся правда о шаурме", "Г. Тукай", 1950);
        Book book4 = new Book("Борщ как средство единения семьи", "Г. Тукай", 1952);

        Map<Book, String> map = new HashMap<>();

        BookService.addBook(map, book1, "N1");
        BookService.addBook(map, book2, "KD56");
        BookService.addBook(map, book3, "GT2");

        BookService.getAllBooksInfo(map);

        BookService.getBookInfo(map, book3);
        BookService.getBookInfo(map, book4); // будет не найдена

        BookService.removeBook(map, book3);
        BookService.removeBook(map, book4); // будет не найдена
    }
}
