package hashmap.task_2;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Book, String> library = new HashMap<>();
        library.put(new Book("11/22/63", "Stephen King", 2011), "K11");
        library.put(new Book("Carrie", "Stephen King", 1974), "K34");
        library.put(new Book("The Talisman", "Stephen King", 1984), "K24");

        addBook(library, new Book("The Little Prince", "Antoine de Saint-Exupery", 1942), "A34");
        System.out.println(library);
        System.out.println("--------------------");

        getLocationByTitle(library, "11/22/63");
        getLocationByAuthor(library, "Antoine de Saint-Exupery");
        getLocationByYear(library, 1974);
        System.out.println("--------------------");

        removeBookByTitle(library, "11/22/63");
        System.out.println(library);

        removeBookByAuthor(library, "Antoine de Saint-Exupery");
        System.out.println(library);

        removeBookByYear(library, 1984);
        System.out.println(library);
        System.out.println("--------------------");

        getBooksInfo(library);
    }

    public static void addBook(Map<Book, String> library, Book book, String location) {
        library.put(book, location);
    }

    public static void removeBookByTitle(Map<Book, String> library, String title) {
        for (Map.Entry<Book, String> entry: library.entrySet()) {
            if (entry.getKey().getTitle().equals(title)) {
                library.remove(entry.getKey());
                return;
            }
        }
    }

    public static void removeBookByAuthor(Map<Book, String> library, String author) {
        for (Map.Entry<Book, String> entry: library.entrySet()) {
            if (entry.getKey().getAuthor().equals(author)) {
                library.remove(entry.getKey());
                return;
            }
        }
    }

    public static void removeBookByYear(Map<Book, String> library, int year) {
        for (Map.Entry<Book, String> entry: library.entrySet()) {
            if (entry.getKey().getYear() == year) {
                library.remove(entry.getKey());
                return;
            }
        }
    }

    public static void getLocationByTitle(Map<Book, String> library, String title) {
        for (Map.Entry<Book, String> entry: library.entrySet()) {
            if (entry.getKey().getTitle().equals(title)) {
                System.out.println("The Book " + entry.getKey().getAuthor() + " \"" + entry.getKey().getTitle() + "\" " + "in a " + entry.getValue());
                return;
            }
        }
    }

    public static void getLocationByAuthor(Map<Book, String> library, String author) {
        for (Map.Entry<Book, String> entry: library.entrySet()) {
            if (entry.getKey().getAuthor().equals(author)) {
                System.out.println("The Book " + entry.getKey().getAuthor() + " \"" + entry.getKey().getTitle() + "\" " + "in a " + entry.getValue());
                return;
            }
        }
    }

    public static void getLocationByYear(Map<Book, String> library, int year) {
        for (Map.Entry<Book, String> entry: library.entrySet()) {
            if (entry.getKey().getYear() == year) {
                System.out.println("The Book " + entry.getKey().getAuthor() + " \"" + entry.getKey().getTitle() + "\" " + "in a " + entry.getValue());
                return;
            }
        }
    }

    public static void getBooksInfo(Map<Book, String> library) {
        System.out.println(library);
    }
}
