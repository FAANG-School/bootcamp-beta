package ru.faang.school.hashmap.task_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static final Map<Book, Integer> bookMap;

    static {
        bookMap = new LinkedHashMap<>();

        try (Scanner scanner = new Scanner(
                new File("src/main/java/ru/faang/school/hashmap/task_2/sample.csv"));) {
            scanner.useDelimiter("\n");
            while (scanner.hasNext()) {
                String[] book = scanner.next().split(";");
                bookMap.put(new Book(book[0], book[1], Integer.parseInt(book[2])), (int) (Math.random() *  5) + 1);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        printAllBooks();
        System.out.println();

        addBook(new Book("My Book 1","Danil Pudovkin", 2023), 1);
        addBook(new Book("My Book 2","Danil Pudovkin", 2022), 2);
        addBook(new Book("My Book 3","Danil Pudovkin", 2021), 3);
        printAllBooks();
        System.out.println();

        delBook("A Game of Thrones", "George R. R. Martin", 1996);
        delBook("A Clash of Kings", "George R. R. Martin", 1998);
        delBook("A Storm of Swords", "George R. R. Martin", 2000);
        printAllBooks();
        System.out.println();

        findAndPrintBookInfo("My Book 3","Danil Pudovkin", 2021);
        findAndPrintBookInfo("Kingdom of Ash","Sarah J. Maas", 2022);
        findAndPrintBookInfo("The Eye of the World","Robert Jordan", 1990);
    }

    private static void addBook(Book book, int shelfNumber) {
        bookMap.put(book, shelfNumber);
    }

    private static void delBook(String title, String author, int year) {
        bookMap.remove(new Book(title, author, year));
    }

    private static void findAndPrintBookInfo(String title, String author, int year) {
        Book book = new Book(title, author, year);
        System.out.println(book + ": Shelf = " + bookMap.get(book));
    }

    private static void printAllBooks() {
        bookMap.forEach((k, v) -> System.out.println(k + ": Shelf = " + v));
    }
}
