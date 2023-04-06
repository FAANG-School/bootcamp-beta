package ru.faang.school.hashmap.task_2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    Main libraryTest;

    @BeforeEach
    void setUp() {
        libraryTest = new Main();
        libraryTest.bookshelves.put(new Book("Head First Java", "Kathy Sierra", "2003"), "5");
        libraryTest.bookshelves.put(new Book("Effective Java", "Joshua Bloch", "2011"), "5");
        libraryTest.bookshelves.put(new Book("Thinking in Java", "Bruce Eckel", "1998"), "3");
        libraryTest.bookshelves.put(new Book("Java Concurrency in Practice", "Brian Goetz", "2006"), "1");
        libraryTest.bookshelves.put(new Book("Head First Design Pattern", "Kathy Sierra", "2004"), "2");
    }

    @Test
    void putBookAtShelf() {
        Book book = new Book("Core Java(TM), Volume I", "Cay S. Horstmann", "2007");
        libraryTest.putBookOnShelf(book, "5");
        assertEquals("5", libraryTest.bookshelves.get(book));
    }

    @Test
    void removeBookByRightAttributes() {
        int startSize = libraryTest.bookshelves.size();
        String name = "Head First Java";
        String author = "Kathy Sierra";
        String year = "2003";
        libraryTest.removeBookByAttributes(name, author, year);
        assertEquals(startSize - 1, libraryTest.bookshelves.size());
    }

    @Test
    void removeBookByWrongAttributes() {
        int startSize = libraryTest.bookshelves.size();
        String name = "Head First";
        String author = "Kathy Sierra";
        String year = "2003";
        libraryTest.removeBookByAttributes(name, author, year);
        assertEquals(startSize, libraryTest.bookshelves.size());
    }

    @Test
    void findBookByRightAttributes() {
        String name = "Head First Java";
        String author = "Kathy Sierra";
        String year = "2003";
        String expected = "";
        libraryTest.findBookByAttributes(name, author, year);
        assertEquals(expected, "");
    }


}