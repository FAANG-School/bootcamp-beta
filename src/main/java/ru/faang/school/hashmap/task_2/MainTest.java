package ru.faang.school.hashmap.task_2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    private Main libraryTest;
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        libraryTest = new Main();
        libraryTest.bookshelves.put(new Book("Head First Java", "Kathy Sierra", "2003"), "5");
        libraryTest.bookshelves.put(new Book("Effective Java", "Joshua Bloch", "2011"), "5");
        libraryTest.bookshelves.put(new Book("Thinking in Java", "Bruce Eckel", "1998"), "3");
        libraryTest.bookshelves.put(new Book("Java Concurrency in Practice", "Brian Goetz", "2006"), "1");
        libraryTest.bookshelves.put(new Book("Head First Design Pattern", "Kathy Sierra", "2004"), "2");
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
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
        String expected = "You've found : Book{name='Head First Java', author='Kathy Sierra', year='2003'}number of shelf - 5";
        libraryTest.findBookByAttributes(name, author, year);
        assertEquals(expected, outputStreamCaptor.toString().trim());
    }

    @Test
    void findBookByWrongAttributes() {
        String name = "Head First";
        String author = "Kathy Sierra";
        String year = "2003";
        String expected = "There is no a book with these attributes";
        libraryTest.findBookByAttributes(name, author, year);
        assertEquals(expected, outputStreamCaptor.toString().trim());
    }

    @Test
    void printWholeLibrary() {
        String expected = "Your library contains:\r\n" +
                "Book{name='Thinking in Java', author='Bruce Eckel', year='1998'} stays at shelf number - 3\r\n" +
                "Book{name='Head First Java', author='Kathy Sierra', year='2003'} stays at shelf number - 5\r\n" +
                "Book{name='Java Concurrency in Practice', author='Brian Goetz', year='2006'} stays at shelf number - 1\r\n" +
                "Book{name='Head First Design Pattern', author='Kathy Sierra', year='2004'} stays at shelf number - 2\r\n" +
                "Book{name='Effective Java', author='Joshua Bloch', year='2011'} stays at shelf number - 5";
        libraryTest.printWholeLibrary();
        assertEquals(expected, outputStreamCaptor.toString().trim());
    }


}