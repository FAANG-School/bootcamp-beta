package ru.faang.school.hashmap.task_2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Task2Test {

    @Test
    public void task2Tests() {
        Main main = new Main();
        Book book = new Book("Title10", "Author10", 1998);

        main.addNewBook(book, "10");
        Assertions.assertTrue(main.getBooks().containsKey(book));
        Assertions.assertEquals(main.getBookShelfNumber("Title10", "Author10", 1998), "10");

        main.deleteBook("Title10", "Author10", 1998);
        Assertions.assertFalse(main.getBooks().containsKey(book));

        Assertions.assertEquals(main.getAllBooksInfo().size(), main.getBooks().size());
    }
}
