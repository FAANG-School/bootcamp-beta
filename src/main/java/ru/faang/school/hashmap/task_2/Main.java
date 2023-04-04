package ru.faang.school.hashmap.task_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static final Map<Book, Integer> bookMap;

    static {
        bookMap = new HashMap<>();

        try (Scanner scanner = new Scanner(
                new File("src/main/java/ru/faang/school/hashmap/task_2/sample.csv"));) {
            scanner.useDelimiter("\n");
            while (scanner.hasNext()) {
                String[] book = scanner.next().split(";");
                bookMap.put(new Book(book[0], book[1], Integer.parseInt(book[2])), (int) (Math.random() *  4));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {

    }
}
