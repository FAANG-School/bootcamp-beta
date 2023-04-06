package ru.faang.school.hashmap.task_1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Task1Test {

    @Test
    public void task1Tests() {
        Main main = new Main();

        main.addNewHouse("Testhouse", "Testsigil");
        Assertions.assertTrue(main.houses.containsKey("Testhouse"));
        Assertions.assertEquals(main.getSigil("Testhouse"), "Testsigil");

        main.deleteHouse("Testhouse");
        Assertions.assertFalse(main.houses.containsKey("Testhouse"));

        Assertions.assertEquals(main.getAllHousesInfo().size(), main.houses.size());
        Assertions.assertThrows(IllegalArgumentException.class, () -> main.deleteHouse("House not exist"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> main.getSigil("House not exist"));
    }
}
