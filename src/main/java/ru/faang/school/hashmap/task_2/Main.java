package ru.faang.school.hashmap.task_2;

import java.util.HashMap;

public class Main {
    private static final HashMap<Book, String> library = new HashMap<>();

    public static void main(String[] args) {
        put(new Book("Clean code", "Robert Martin", 2008), "Top shelf");
        put(new Book("System Design Interview", "Alex Xu", 2020), "Medium shelf");
        put(new Book("Algorithms. Construction and analysis.", "Thomas H. Corman, Charles E. Lazerson",
                2009), "Lower shelf");

        printAllBooksAndTheirLocations();

        System.out.println(getBookByTitleAuthorAndYear("System Design Interview", "Alex Xu",
                2020).toString());

        remove("Clean code", "Robert Martin", 2008);

        printAllBooksAndTheirLocations();
    }

    private static void put(Book book, String location) {
        library.put(book, location);
    }

    private static void remove(String title, String author, int year) {
        Book other = new Book(title, author, year);
        Book searchedBook = null;
        for (Book book : library.keySet()) {
            if(other.hashCode() == book.hashCode() && other.equals(book)) {
                searchedBook = book;
            }
        }
        if(searchedBook != null) {
            library.remove(searchedBook);
        }
    }

    private static Book getBookByTitleAuthorAndYear(String title, String author, int year) {
        Book other = new Book(title, author, year);
        Book searchedBook = null;
        for (Book book : library.keySet()) {
            if(other.hashCode() == book.hashCode() && other.equals(book)) {
                System.out.println(library.get(book));
                searchedBook = book;
            }
        }
        return searchedBook;
    }

    private static void printAllBooksAndTheirLocations() {
        for (Book book : library.keySet()) {
            System.out.println("Book: " + book.toString() + ", location: " + library.get(book));
        }
    }
}
