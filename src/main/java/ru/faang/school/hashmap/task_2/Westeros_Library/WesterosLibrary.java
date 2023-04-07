package ru.faang.school.hashmap.task_2.Westeros_Library;

import java.util.HashMap;
import java.util.Map;

public class WesterosLibrary {

    public static void main(String[] args) {
        addBook(new Book("1984", "Джордж Оруэлл", 1949), "C-9");
        addBook(new Book("Мастер и Маргарита", "Михаил Булгаков", 1966), "Q-2");
        addBook(new Book("Война и мир", "Лев Толстой", 1869), "A-7");
        addBook(new Book("Маленький принц", "Антуан де Сент-Экзюпери", 1943), "k-4");
        addBook(new Book("Гарри Поттер и философский камень", "Джоан Роулинг", 1997), "B1");

        System.out.println(getBookInfo("1984", "Джордж Оруэлл", 1949) + "\n");
        System.out.println(getAllBooksInfo());
        removeBook("Война и мир", "Лев Толстой", 1869);
        System.out.println(getAllBooksInfo());
    }

    private static final Map<Book, String> Books = new HashMap<>();

    static void addBook(Book book, String location) {
        Books.put(book, location);
    }

    static void removeBook(String name, String author, int year) {
        if (validation(new Book(name, author, year))) {
            return;
        }
        Books.remove(new Book(name, author, year));
    }

    static String getBookInfo(String name, String author, int year) {
        if (validation(new Book(name, author, year))) {
            return "";
        }
        return Books.get(new Book(name, author, year));

    }

    static String getAllBooksInfo() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Book, String> entry : Books.entrySet()) {
            sb.append(entry.getKey().toString()).append(" : ").append(entry.getValue()).append("\n");
        }
        return sb.toString();
    }

    static boolean validation(Object obj) {
        if (!Books.containsKey(obj)) {
            System.out.println("This book does not exist in the library!");
            return true;
        }
        return false;
    }
}
