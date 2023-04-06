package ru.faang.school.hashmap.task_2;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Book, String> bookLibraryMap = new HashMap<>();
        Book aliceInWonderland = new Book("Alice in wonderland", "Lewis Carroll", 1995);
        Book harryPotter1 = new Book("Harry Potter and the Philosopher's Stone", "J. K. Rowling", 2001);
        Book idiot = new Book("The Idiot", "Fyodor Dostoevsky", 1965);

        addBook(bookLibraryMap, aliceInWonderland, "Стеллаж C, 3 полка");
        addBook(bookLibraryMap, harryPotter1, "Стеллаж R, 1 полка");
        addBook(bookLibraryMap, idiot, "Стеллаж D, 5 полка");
        System.out.println();
        showAllLibrary(bookLibraryMap);

        System.out.println();
        removeBook(bookLibraryMap, "The Idiot", "Fyodor Dostoevsky", 1965);
        showAllLibrary(bookLibraryMap);

        System.out.println();
        findBook(bookLibraryMap, "Harry Potter and the Philosopher's Stone", "J. K. Rowling", 2001);

        System.out.println();
        findBook(bookLibraryMap, "asd", "asd", 123);
    }

    static void addBook(Map<Book, String> map, Book book, String place) {
        map.put(book, place);
    }

    static void showAllLibrary(Map<Book, String> map) {
        for (Map.Entry<Book, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
    static void removeBook(Map<Book, String> map, String name, String author, int year) {
        map.remove(new Book(name, author, year));
    }
    static void findBook(Map<Book, String> map, String name, String author, int year) {
        Book book = new Book(name, author, year);
        String shelf = map.get(book);
        if (shelf != null) {
            System.out.println(book + " - " + shelf);
        } else {
            System.out.println("Такой книги нет в нашей библиотеке");
        }
    }
}
