package ru.faang.school.hashmap.task_2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main {
    private static final HashMap<Book, String> library = new HashMap<>();
    public static void main(String[] args) {
        addBook(new Book("Horse: A Novel", "Geraldine Brooks", 2022), "A1");
        addBook(new Book("Fairy Tale", "Stephen King", 2022), "B2");
        addBook(new Book("Tomorrow, and Tomorrow, and Tomorrow: A novel", "Gabrielle Zevin", 2022), "C3");
        System.out.println();

        search.byYear(2022);
        search.byYear(2023);
        System.out.println();

        search.byTitle("Fairy Tale");
        search.byTitle("A");
        System.out.println();

        search.byAuthor("Stephen King");
        search.byAuthor("A");
        System.out.println();

        delete.byAuthor("Stephen King");
        delete.byAuthor("A");
        System.out.println();

        delete.byTitle("Horse: A Novel");
        delete.byTitle("A");
        System.out.println();

        delete.byYear(2022);
        delete.byYear(2023);
        System.out.println();

        showAllBooks();
    }
    public static void addBook(Book book, String location) {
        if(library.containsKey(book)){
            System.out.println("Library already has this book.");
            return;
        }
        library.put(book,location);
        System.out.println("Added book \"" + book.getTitle() + "\".");
    }
    public static void showAllBooks() {
        if(library.size() == 0){
            System.out.println("Library is empty.");
            return;
        }
        System.out.println("List of books:");
        for(Map.Entry<Book, String> entry : library.entrySet()) {
            Book temp = entry.getKey();
            System.out.println("Title : \"" + temp.getTitle() +"\". Author :\"" + temp.getAuthor() + "\". Year: " + temp.getYear() + ". Location: " + entry.getValue());
        }
    }

    static class delete {
        public static void byAuthor(String author) {
            int count = 0;
            Iterator<Map.Entry<Book,String>> iterator = library.entrySet().iterator();
            while(iterator.hasNext()){
                Map.Entry<Book,String> entry = iterator.next();
                if (entry.getKey().getAuthor().equals(author)) {
                    Book temp = entry.getKey();
                    System.out.println("Book \"" + temp.getTitle() +"\". by Author: \"" + temp.getAuthor() + "\" (" + temp.getYear() + ") was deleted.");
                    iterator.remove();
                    count++;
                }
            }
            if(count == 0){
                System.out.println("There isn't any book with Author \"" + author + "\"");
            } else {
                System.out.println("Total : " + count + " book(s) was deleted.");
            }
        }

        public static void byTitle(String title) {
            int count = 0;
            Iterator<Map.Entry<Book,String>> iterator = library.entrySet().iterator();
            while(iterator.hasNext()){
                Map.Entry<Book,String> entry = iterator.next();
                if (entry.getKey().getTitle().equals(title)) {
                    Book temp = entry.getKey();
                    System.out.println("Book \"" + temp.getTitle() +"\". by Author: \"" + temp.getAuthor() + "\" (" + temp.getYear() + ") was deleted.");
                    iterator.remove();
                    count++;
                }
            }
            if(count == 0){
                System.out.println("There isn't any book with title \"" + title + "\"");
            } else {
                System.out.println("Total : " + count + " book(s) was deleted.");
            }
        }

        public static void byYear(int year) {
            int count = 0;
            Iterator<Map.Entry<Book,String>> iterator = library.entrySet().iterator();
            while(iterator.hasNext()){
                Map.Entry<Book,String> entry = iterator.next();
                if (entry.getKey().getYear() == year) {
                    Book temp = entry.getKey();
                    System.out.println("Book \"" + temp.getTitle() +"\". by Author: \"" + temp.getAuthor() + "\" (" + temp.getYear() + ") was deleted.");
                    iterator.remove();
                    count++;
                }
            }
            if(count == 0){
                System.out.println("There isn't any book, published at " + year + ".");
            } else {
                System.out.println("Total : " + count + " book(s) was deleted.");
            }
        }
    }
    static class search {
        public static void byAuthor(String author) {
            int count = 0;
            for(Map.Entry<Book, String> entry : library.entrySet()) {
                if (entry.getKey().getAuthor().equals(author)) {
                    Book temp = entry.getKey();
                    System.out.println("Title : \"" + temp.getTitle() +"\". Author: \"" + temp.getAuthor() + "\". Year: " + temp.getYear() + ". Location: " + entry.getValue());
                    count++;
                }
            }
            if(count == 0){
                System.out.println("There isn't any book with Author \"" + author + "\"");
            } else {
                System.out.println("Found " + count + " book(-s) with author \"" + author + "\".");
            }
        }

        public static void byTitle(String title) {
            int count = 0;
            for(Map.Entry<Book, String> entry : library.entrySet()) {
                if (entry.getKey().getTitle().equals(title)) {
                    Book temp = entry.getKey();
                    System.out.println("Title : \"" + temp.getTitle() + "\". Author: \"" + temp.getAuthor() + "\". Year: " + temp.getYear() + ". Location: " + entry.getValue());
                    count++;
                }
            }
            if(count == 0){
                System.out.println("There isn't any book with title \"" + title + "\"");
            } else {
                System.out.println("Found " + count + " book(-s) with title \"" + title + "\".");
            }
        }

        public static void byYear(int year) {
            int count = 0;
            for(Map.Entry<Book, String> entry : library.entrySet()) {
                if (entry.getKey().getYear() == year) {
                    Book temp = entry.getKey();
                    System.out.println("Title : \"" + temp.getTitle() + "\". Author: \"" + temp.getAuthor() + "\". Year: " + temp.getYear() + ". Location: " + entry.getValue());
                    count++;
                }
            }
            if(count == 0){
                System.out.println("There isn't any book, published at " + year + ".");
            } else {
                System.out.println("Found " + count + " book(-s), published at " + year + ".");
            }
        }
    }
}
