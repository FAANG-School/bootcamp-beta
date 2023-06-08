package ru.faang.school.hashmap.task_2;

import javax.swing.plaf.synth.SynthEditorPaneUI;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private final static Map<Book, String> library = new HashMap<>();

    public static void addBookToLibrary(Book book, String location) {
        if (library.containsKey(book)) {
            System.out.println("Ну и приколы - абсолютно две одинаковые книги! Не может такое быть :)");
        } else {
            library.put(book, location);
            System.out.println(String.format("Книгу \"%s\" положили на %s полку", book.getTitle(), location));
        }
    }

    public static void removeBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (library.containsKey(book)) {
            library.remove(book);
            System.out.println(String.format("Книга %s автор %s год %d удалена", title, author, year));
        } else {
            System.out.println("Такой книги нет - ничего не удалили");
        }
    }

    public static void findBook(String title, String author, int year) {
        Book book = new Book(title, author, year);
        if (library.containsKey(book)) {
            System.out.println(String.format("Книга находится %s", library.get(book)));
        } else {
            System.out.println("Такой книги нет в библиотеке");
        }
    }

    public static void printAllBooks() {
        for (Map.Entry<Book, String> book: library.entrySet()) {
            System.out.println(book + " Местонахождение: " + book.getValue());

        }
    }

    public static void main(String[] args) {
        Book book1 = new Book("Мастер и Маргарита", "Михаил Булгаков", 1929);
        Book book2 = new Book("Собачье сердце", "Михаил Булгаков", 1925);
        Book book3 = new Book("Ревизор", "Николай Гоголь", 1836);
        Book book4 = new Book("Отцы и дети", "Иван Тургенев", 1860);
        Book book5 = new Book("Мастер и Маргарита", "Михаил Булгаков", 1929);

        addBookToLibrary(book1, "5");
        addBookToLibrary(book5, "10");
        addBookToLibrary(book3, "124");
        printAllBooks();

        removeBook("asdlas", "dals;kd", 100);
        removeBook("Ревизор", "Николай Гоголь", 1836);
        printAllBooks();

    }
}
