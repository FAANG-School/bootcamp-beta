package ru.faang.school.hashmap.task_1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WesterosTest {

    private Westeros westeros;

    @BeforeEach
    void setup() {
        westeros = new Westeros();
    }

    @Test
    void addNewHouse() {
        Assertions.assertNull(westeros.getSigilByName("test_house"));
        westeros.addNewHouse("test_house", new House("test_house", "test_sigil"));
        Assertions.assertNotNull(westeros.getSigilByName("test_house"));
        Assertions.assertEquals("test_sigil", westeros.getSigilByName("test_house"));
    }

    @Test
    void removeHouseByName() {
        Assertions.assertNotNull(westeros.getSigilByName("stark"));
        westeros.removeHouseByName("stark");
        Assertions.assertNull(westeros.getSigilByName("stark"));
    }

    @Test
    void getSigilByName() {
        Assertions.assertEquals("wolf", westeros.getSigilByName("stark"));
    }
}