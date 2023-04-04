import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Book, String> map = new HashMap<>();
        addBook(map, new Book("How to scroll presentation?","Google",2023),"FAANGUniversity");
        addBook(map,new Book("How to be smart","Vlad Mishustin",2024),"YouTube");
        addBook(map,new Book("Lampoviy pentium", "Genius",2022),"YouTubeChannel");
        addBook(map,new Book("Test","TestAuthor",2077),"Cyberpunk");

        removeBook(map,"Test","TestAuthor",2077);

        findBook(map,"How to scroll presentation?","Google",2023);
        System.out.println();
        books(map);
    }

    public static void addBook(Map<Book, String> map, Book book, String location) {
        map.put(book, location);
    }

    public static void removeBook(Map<Book, String> map, String title, String author, int year) {
        map.remove(new Book(title, author, year));
    }

    public static void findBook(Map<Book, String> map, String title, String author, int year) {
        System.out.println(map.get(new Book(title, author, year)));
    }

    public static void books(Map<Book, String> map) {
        Book currBook;
        for (Map.Entry<Book, String> entry : map.entrySet()) {
            currBook = entry.getKey();
            System.out.println("Title: " + currBook.getTitle() +
                    ", Author: " + currBook.getAuthor() +
                    ", Year: " + currBook.getYear());
        }
    }
}