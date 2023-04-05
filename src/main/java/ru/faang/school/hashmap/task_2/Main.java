package ru.faang.school.hashmap.task_2;


import java.util.HashMap;
import java.util.Map;

public class Main {


    public static void main(String[] args) {
        Map<Book, String> libraryMap = new HashMap<>();

        // 0. Добавление информации о книгах в HashMap
        libraryMap.put(new Book("Игра Престолов", "Джордж Мартин", 1996), "Шкаф 1, Полка 2");
        libraryMap.put(new Book("Код да Винчи", "Дэн Браун", 2003), "Шкаф 2, Полка 1");
        libraryMap.put(new Book("1984", "Джордж Оруэлл", 1949), "Шкаф 3, Полка 2");

        // 1. Добавление новой книги
        addNewBook(libraryMap);

        // 2. Удаление книги по ее названию, автору и году издания
        deleteBookByTitleAuthorYear(libraryMap);

        // 3. Поиск книги и вывод информации о ее местонахождении в библиотеке
        findSingleBook(libraryMap);

        // 4. Вывод списка всех книг и их местонахождения в библиотеке
        findAllBooks(libraryMap);
    }

    private static void addNewBook(Map<Book, String> libraryMap) {
        libraryMap.put(new Book("Властелин Колец", "Дж. Р. Р. Толкин", 1954), "Шкаф 2, Полка 2");
    }

    private static void deleteBookByTitleAuthorYear(Map<Book, String> libraryMap) {
        System.out.println("Удаление книги по ее названию, автору и году издания...");
        System.out.println();
        Book bookToRemove = new Book("1984", "Джордж Оруэлл", 1949);
        libraryMap.remove(bookToRemove);
        System.out.println("Книга удалена.");
        System.out.println();
    }

    private static void findSingleBook(Map<Book, String> libraryMap) {
        System.out.println("Поиск книги и вывод информации о ее местонахождении в библиотеке...");
        System.out.println();
        Book bookToFind = new Book("Игра Престолов", "Джордж Мартин", 1996);
        if (libraryMap.containsKey(bookToFind)) {
            System.out.println("Книга найдена: ");
            System.out.println("Книга '" + bookToFind.getTitle() + "' Хранится : " + libraryMap.get(bookToFind));
        } else {
            System.out.println("Книга не найдена");
        }
        System.out.println();
    }

    private static void findAllBooks(Map<Book, String> libraryMap) {
        System.out.println("Вывод списка всех книг и их местонахождения в библиотеке...");
        System.out.println();
        for (Map.Entry<Book, String> entry : libraryMap.entrySet()) {
            System.out.println(entry.getKey().toString() + " Хранится : " + entry.getValue());
        }
    }

}
