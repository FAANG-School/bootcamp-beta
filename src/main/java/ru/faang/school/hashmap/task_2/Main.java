package ru.faang.school.hashmap.task_2;

import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map <Book, String> BOOKS = new HashMap<>();
    public static void main(String[] args) {
        Book first = new Book("Битва королей","Джордж Мартин","1998");
        Book second = new Book("Танец с драконами","Джордж Мартин","2011");
        Book third = new Book("Буря мечей","Джордж Мартин","2000");
        add(first,"4235");
        add(second,"7453");
        add(third,"3254");
        remove(third);
        find(first);
        printAll();
    }

    private static void add(Book book, String number){
        BOOKS.put(book, number);
    }

    private static void remove(Book book){
        BOOKS.remove(book);
    }

    private static void printAll() {
        for (Map.Entry<Book, String> entry : BOOKS.entrySet()) {
            System.out.println(entry.getKey() + ":" +
                    entry.getValue());
        }
    }

    private static void find(Book book){
        System.out.println(BOOKS.get(book));
    }
}
