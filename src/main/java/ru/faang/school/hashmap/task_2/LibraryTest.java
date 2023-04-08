package ru.faang.school.hashmap.task_2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LibraryTest {
    private Library library;
    private Map<Book, String> map;

    @BeforeEach
    void setUp() {
        library = new Library();
        map = new HashMap<>();
    }

    @Test
    void addNewBook() {
        assertEquals(0, map.size());
        assertTrue(library.addNewBook(map, new Book("‘илосови€ java", "Ѕрюс Ёккель", 2020), "4H"));
        assertEquals(1, map.size());
    }

    @Test
    void removeBook() {
        assertEquals(0, map.size());
        assertTrue(library.addNewBook(map, new Book("‘илосови€ java", "Ѕрюс Ёккель", 2020), "4H"));
        assertEquals(1, map.size());
        assertTrue(library.removeBook(map, "‘илосови€ java", "Ѕрюс Ёккель", 2020));
        assertEquals(0, map.size());
    }

    @Test
    void getBookLocation() {
        assertTrue(library.addNewBook(map, new Book("‘илосови€ java", "Ѕрюс Ёккель", 2020), "4H"));
        assertEquals("4H", library.getBookLocation(map, "‘илосови€ java", "Ѕрюс Ёккель", 2020));
    }
}