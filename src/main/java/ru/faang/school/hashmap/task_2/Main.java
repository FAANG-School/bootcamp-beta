package ru.faang.school.hashmap.task_2;

import java.util.HashMap;

public class Main {
    static HashMap<Book,String> library = new HashMap<>();
    public static void main(String[] args) {


        Book book = new Book("Five bangs", "Tom Jim", 1243);
        Book book2 = new Book("Five bangs", "Tom Jim", 1243);


        library.put(book,"третья полка");
        library.put(new Book("Dizzy busy","Crazy Frog", 1324), "десятая полка");
        library.put(new Book("Hotster","Tom Cruze", 1344), "десятая полка");
        library.put(new Book("DSword of honor","Crazy Frog", 1224), "первая полка");
        library.put(new Book("Boss","Tom Jim", 1124), "сто третья полка");
        library.put(new Book("Henderson","Crazy Frog", 1332), "вторая полка");

        searchBook("Hotster","Tom Cruze", 1344);

        System.out.println(book.equals(book2));
        delBook("Boss","Tom Jim", 1124);

        library.entrySet().stream().forEach(i -> {
            System.out.println("Key: " + i.getKey() + "\nValue: " + i.getValue() );
        });


    }





    public void addNewBook(Book book, String place){
        library.put(book,place);
    }

    public static void delBook(String name, String author, int year){
        Book delBook = new Book(name,author,year);
        for (var book: library.keySet()){
            if (book.equals(delBook)) {
                library.remove(book);
            }
        }
    }

    public static void searchBook(String name, String author, int year) {
        Book searchBook = new Book(name, author, year);
        for (var book : library.keySet()) {
            if (book.equals(searchBook)) {
                System.out.println(book.toString());
            }
        }
    }

}