package ru.faang.school.hashmap.task_2;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Main {
    public static final String NOT_FOUND = "The book \"%s\" not found in library \n";
    private static final String BOOK_LOCATION = "The \"%s\" is in %s.\n";

    public static Map<Book, String> library = new HashMap<>();

    static {
        library.put(new Book("The Red Book", "Unknown", 2), "Archive 3");
        library.put(new Book("The Nine Voyages", "Maester Mathis", 1), "Archive 0");
        library.put(new Book("Fire Upon the Grass", "Terrio Erastes", 3), "Archive 1");
    }

    public static void main(String[] args) {
        addNewBook(new Book("Passages of the Dead", "Maester Kennet", 1), "Archive 7");
        deleteBook("Fire Upon the Grass", "Terrio Erastes", 3);
        deleteBook("1","2", 4);
        findBook("Passages of the Dead", "Maester Kennet", 1);
        printLibrary();
    }

    public static void addNewBook(Book book, String location) {
        library.put(book, location);
        System.out.printf("The book \"%s\" has been added to %s \n", book.getTitle(), location);
    }

    public static void deleteBook(String title, String author, int year) {
        Book current = new Book(title, author, year);
        if (library.containsKey(current)) {
            String location = library.get(current);
            library.remove(current);
            System.out.printf("The book \"%s\" has been removed from %s \n", current.getTitle(), location);
        }else{
            System.out.printf(NOT_FOUND, current.getTitle());
        }
    }

    public static void findBook(String title, String author, int year) {
        Book current = new Book(title, author, year);
        if (library.containsKey(current)) {
            String location = library.get(current);
            System.out.printf(BOOK_LOCATION, current.getTitle(), location);
        }else{
            System.out.printf(NOT_FOUND, current.getTitle());
        }
    }
    public static void printLibrary(){
        System.out.println("***");
        library.entrySet().stream().forEach(entry -> System.out.printf(BOOK_LOCATION, entry.getKey(), entry.getValue()));
        System.out.println("***");
    }
}
