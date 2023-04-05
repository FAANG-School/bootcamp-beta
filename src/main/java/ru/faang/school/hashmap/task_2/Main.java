package ru.faang.school.hashmap.task_2;

import java.util.HashMap;
import java.util.Map;

public class Main {
    static Map<Book, String> map = new HashMap<>();

    public static void addBook(Book book, String location){
        map.put(book, location);
    }

    public static void removeBook(Book book){
        map.remove(book);
    }

    public static void findBook(Book book){
        System.out.println(map.get(book));
    }

    public static void listOfAllBooks(){
        for (Map.Entry<Book, String> entry: map.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        addBook(new Book("Драконы и их величие", "Безумный король", 1002), "Вестерос");
        findBook(new Book("Драконы и их величие", "Безумный король", 1002));
        listOfAllBooks();
        removeBook(new Book("Драконы и их величие", "Безумный король", 1002));
        listOfAllBooks();
    }

}
