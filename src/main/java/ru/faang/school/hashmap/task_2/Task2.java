package ru.faang.school.hashmap.task_2;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Task2 {
    public static final String SPLITTER = "-----------------------------------";
    public static final String INFO_TEXT = "Выбирите действие" + "\n" + "1. - Добавить элемент в HashMap;" + "\n" + "2. - Удалить элемент из HashMap;" + "\n" + "3. - Найти элемент в HashMap;" + "\n" + "4. - Показать содержимое HashMap;" + "\n" + "0. - Выход;" + "\n" + SPLITTER;

    public static void main(String[] args) {
        boolean isExit = false;
        Scanner scan = new Scanner(System.in);

        Map<Book, String> bookStringHashMap = new HashMap<>();
        bookStringHashMap.put(new Book("Книга1", "Пушкина", 1999), "Полка 1");
        bookStringHashMap.put(new Book("Книга2", "Пушкина", 2001), "Полка 2");
        bookStringHashMap.put(new Book("Книга3", "Пушкина", 2003), "Полка 3");
        bookStringHashMap.put(new Book("1", "1", 1), "Полка 3");
        System.out.println(SPLITTER);

        while (!isExit) {
            System.out.println(INFO_TEXT);
            try {
                int value = scan.nextInt();
                System.out.println(SPLITTER);
                switch (value) {
                    case 1:
                        addBookToLibrary(bookStringHashMap);
                        break;
                    case 2:
                        deleteBookFromLibrary(bookStringHashMap);
                        break;
                    case 3:
                        findBookInLibrary(bookStringHashMap);
                        break;
                    case 4:
                        getLibraryInfo(bookStringHashMap);
                        break;
                    case 0:
                        System.out.println("Выход...");
                        isExit = true;
                        break;
                }
                System.out.println(SPLITTER);
            } catch (NumberFormatException nfe) {
                System.out.println("Не верный тип попробуйте еще раз");
            }
        }
    }

    public static void getLibraryInfo(Map<Book, String> Map) {
        for (Map.Entry maps : Map.entrySet()) {
            System.out.println(SPLITTER + "\n" + "Ключ: " + maps.getKey() + " - (" + maps.getValue() + ")");
        }
    }

    public static void addBookToLibrary(Map<Book, String> Map) {
        boolean isCorrect = false;
        int yearBook = 0;
        Scanner scan = new Scanner(System.in);
        System.out.print("Где лежит: ");
        String HashKey = scan.nextLine();
        System.out.print("Введите название: ");
        String nameBook = scan.nextLine();
        System.out.print("Введите автора: ");
        String authorBook = scan.nextLine();
        System.out.print("Введите год: ");
        while (!isCorrect) {
            try {
                yearBook = Integer.valueOf(scan.nextLine());
                isCorrect = true;
            } catch (NumberFormatException nfe) {
                System.out.print("Не верный тип попробуйте еще раз: ");
            }
        }
        if (Map.get(new Book(nameBook, authorBook, yearBook)) != null) {
            System.out.println(SPLITTER + "\n" + "Такая книжка уже существует и лежит - \"" + Map.get(new Book(nameBook, authorBook, yearBook)) + "\"");
        } else {
            Map.put(new Book(nameBook, authorBook, yearBook), HashKey);
            System.out.println(SPLITTER + "\n" + "Добавленно успешно!");
        }
    }

    public static void findBookInLibrary(Map<Book, String> Map) {
        boolean isCorrect = false;
        int yearBook = 0;
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите название: ");
        String nameBook = scan.nextLine();
        System.out.print("Введите автора: ");
        String authorBook = scan.nextLine();
        System.out.print("Введите год: ");
        while (!isCorrect) {
            try {
                yearBook = Integer.valueOf(scan.nextLine());
                isCorrect = true;
            } catch (NumberFormatException nfe) {
                System.out.print("Не верный тип попробуйте еще раз: ");
            }
        }
        if (Map.get(new Book(nameBook, authorBook, yearBook)) != null) {
            System.out.println(SPLITTER + "\n" + "Лежит - " + Map.get(new Book(nameBook, authorBook, yearBook)));
        } else {
            System.out.println(SPLITTER + "\n" + "Не найдено место этой книги");
        }
    }

    public static void deleteBookFromLibrary(Map<Book, String> Map) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите название: ");
        String nameBook = scan.nextLine();
        System.out.print("Введите автора: ");
        String authorBook = scan.nextLine();
        System.out.print("Введите год: ");
        int yearBook = scan.nextInt();

        if (Map.get(new Book(nameBook, authorBook, yearBook)) != null) {
            Map.remove(new Book(nameBook, authorBook, yearBook));
            System.out.println(SPLITTER + "\n" + "Удален!");
        } else {
            System.out.println(SPLITTER + "\n" + "Не найден для удаления!");
        }
    }
}


class Book {
    public String title;
    public String author;
    public int year;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return year == book.year && Objects.equals(title, book.title) && Objects.equals(author, book.author);
    }

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                '}';
    }
}
