package ru.faang.school.hashmap.task_2;

import java.util.HashMap;

public class Main {
    static HashMap<Book, String> library = new HashMap<>();

    public static void main(String[] args) {
        Book book = new Book("Сказки", "Пушкин", 1988);
        Book book2 = new Book("Стихи", "Лермонтов", 1967);
        Book book3 = new Book("Биология 5 класс", "Умник", 2015);
        Book book4 = new Book("История", "Историк", 2021);

        addBook(book, "Place_1");
        addBook(book2, "Place_2");
        addBook(book3, "Place_3");
        addBook(book4, "Place_4");

        showAllBookAndPlace();

        deleteBook("Биология 5 класс", "Умник", 2015);

        showAllBookAndPlace();
        getPlaceCurrentBook("Сказки", "Пушкин", 1988);

    }

    static void addBook(Book book, String place){
        library.put(book, place);
    }

    static void deleteBook(String title, String author, int year) {
        library.remove(new Book(title, author, year));
    }


    static void getPlaceCurrentBook(String title, String author, int year){
        Book book = new Book(title, author, year);
        String place = library.get(book);
        showInfoCurrentBook(book, place);

    }

    static void showInfoCurrentBook(Book book, String place) {
        System.out.printf("%s lies %s \n", book, place);
    }

    static void showAllBookAndPlace() {
        for (Book book : library.keySet()) {
            showInfoCurrentBook(book, library.get(book));
        }

    }

}
