package ru.faang.school.hashmap.task_2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.faang.school.hashmap.task_2.exception.LibraryNotEmptyException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {
    final static Library LIBRARY = new Library();

    @BeforeAll
    static void setUp() {
        Map<Book, String> books = new HashMap<>();
        try (Scanner scanner = new Scanner(
                new File("src/test/java/ru/faang/school/hashmap/task_2/sample.csv"));) {
            scanner.useDelimiter("\n");
            for (int i = 0; i <= 4; i++) {
                String[] book = scanner.next().split(";");
                books.put(
                        new Book(book[0], book[1], Integer.parseInt(book[2])),
                        String.valueOf((int) (Math.random() * 5) + 1)
                );
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        LIBRARY.setBooks(books);
    }

    private static Stream<Arguments> testMethods() {
        return Stream.of(
                Arguments.of(null, null),
                Arguments.of(null, "")
        );
    }

    @ParameterizedTest
    @MethodSource("testMethods")
    void testMethodsWithNullOrEmptyArgs(Book arg1, String arg2) {
        assertThrows(IllegalArgumentException.class, () -> LIBRARY.isBookExist(arg1));
        assertThrows(IllegalArgumentException.class, () -> LIBRARY.addBook(arg1, arg2));
        assertThrows(IllegalArgumentException.class, () -> LIBRARY.removeBook(arg1));
    }

    @Test
    void testIsBookExist() {
        Book book = new Book("The Eye of the World", "Robert Jordan", 1990);
        assertFalse(LIBRARY.isBookExist(book));
        LIBRARY.addBook(book, "100");
        assertTrue(LIBRARY.isBookExist(book));
    }

    @Test
    void testAddExistingBook() {
        Book book = new Book("A Game of Thrones", "George R. R. Martin", 1996);
        assertTrue(LIBRARY.isBookExist(book));

        String oldShelf = LIBRARY.getShelfByBook(book);
        LIBRARY.addBook(book, "new shelf");
        String newShelf = LIBRARY.getShelfByBook(book);

        assertEquals(oldShelf, newShelf);
    }

    @Test
    void testAddNonExistingBook() {
        Book book = new Book("Shadow and Bone", "Leigh Bardugo", 2012);
        assertFalse(LIBRARY.isBookExist(book));
        LIBRARY.addBook(book, "4");
        assertTrue(LIBRARY.isBookExist(book));
    }

    @Test
    void testRemoveExistingBook() {
        Book book = new Book("A Game of Thrones", "George R. R. Martin", 1996);
        assertTrue(LIBRARY.isBookExist(book));
        LIBRARY.removeBook(book);
        assertFalse(LIBRARY.isBookExist(book));
    }

    @Test
    void testRemoveNonExistingBook() {
        Book book = new Book("Kingdom of Ash", "Sarah J. Maas", 2022);
        assertFalse(LIBRARY.isBookExist(book));
        LIBRARY.removeBook(book);
        assertFalse(LIBRARY.isBookExist(book));
    }

    @Test
    void testGetShelfByExistingBook() {
        Book book = new Book("A Game of Thrones", "George R. R. Martin", 1996);
        assertTrue(LIBRARY.isBookExist(book));
        assertNotNull(LIBRARY.getShelfByBook(book));
    }

    @Test
    void testGetShelfByNonExistingBook() {
        Book book = new Book("Shadow and Bone", "Leigh Bardugo", 2012);
        assertFalse(LIBRARY.isBookExist(book));
        assertEquals(LIBRARY.getShelfByBook(book), "unknown");
    }

    @Test
    void testSetBooks() {
        assertThrows(IllegalArgumentException.class, () -> LIBRARY.setBooks(null));
        assertThrows(LibraryNotEmptyException.class, () -> LIBRARY.setBooks(new HashMap<>()));
    }
}