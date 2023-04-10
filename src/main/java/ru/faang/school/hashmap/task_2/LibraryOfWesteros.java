package ru.faang.school.hashmap.task_2;

import java.util.*;


public class LibraryOfWesteros {
    public static void main(String[] args) {
        Map<Book, String> booksMap = new HashMap<>();
        Book garryPotter = new Book("Garry Potter", "Rowling", 2004);
        Book book2 = new Book("Book 2", "Someone 1", 2015);
        Book book3 = new Book("Book 3", "Someone 1", 2016);
        put(booksMap, garryPotter, "1/1");
        put(booksMap, book2, "1/2");
        put(booksMap, book3, "1/3");
        outputAllBook(booksMap);
        search(booksMap, "Book 3", "Someone 1", 2016);
        remove(booksMap, "Book 3", "Someone 1", 2016);
    }

    public static void put(Map<Book, String> booksMap, Book book, String str){
        booksMap.put(book, str);
    }

    public static void remove(Map<Book, String> booksMap, String title, String author, int year){
        int count = 0;
        System.out.println("Remove result: ");
        for (Map.Entry<Book, String> entry : booksMap.entrySet()){
            Book book = entry.getKey();
            String bookTitle = book.getTitle();
            String bookAuthor = book.getAuthor();
            int bookYear = book.getYear();
            if(bookTitle.equals(title) && bookAuthor.equals(author) && bookYear == year){
                count++;
                System.out.println("The book " + bookTitle+ " which author is "+ bookAuthor +" and its write in " + bookYear + " is removed");
            }
        }
        if(count == 0){
            System.out.println("In this hashmap is no book with title: " + title + " and year " + year);
        }
    }

    public static void search(Map<Book, String> booksMap, String title, String author, int year){
        int count = 0;
        System.out.println("Search result: ");
        for (Map.Entry<Book, String> entry : booksMap.entrySet()){
            Book book = entry.getKey();
            String bookTitle = book.getTitle();
            String bookAuthor = book.getAuthor();
            int bookYear = book.getYear();
            if(bookTitle.equals(title) && bookAuthor.equals(author) && bookYear == year){
                count++;
                System.out.println("The book is in " + entry.getValue() + " place" );
            }
        }
        if(count == 0){
            System.out.println("In this hashmap is no book with title: " + title + " and year " + year);
        }
    }

    public static void outputAllBook(Map<Book, String> booksMap){
        int count = 0;
        System.out.println("Output result: ");
        for (Map.Entry<Book, String> entry : booksMap.entrySet()){
            Book book = entry.getKey();
            String bookTitle = book.getTitle();
            String bookAuthor = book.getAuthor();
            int bookYear = book.getYear();
            count++;
            System.out.println("Title: " + bookTitle + ", Author: " + bookAuthor + ", Year: "+ bookYear + ", Locations: " + entry.getValue());

        }
        if(count == 0){
            System.out.println("In this hashmap is no book");
        }
    }

}
