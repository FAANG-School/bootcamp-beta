package BootCamp;

import java.util.HashMap;
import java.util.Map;

public class Main {

    static void addNewBook(Map<Book, String> map, String tittle, String author, String year, String place){
        map.put(new Book(tittle,author,year),place);
    }

    static void deleteBook(Map<Book, String> map, String tittle, String author, String year){
        map.remove(new Book(tittle,author,year));
    }

    static void searchBook(Map<Book, String> map, String tittle, String author, String year){
        System.out.println(map.get(new Book(tittle,author,year)));
    }

    static void showInfo(Map<Book, String> map){
        map.entrySet().forEach(System.out::println);
    }



    public static void main(String[] args) {

        Map<Book, String> bookStringMap = new HashMap<>();
        bookStringMap.put(new Book("Мёртвые души", "Гоголь","1835"), "Полка 2");
        bookStringMap.put(new Book("Преступление и наказание", "Достоевский", "1865"), "Полка 1");
        bookStringMap.put(new Book("Капитанская дочка", "Пушкин", "1837"), "Полка 2");

        addNewBook(bookStringMap, "Ревизор", "Гоголь", "1835", "Полка 1");
        showInfo(bookStringMap);
        deleteBook(bookStringMap,"Мёртвые души", "Гоголь", "1835");
        showInfo(bookStringMap);
        searchBook(bookStringMap, "Ревизор", "Гоголь", "1835");

    }
}
