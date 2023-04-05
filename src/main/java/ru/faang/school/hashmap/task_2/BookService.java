package ru.faang.school.hashmap.task_2;

import java.util.Map;

public class BookService {
    public static void removeBook(Map<Book, String> map, Book book) {

        if (!map.containsKey(book)) {
            System.out.println(book.getTitle() + " не найдена в библиотеке");
            return;
        }

        for (Map.Entry<Book, String> entry : map.entrySet()) {
            Book target = entry.getKey();

            if (target.hashCode() == book.hashCode()) {
                map.remove(target);
                System.out.println(target.getTitle() + " удалена");
                break;
            }
        }

    }

    public static void getBookInfo(Map<Book, String> map, Book book) {

        if (!map.containsKey(book)) {
            System.out.println(book.getTitle() + " не найдена в библиотеке");
            return;
        }

        for (Map.Entry<Book, String> entry : map.entrySet()) {
            Book target = entry.getKey();

            if (target.equals(book)) {
                System.out.println(target.toString() + " находится на полке " + entry.getValue());
                break;
            }
        }
    }

    public static void getAllBooksInfo(Map<Book, String> map) {
        System.out.println("Список книг в нашей библиотеке:");
        for (Map.Entry<Book, String> entry : map.entrySet()) {
            Book book = entry.getKey();
            System.out.println(book.toString() + " Находится на полке " + entry.getValue());
        }
    }
}
