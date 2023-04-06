package ru.faang.school.task_2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
class BookTest {

    Map<Book, String> data;

    @BeforeEach
    void setUp() {
        data = new HashMap<>();
        data.put(new Book("ABC", "Tom", (short) 1900), "1");
        data.put(new Book("C++", "Richi", (short) 1980), "2");
        data.put(new Book("ABC", "Tom", (short)2000), "3");
    }
    @Test
    void addBook() {
        Book book = new Book("Test", "Test", (short)1111);

        Book.addBook(data, book, "1");

        assertEquals("1", data.get(book) );
    }

    @Test
    void deleteBook() {
        Book book = new Book("Test", "Test", (short)1111);

        Book.deleteBook(data, book);

        assertEquals(3, data.size());
    }

    @Test
    void findBook() {
        assertEquals("3", data.get(new Book("ABC", "Tom", (short)2000)));
    }

    @Test
    void printAllBook() {
        Book.printAllBook(data);
    }
}