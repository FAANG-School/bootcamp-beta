package ru.faang.school.task1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
class HouseTest {
    Map<String, House> data;
    House stark = new House("Stark", "Stark");
    House lanister = new House("Lanister", "Lanister");
    House barateon = new House("Barateon", "Barateon");

    @BeforeEach
    void setUp() {
        data = new HashMap<>();
    }
    @Test
    void addHouse() {
        House.addHouse(data, stark);
        House.addHouse(data, lanister);
        House.addHouse(data, barateon);

        assertEquals(3, data.size());
    }

    @Test
    void deleteHouse() {
        House.addHouse(data, stark);
        House.addHouse(data, lanister);
        House.addHouse(data, barateon);

        House.deleteHouse(data, lanister.getName());

        assertEquals(2, data.size());
        assertNull(data.get(lanister.getName()));
    }

    @Test
    void findHouse() {
        House.addHouse(data, stark);
        House.addHouse(data, lanister);
        House.addHouse(data, barateon);

        assertNotNull(House.findHouse(data, barateon.getName()));
        assertEquals(barateon.getSigil(), House.findHouse(data, barateon.getName()));
    }

    @Test
    void printAllHouse() {
        House.addHouse(data, stark);
        House.addHouse(data, lanister);
        House.addHouse(data, barateon);

        House.printAllHouse(data);
    }
}