package ru.faang.school.hashmap.task_2;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Book, String> library = new HashMap<>();

        library.put(new Book("qwerrt", "1"), "Book_1");
        library.put(new Book("Ревизор", "3"), "Book_2");
        library.put(new Book("Богатый папа, бедный папа", "5"), "Book_3");
        library.put(new Book("Грокаем алгоритмы", "9"), "Book_4");

        library.put(new Book("Тихий дон", "10"), "Book_5"); // добав новой книги.

        library.remove("Ревизор"); // удаление по названию.

        System.out.println(library.get("Грокаем алгоритмы"));

        for (Map.Entry <Book, String> entry : library.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}