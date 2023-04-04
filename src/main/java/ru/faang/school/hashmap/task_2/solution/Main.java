package ru.faang.school.hashmap.task_2.solution;

import java.util.HashMap;
import java.util.Map;

public class Main {

  private static final Map<Book, String> map = new HashMap<>();

  public static void putBook(Book book, String shelfNumber) {

    map.put(book, shelfNumber);
  }

  public static void deleteBook(String title, String author, Integer year) {

    map.remove(new Book(title, author, year));
  }

  public static void printNumberShelfBook(String title, String author, Integer year) {

    System.out.println(map.get(new Book(title, author, year)));
  }

  public static void printAllBook() {

    map.forEach((key, value) -> System.out.printf("\nКнига: %s , место: %s", key, value));
  }

  public static void main(String[] args) {
    var book1 = new Book("Мастер и Маргарита", "М. Булгаков",1966);
    var book2 = new Book("1984", "Дж. Оруэл",1949);
    var book3 = new Book("Лолита", "В. Набоков",1958);
    var book4 = new Book("Iliada", "Gomer",-800);
    var book5 = new Book("Одиссея", "Гомер",-750);
    var book6 = new Book("Над пропастью во ржи", "Дж. Сэлинджер",1951);
    var book7 = new Book("О дивный новый мир", "О. Хаксли",1932);

    putBook(book1, "1 ряд, 1 полка");
    putBook(book2, "1 ряд, 2 полка");
    putBook(book3, "1 ряд, 3 полка");
    putBook(book4, "1 ряд, 4 полка");
    putBook(book5, "1 ряд, 5 полка");
    putBook(book6,"1 ряд, 6 полка");
    putBook(book7, "1 ряд, 7 полка");
    putBook(book7, "2 ряд, 7 полка");

    putBook(null, null);

    printAllBook();

    System.out.println("\nBook - Лолита, shelf number: ");
    printNumberShelfBook("Лолита", "В. Набоков",1958);

    deleteBook(book1.getTitle(), book1.getAuthor(), book1.getYear());
    deleteBook(book2.getTitle(), book2.getAuthor(), book2.getYear());
    deleteBook(book1.getTitle(), book1.getAuthor(), book1.getYear());
    deleteBook("sda", book3.getAuthor(), book3.getYear());

    printAllBook();

  }
}
