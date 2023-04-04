package ru.faang.school.hashmap.task_2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WesterosLibraryTest {

    private WesterosLibrary westerosLibrary;

    @BeforeEach
    void setup() {
        westerosLibrary = new WesterosLibrary();
    }

    @Test
    void addBook() {
        Book book = new Book("book_title", "book_author", "book_year");
        assertNull(westerosLibrary.findBook(book.title(), book.author(), book.year()));
        westerosLibrary.addBook(book, "bookshelf_1");
        assertNotNull(westerosLibrary.findBook(book.title(), book.author(), book.year()));
    }

    @Test
    void removeBook() {
        Book book = new Book("book_title", "book_author", "book_year");
        westerosLibrary.addBook(book, "bookshelf_1");
        assertNotNull(westerosLibrary.findBook(book.title(), book.author(), book.year()));
        westerosLibrary.removeBook(book.title(), book.author(), book.year());
        assertNull(westerosLibrary.findBook(book.title(), book.author(), book.year()));
    }

    @Test
    void findBookshelf() {
        Book book = new Book("book_title", "book_author", "book_year");
        assertNull(westerosLibrary.findBook(book.title(), book.author(), book.year()));
        westerosLibrary.addBook(book, "bookshelf_1");
        assertEquals("bookshelf_1", westerosLibrary.findBookshelf(book.title(), book.author(), book.year()));
    }

    @Test
    void findBook() {
        Book book = new Book("book_title", "book_author", "book_year");
        assertNull(westerosLibrary.findBook(book.title(), book.author(), book.year()));
        westerosLibrary.addBook(book, "bookshelf_1");
        assertEquals(book, westerosLibrary.findBook(book.title(), book.author(), book.year()));
    }
}