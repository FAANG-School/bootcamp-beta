package ru.faang.school.hashmap.task_2;

import java.util.HashMap;
import java.util.Map;

public class Main {
    static Map<Book, String> library = new HashMap<>();

    static {
        library.put(new Book("Дети капитана Гранта", "Жюль Верн", 1996), "полка 1");
        library.put(new Book("15-летний капитан", "Жюль Верн", 1996), "полка 2");
        library.put(new Book("Остров сокровищ", "Р. Л. Стивенсон", 1996), "полка 17");
    }

    public static void main(String[] args) {

        addBook("Это я, Эдичка", "Э. Лимонов", 2000, "мусорка");
        addBook("Дети капитана Гранта", "Жюль Верн", 1996, "полка 4");

        removeBook("Остров сокровищ", "Р. Л. Стивенсон", 1996);

        findBook("Дети капитана Гранта", "Жюль Верн", 1996);
        findBook("Дети капитана Гранта", "Жюль Верн", 3000);

        printAllBooks();
    }

    public static void addBook(String title, String author, int year, String shelfNumber) {
        library.put(new Book(title, author, year), shelfNumber);
    }

    public static void removeBook(String title, String author, int year) {
        library.remove(new Book(title, author, year));
    }

    public static void findBook(String title, String author, int year) {
        Book bookToFind = new Book(title, author, year);
        System.out.println(bookToFind +
                (library.containsKey(bookToFind) ? " расположена: " + library.get(bookToFind) : " отсутствует"));
    }

    public static void printAllBooks() {
        for (Book book : library.keySet()) {
            System.out.println(book + " расположена: " + library.get(book));
        }
    }
}
