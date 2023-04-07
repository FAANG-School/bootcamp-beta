package ru.faang.school.hashmap.task_2;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static Map<Book, String> books = new HashMap<>();

    public static void main(String[] args) {
        books.put(new Book("1984", "Джордж Оруэлл", "1949"), "полка 1");
        books.put(new Book("451 градус по Фаренгейту", "Рэй Брэдбери", "1953"), "полка 2");
        books.put(new Book("Портрет Дориана Грея", "Оскар Уайльд", "1890"), "полка 4");
        books.put(new Book("Преступление и наказание", "Фёдор Достоевский", "1866"), "полка 4");
        System.out.println(books);
        addBook("book", "author", "year", "полка 3");
        System.out.println(books);
        deleteBook("book", "author", "year");
        System.out.println(books);
        findBook("1984", "Джордж Оруэлл", "1949");
        showAll();
    }

    public static void addBook(String title, String author, String year, String location) {
        books.put(new Book(title, author, year), location);
    }

    public static void deleteBook(String title, String author, String year) {
        books.remove(new Book(title, author, year));
    }

    public static void findBook(String title, String author, String year) {
        String location = books.get(new Book(title, author, year));
        if (location != null) {
            System.out.println("Местоположение книги: " + location);
        } else {
            System.out.println("книга не найдена");
        }
    }

    public static void showAll() {
        System.out.println("Список всех книг:");
        for (Map.Entry<Book, String> entry: books.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }


}
