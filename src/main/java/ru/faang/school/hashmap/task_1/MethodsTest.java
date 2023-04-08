package ru.faang.school.hashmap.task_1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MethodsTest {
    private Map<String, House> map;
    private Methods methods;
    @BeforeEach
    void setUp() {
        methods = new Methods();
        map = new HashMap<>();
    }

    @Test
    void createNewHouse() {
        assertTrue(methods.createNewHouse(map, "Старк", new House("Старк", "зима близко")));
        assertTrue(map.containsKey("Старк"));
    }

    @Test
    void deleteHouse() {
        assertTrue(methods.createNewHouse(map, "Старк", new House("Старк", "зима близко")));
        assertTrue(methods.deleteHouse(map, "Старк"));
        assertFalse(map.containsKey("Старк"));
    }

    @Test
    void getSigilByName() {
        assertTrue(methods.createNewHouse(map, "Старк", new House("Старк", "зима близко")));
        assertEquals("зима близко", methods.getSigilByName(map, "Старк"));
    }

    @Test
    void getAllHouses() {
        assertTrue(methods.createNewHouse(map, "Старк", new House("Старк", "Зима близко")));
        assertTrue(methods.createNewHouse(map, "Ланнистер", new House("Ланнистер", "Услышь мой рев")));
        assertTrue(methods.createNewHouse(map, "Баратеон", new House("Баратеон", "Нам ярость")));
        assertEquals(3, map.size());
    }
}