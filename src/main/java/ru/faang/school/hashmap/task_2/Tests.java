package ru.faang.school.hashmap.task_2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class Tests {
    private static final ByteArrayOutputStream outStream = new ByteArrayOutputStream();

    @BeforeAll
    public static void setOutStream() {
        System.setOut(new PrintStream(outStream));
    }
    @Test
    public void testEquals() {
        Book book = new Book("1","2","3");
        Book book1 = new Book(book.getTitle(),book.getAuthor(),book.getYear());
        assertEquals(book,book1);
        assertEquals(book.hashCode(),book1.hashCode());
        book1.setAuthor("1");
        assertNotEquals(book,book1);
    }

    @Test
    public void testAddBook() {
        Main test = new Main();
        Book book = new Book("1984","J.Orwell","1938");
        test.addBook(book,"Anti-utopia");
        assertEquals(test.getBookDepartment(book.getTitle(),book.getAuthor(),book.getYear()),"Anti-utopia");
        assertEquals(1,test.getLibrary().size());
    }

    @Test
    public void testRemove() {
        String title = "1984";
        String author = "J.Orwell";
        String year = "1938";
        Book book = new Book(title, author, year);
        Main test = new Main();
        test.addBook(book,"Anti-utopia");
        assertEquals(test.getBookDepartment(book),"Anti-utopia");
        test.removeBook(book.getTitle(), book.getAuthor(), book.getYear());
        assertNull(test.getBookDepartment(book));
    }

    @Test
    public void testGetBookDepartment() {
        String title = "Harry Potter";
        String author = "J.K.Rowling";
        String year = "1997";
        Book book = new Book(title, author, year);
        Main test = new Main();
        test.addBook(book,"Fantastic");
        assertEquals(test.getBookDepartment(title, author, year),"Fantastic");
        book.setAuthor("Obama");
        assertNotEquals(test.getBookDepartment(book.getTitle(),book.getAuthor(),book.getYear()),"Fantastic");
    }

    @Test
    public void testPrintBookDepartment() {
        String title = "Harry Potter";
        String author = "J.K.Rowling";
        String year = "1997";
        Book book = new Book(title, author, year);
        Main test = new Main();
        test.addBook(book,"Fantastic");
        test.printBookDepartment(title, author, year);
        String expected = "Книга "+book+" находится в отделе 'Fantastic'\n";
        assertEquals(expected,outStream.toString());
        outStream.reset();
        expected = "Книга {Название: '1', автор: 2, год издания: 3} не найдена в библиотеке\n";
        test.printBookDepartment("1","2","3");
        assertEquals(expected,outStream.toString());
    }

    @Test
    public void testPrintLibrary() {
        String title = "Harry Potter";
        String author = "J.K.Rowling";
        String year = "1997";
        String title1 = "The Hobbit";
        String author1 = "J.R. Tolkien";
        String year1 = "1937";
        Book book = new Book(title, author, year);
        Book book1 = new Book(title1, author1, year1);
        Main test = new Main();
        test.addBook(book,"Fantastic");
        test.addBook(book1,"Fantastic");
        test.printLibrary();
        String expected = "Книга "+book+" находится в отделе 'Fantastic'\n" +
                 "Книга "+book1+" находится в отделе 'Fantastic'";
        assertEquals(expected,outStream.toString());
    }
}
