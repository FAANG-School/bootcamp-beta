package ru.faang.school.hashmap.task_2.solution;

import org.junit.Before;

import java.io.IOException;

import static org.junit.Assert.*;

public class UnitTest {
    public Library lib;
    public Book b;
    public Book b1;
    public Book b2;
    public Book b3;
    public Book b4;

    @Before
    public void prepare() throws IOException {
        lib = new Library();
        b = new Book("War and Peace", "Tolstoy", 1890);
        b1 = new Book("The philosophy of java", "Eckel", 2005);
        b2 = new Book("Thinking in java", "Eckel", 2010);
        b3 = new Book("another one book", "good writer", 2021);
        b4 = new Book("Eugeny Onegin", "Pushkin", 1900);
    }

    @org.junit.Test
    public void addingTest(){
        lib.add(b, "1");
        lib.add(b1, "science");
        lib.add(b2, "java");
        lib.add(b3, "somewhere");
        lib.add(b4, "russian writers");
    }

    @org.junit.Test
    public void addUnsupportedValueTest(){
        assertFalse(lib.add("name", "author", -1, "place"));
    }

    @org.junit.Test
    public void equalsTest(){
        Library lib2 = new Library();

        lib.add(b, "1");
        lib.add(b1, "science");
        lib.add(b2, "java");
        lib.add(b3, "somewhere");
        lib.add(b4, "russian writers");

        lib2.add(b, "1");
        lib2.add(b1, "science");
        lib2.add(b2, "java");
        lib2.add(b3, "somewhere");
        lib2.add(b4, "russian writers");

        assertEquals(lib, lib2);
    }

    @org.junit.Test
    public void removingTest(){
        Library lib2 = new Library();

        lib.add(b, "1");
        lib.add(b1, "science");
        lib.add(b2, "java");
        lib.add(b3, "somewhere");
        lib.add(b4, "russian writers");

        lib2.add(b, "1");
        lib2.add(b3, "somewhere");
        lib2.add(b4, "russian writers");


        assertTrue(lib.remove(b1));
        assertTrue(lib.remove("Thinking in java", "Eckel", 2010));

        assertEquals(lib, lib2);
    }

    @org.junit.Test
    public void removingNonExistingTest(){
        lib.add(b, "1");
        lib.add(b2, "java");
        lib.add(b3, "somewhere");
        lib.add(b4, "russian writers");


        assertFalse(lib.remove(b1));
        assertFalse(lib.remove("Thinking in jav", "Eckel", 2010));
    }

    @org.junit.Test
    public void removingEmptyLibTest(){
        assertFalse(lib.remove("1", "1", 1));
        assertFalse(lib.remove("", "", 1));
    }

    @org.junit.Test
    public void getTest(){
        lib.add(b, "1");
        lib.add(b1, "science");
        lib.add(b2, "java");
        lib.add(b3, "somewhere");
        lib.add(b4, "russian writers");

        assertEquals(lib.get(b), "1");
        assertEquals(lib.get(b3), "somewhere");
    }


    @org.junit.Test
    public void getAllTest(){
        lib.add(b, "1");
        lib.add(b1, "science");
        lib.add(b2, "java");
        lib.add(b3, "somewhere");
        lib.add(b4, "russian writers");

        assertNotNull(lib.getAllBooks());
        System.out.println(lib.getAllBooks());
    }

}
