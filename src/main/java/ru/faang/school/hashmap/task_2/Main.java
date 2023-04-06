package ru.faang.school.hashmap.task_2;

import java.util.HashMap;
import java.util.Map;

public class Main {
    static Map<Book,String> books = new HashMap<>();

    public static void addBook(String title, String author, int year, int shelf) {
        Book book = new Book(title.toLowerCase(),author.toLowerCase(),year);
        books.put(book, String.valueOf(shelf));
    }

    public static void deleteBook(String title, String author, int year) {
        books.remove(new Book(title.toLowerCase(),author.toLowerCase(),year));
    }

    public static void findBook(String title, String author, int year) {
        Book book = new Book(title.toLowerCase(),author.toLowerCase(),year);
        if(books.containsKey(book)) {
            System.out.println(books.get(book));
        } else {
            System.out.println("Book is not found");
        }
    }

    public static void printAll() {
        for(var entry : books.entrySet()) {
            System.out.println(entry.getKey() + " : shelf=" + entry.getValue());
        }
    }

    public static void main(String[] args) {
        addBook("Idiot", "Dostoevsky", 1868, 1);
        addBook( "Atlas Shrugged", "Ayn Rand", 1957, 2);
        addBook("Kolobok","", 1,3);
        addBook("Avengers", "marvel", 2000, 4);
        findBook("komiks","MARVEL", 2000);
        deleteBook("kolobok", "",1);
        printAll();
    }
}
