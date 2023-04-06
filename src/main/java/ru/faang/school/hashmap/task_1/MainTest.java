package ru.faang.school.hashmap.task_1;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainTest {

    @Test
    public void mainTest() {

        Main main = new Main();

        main.addHouse("Mormont", "Bear");
        Assertions.assertTrue(main.map.containsKey("Mormont"));
        Assertions.assertEquals(main.getSigilByHouseName("Mormont"), "Bear");
        main.removeHouseByName("Mormont");
        Assertions.assertFalse(main.map.containsKey("Mormont"));

        Assertions.assertEquals(main.getHouses().size(), main.map.size());
        Assertions.assertThrows(IllegalArgumentException.class, () -> main.removeHouseByName("House not exist"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> main.getSigilByHouseName("House not exist"));

    }

}
