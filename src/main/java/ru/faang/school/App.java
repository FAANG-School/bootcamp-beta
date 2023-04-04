package ru.faang.school;

import hashmap_solutions.task_2.Book;
import hashmap_solutions.task_2.Main;

public class App {
    public static void main(String[] args) {
        Main main = new Main();
        main.putBook(new Book("first title", "first author", "first year"), "1");
        main.putBook(new Book("second title", "second author", "second year"), "2");
        main.putBook(new Book("third title", "third author", "third year"), "1");
        main.putBook(new Book("fourth title", "fourth author", "fourth year"), "1");
        main.putBook(new Book("fifth title", "fifth author", "fifth year"), "3");

        main.showAllBookInfo();
        main.removeBook("1", "2", "3");
        main.removeBook("fifth title", "fifth author", "fifth year");
        main.showAllBookInfo();
        main.findBook("1", "2", "3");
        main.findBook("third title", "third author", "third year");
        main.findBook("third title", "third author", "third yearr");
        main.findBook("fifth title", "fifth author", "fifth year");

    }
}
