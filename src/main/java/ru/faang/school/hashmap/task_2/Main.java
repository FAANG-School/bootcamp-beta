package ru.faang.school.hashmap.task_2;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private Map<Book, String> booksMap = new HashMap<>(Map.of(
            new Book("Евгений Онегин", "А.С.Пушкин", 1820), "Полка №1",
            new Book("Мастер и маргарита", "М.А.Булгаков", 1967), "Полка №4",
            new Book("Преступление и наказание", "Ф.М.Достоевский", 1866), "Полка №3"
    ));

    public void addBook(String title, String author, int year, String place) {
        Book book = new Book(title, author, year);
        booksMap.put(book, place);
        System.out.println("Книга " + book.getTitle() + " теперь находится на " + place);
    }

    public void removeBook(String title, String author, int year) {
        Book bookToRemove = new Book(title, author, year);

        String bookPlace = booksMap.remove(bookToRemove);

        if (bookPlace == null) {
            System.out.println("Книга " + title + " не была найдена");
        } else {
            System.out.println("Книга " + title + " была убрана с " + bookPlace);
        }
    }

    public void findBook(String title, String author, int year) {
        Book bookToFind = new Book(title, author, year);

        String bookPlace = booksMap.get(bookToFind);

        if (bookPlace == null) {
            System.out.println("Книга " + title + " не была найдена");
        } else {
            System.out.println("Книга " + title + " находится на " + bookPlace);
        }
    }

    public void showAllBooks() {
        for (Map.Entry<Book, String> entry : booksMap.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Main main = new Main();

        main.showAllBooks();

        main.addBook("Танец драконов", "Джордж Р.Р. Мартин", 2011, "Полка №11");

        main.showAllBooks();

        main.removeBook("Евгений Онегин", "А.С.Пушкин", 1820);
        main.removeBook("Братья Карамазовы", "Ф.М.Достоевский", 1880);

        main.showAllBooks();

        main.findBook("Танец драконов", "Джордж Р.Р. Мартин", 2011);
        main.findBook("Мастер и маргарита", "М.А.Булгаков", 1967);
        main.findBook("Евгений Онегин", "А.С.Пушкин", 1820);
    }
}
