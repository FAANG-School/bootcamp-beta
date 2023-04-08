package ru.faang.school.hashmap.task_2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    final static Main MAIN = new Main();
    final static Map<Book, String> BOOK_MAP = MAIN.getBookMap();

    @BeforeEach
    void setUp() {
        try (Scanner scanner = new Scanner(
                new File("src/test/java/ru/faang/school/hashmap/task_2/sample.csv"));) {
            scanner.useDelimiter("\n");
            for (int i = 0; i <= 4; i++) {
                String[] book = scanner.next().split(";");
                BOOK_MAP.put(
                        new Book(book[0], book[1], Integer.parseInt(book[2])),
                        String.valueOf((int) (Math.random() * 5) + 1)
                );
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static Stream<Arguments> provideArgsForAddBook() {
        return Stream.of(
                Arguments.of(null, null),
                Arguments.of(null, "")
        );
    }

    @ParameterizedTest
    @MethodSource("provideArgsForAddBook")
    void addBookWithNullOrEmptyArgs(Book book, String shelfNumber) {
        assertThrows(IllegalArgumentException.class, () -> MAIN.addBook(book, shelfNumber));
    }

    @Test
    void addExistingBook() {
        Book book = new Book("A Game of Thrones", "George R. R. Martin", 1996);
        assertTrue(BOOK_MAP.containsKey(book));

        String oldShelf = MAIN.getShelfByBook(book);
        MAIN.addBook(book, "new shelf");
        String newShelf = MAIN.getShelfByBook(book);

        assertEquals(oldShelf, newShelf);
    }

    @Test
    void addNonExistingBook() {
        Book book = new Book("Shadow and Bone", "Leigh Bardugo", 2012);
        assertFalse(BOOK_MAP.containsKey(book));
        MAIN.addBook(book, "4");
        assertTrue(BOOK_MAP.containsKey(book));
    }

    @ParameterizedTest
    @NullSource
    void removeBookWithNullOrEmptyArgs(Book book) {
        assertThrows(IllegalArgumentException.class, () -> MAIN.removeBook(book));
    }

    @Test
    void removeExistingBook() {
        Book book = new Book("A Game of Thrones", "George R. R. Martin", 1996);
        assertTrue(BOOK_MAP.containsKey(book));
        MAIN.removeBook(book);
        assertFalse(BOOK_MAP.containsKey(book));
    }

    @Test
    void removeNonExistingBook() {
        Book book = new Book("Shadow and Bone", "Leigh Bardugo", 2012);
        assertFalse(BOOK_MAP.containsKey(book));
        MAIN.removeBook(book);
        assertFalse(BOOK_MAP.containsKey(book));
    }

    @ParameterizedTest
    @NullSource
    void getBookShelfWithNullOrEmptyArgs(Book book) {
        assertThrows(IllegalArgumentException.class, () -> MAIN.getShelfByBook(book));
    }

    @Test
    void getShelfByExistingBook() {
        Book book = new Book("A Game of Thrones", "George R. R. Martin", 1996);
        assertTrue(BOOK_MAP.containsKey(book));
        assertNotNull(MAIN.getShelfByBook(book));
    }

    @Test
    void getShelfByNonExistingBook() {
        Book book = new Book("Shadow and Bone", "Leigh Bardugo", 2012);
        assertFalse(BOOK_MAP.containsKey(book));
        assertNull(MAIN.getShelfByBook(book));
    }
}