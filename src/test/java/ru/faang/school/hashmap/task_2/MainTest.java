package ru.faang.school.hashmap.task_2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainTest {

    @Test
    public void mainTest() {

        Main main = new Main();

        Book book = new Book("Robinson Crusoe", "Daniel Defoe", 1719);

        main.addBook(book , "4");
        Assertions.assertTrue(main.map.containsKey(book));
        Assertions.assertEquals(main.getShelf(book), "4");
        main.removeBook(book);
        Assertions.assertFalse(main.map.containsKey(book));

        Assertions.assertEquals(main.getBooks().size(), main.map.size());

        Assertions.assertThrows(IllegalArgumentException.class, () -> main.removeBook(book));
        Assertions.assertThrows(IllegalArgumentException.class, () -> main.getShelf(book));
    }

}
