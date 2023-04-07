package ru.faang.school.hashmap.task_2;

import ru.faang.school.hashmap.task_2.models.Book;

import java.util.Date;
import java.util.HashMap;

public class Task_2 {
    public static void main(String[] args) {
        var library = new HashMap<Book, String>();
        var alicesAdvintures = AddNewBook(library, "Alice's Adventures in Wonderland", "Lewis Carroll",
                new Date(1895, 11, 4), "23 row, 2 floor");
        var littlePrince = AddNewBook(library, "The Little Prince", "Antoine de Saint-Exupery",
                new Date(1943, 4, 1), "14 row, 1 floor");
        var whiteFang = AddNewBook(library, "White Fang", "Jack London",
                new Date(1906, 10, 1), "10 row, 1 floor");

        PrintLibraryInfo(library);
        FindBook(library, alicesAdvintures.getTitle(), alicesAdvintures.getAuthor(), alicesAdvintures.getYear());
        RemoveBook(library, alicesAdvintures.getTitle(), alicesAdvintures.getAuthor(), alicesAdvintures.getYear());
        System.out.println("\n");
        PrintLibraryInfo(library);
    }

    private static Book AddNewBook(HashMap<Book, String> library, String title, String author, Date year, String place) {
        return AddNewBook(library, new Book(title, author, year), place);
    }
    private static Book AddNewBook(HashMap<Book, String> library, Book book, String place) {
        library.put(book, place);
        return book;
    }
    private static Book RemoveBook(HashMap<Book, String> library, String title, String author, Date year) {
        var key = new Book(title, author, year);
        library.remove(key);
        return  key;
    }
    private static Book FindBook(HashMap<Book, String> library, String title, String author, Date year) {
        var key = new Book(title, author, year);
        System.out.println(library.get(key));
        return key;
    }
    private static void PrintLibraryInfo(HashMap<Book, String> library) {
        for (var entry : library.entrySet()) {
            System.out.println("\"" + entry.getKey().getTitle() + "\" : " + entry.getValue());
        }
    }
}
