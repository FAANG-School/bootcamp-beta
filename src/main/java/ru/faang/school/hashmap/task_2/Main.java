package ru.faang.school.hashmap.task_2;

import java.time.Year;
import java.util.HashMap;
import java.util.Map;

public class Main {
    //Map, где значением является название отдела, где находится книга
    private final Map<Book, String> library = new HashMap<>();

    public static void main(String[] args) {
        Main main = new Main();
        Book hp = new Book("Harry Potter and the Philosopher's Stone",
                "J. K. Rowling", "1997");
        Book hobbit = new Book("The Hobbit", "J.R.R. Tolkien", "1937");
        Book littlePrince = new Book("The Little Prince","Antoine de Saint-Exupéry","1943");
        main.addBook(hp,"Фантастика");
        main.addBook(hobbit,"Классика");
        main.removeBook(hobbit.getTitle(), hobbit.getAuthor(), hobbit.getYear());
        main.addBook(littlePrince,"Novella");
        System.out.println(main.getLibrary());
        System.out.println(main.getBookDepartment(
                "The Little Prince",
                "Antoine de Saint-Exupéry",
                "1943"
        ));
        main.printBookDepartment(hp.getTitle(),hp.getAuthor(),hp.getYear());
        main.printBookDepartment("1","2","3");
        main.printLibrary();
    }

    public Map<Book, String> getLibrary() {
        return library;
    }


    public void addBook(Book book, String department) {
        library.put(book, department);
    }

    public void removeBook(String title, String author, String year) {
        library.remove(new Book(title, author, year));
    }
    public String getBookDepartment(Book book) {
        return library.get(book);
    }

    public String getBookDepartment(String title, String author, String year) {
        return getBookDepartment(new Book(title, author, year));
    }


    public void printBookDepartment(String title, String author, String year) {
        Book book = new Book(title, author, year);
        String dep = library.get(book);
        if (dep==null) {
            System.out.println("Книга "+book+" не найдена в библиотеке");
            return;
        }
        System.out.println("Книга "+book+" находится в отделе '"+dep+"'");
    }

    public void printLibrary() {
        for (Map.Entry<Book, String> entry : library.entrySet()) {
            System.out.println("Книга "+entry.getKey()+" находится в отделе '"+entry.getValue()+"'");
        }
    }
}
