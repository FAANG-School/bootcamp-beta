package ru.faang.school.hashmap.task_2;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args){
        Map<Book, String> library = new HashMap<>();
        String title, author, year;

        Book book1 = new Book("book1", "author1", "2023");
        Book book2 = new Book("book2", "author2", "2023");
        addBook(library, book1, "shelf 1");
        addBook(library, book2, "shelf 2");
        printAllBooks(library);

        System.out.println();
        searchBookInLibrary(library, "book1", "author1", "2023");

        System.out.println();
        title = "book3";
        author = "author3";
        year = "2023";
        addBook(library, title, author, year, "shelf 3");
        printAllBooks(library);
        removeBook(library, title, author, year);
        printAllBooks(library);

    }


    public static void addBook(Map<Book, String> map,
                               String title,
                               String author,
                               String year,
                               String shelf_number){
        map.put(new Book(title, author, year), shelf_number);
    }

    public static void addBook(Map<Book, String> map, Book book, String shelf_number){
        map.put(book, shelf_number);
    }

    public static void removeBook(Map<Book, String> map,
                                  String title,
                                  String author,
                                  String year){
        System.out.println("Удаление книги.");
        if (map.remove(new Book(title, author, year)) != null) {
            System.out.println("Книга успешно удалена.");
        }
        else System.out.println("Книга не была найдена.");
    }

    public static void searchBookInLibrary(Map<Book, String> map,
                                           String title,
                                           String author,
                                           String year)
    {
        if (map.isEmpty()) {
            System.out.println("Библиотека пустая, нет книг для поиска.");
            return;
        }

        Book target_book = new Book(title, author, year);
        if (map.containsKey(target_book)) {
            String res = map.get(new Book(title, author, year));
            System.out.println("Книга найдена: ");
            System.out.println(target_book + ". Место: " + res);
        }
        else System.out.println("Запрошенная книга не содержится в заданной библиотеке.");
    }

    public static void printAllBooks(Map<Book, String> map){
        System.out.println("Состояние библиотеки.");
        if (!map.isEmpty()) {
            for (Map.Entry<Book, String> i_entry:
                 map.entrySet()) {
                System.out.println("Книга: " + i_entry.getKey() + ", место на полке: " + i_entry.getValue());
            }
        }
        else System.out.println("Библиотека пустая.");
    }
}
