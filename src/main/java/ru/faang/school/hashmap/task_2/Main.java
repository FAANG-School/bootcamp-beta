package ru.faang.school.hashmap.task_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static Map<Book, String> libraryMap = new HashMap<>();
    static {
        Book book1 = new Book("1984", "Джордж Оруэлл", 1949);
        Book book2 = new Book("Овод","Этель Лилиан Войнич", 1897);
        Book book3 = new Book("Декамерон", "Джованни Боккаччо", 1348);
        Book book4 = new Book("Три товарища", "Эрих Мария Ремарк", 1936);
        Book book5 = new Book("Американская трагедия", "Теодор Драйзер", 1925);

        libraryMap.put(book1, "полка 3");
        libraryMap.put(book2, "полка 1");
        libraryMap.put(book3, "полка 5");
        libraryMap.put(book4, "полка 3");
        libraryMap.put(book5, "полка 7");
    }

    public static void main(String[] args) {
        getAllBooksInLibrary();
        System.out.println("_________________________________");
        deleteBook("Декамерон", "Джованни Боккаччо", 1348);
        addBook(new Book("Война и мир", "Лев Николаевич Толстой", 1873));
        getAllBooksInLibrary();
        System.out.println(bookSearching("Триумфальная арка", "Эрих Мария Ремарк", 1946));
    }

    public static String addBook(Book book) {
        libraryMap.put(book, "");
        return "Книга добавлена в библиотеку";
    }

    public static String deleteBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (libraryMap.containsKey(book)) {
            libraryMap.remove(book);
            return "Книга успешно удалена";
        } else {
            return "Такой книги нет в библиотеке";
        }
    }

    public static String bookSearching(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (libraryMap.containsKey(book)) {
            return libraryMap.get(book);
        } else {
            return "Такой книги нет в библиотеке";
        }
    }

    public static List<Book> getAllBooksInLibrary() {
        List<Book> bookList = new ArrayList<>();
        for (var pair : libraryMap.entrySet()) {
            Book book = pair.getKey();
            String way = pair.getValue();
            System.out.println(book + " находится на полке " + way);
            bookList.add(book);
        }
        return bookList;
    }
}
