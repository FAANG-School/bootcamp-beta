package ru.faang.school.hashmap.task_1;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class Tests {
    private final static ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeAll
    public static void setUpStream() {
        System.setOut(new PrintStream(outContent));
    }
    @Test
    public void testAddHouse() {
        House stark = new House("Старк","Голова серого лютоволка на бело-зелёном фоне");
        House lannister = new House("Ланнистер","Золотой лев, стоящий на задних лапах, на малиновом поле");
        House barateon = new House("Баратеон","Черный коронованный олень, стоящий на задних ногах, на золотом поле");
        House tully = new House("Талли","Прыгающая серебряная форель среди красно-синих волн");
        Main test = new Main();
        Map<String,House> map = new HashMap<>();
        map.put(stark.getName(),stark);
        map.put(lannister.getName(),lannister);
        map.put(barateon.getName(),barateon);
        map.put(tully.getName(),tully);
        test.addHouse(stark);
        test.addHouse(lannister);
        test.addHouse(barateon);
        test.addHouse(tully);
        assertEquals(map,test.getHouses());
    }

    @Test
    public void testRemoveHouse() {
        Main test = new Main();
        House tully = new House("Талли","Прыгающая серебряная форель среди красно-синих волн");
        test.addHouse(tully);
        assertEquals(test.getHouseByName(tully.getName()),tully);
        test.removeHouse(tully.getName());
        assertNull(test.getHouseByName(tully.getName()));
        assertTrue(test.getHouses().isEmpty());
    }

    @Test
    public void testRemoveHouseNotExist() {
        Main test = new Main();
        assertThrows(IllegalStateException.class, () -> {
            test.removeHouse("123");
        });
    }

    @Test
    public void testGetHouseByName() {
        Main test = new Main();
        assertNull(test.getHouseByName("bla-bla-bla"));
    }

    @Test
    public void testPrintSigil() {
        Main test = new Main();
        House stark = new House("Старк","Голова серого лютоволка на бело-зелёном фоне");
        House tully = new House("Талли","Прыгающая серебряная форель среди красно-синих волн");
        test.addHouse(stark);
        test.addHouse(tully);
        test.printSigilInfo(stark.getName());
        String expected = "Дом "+stark.getName()+" имеет герб '"+stark.getSigil()+"'\n";
        outContent.reset();
        test.printSigilInfo(tully.getName());
        String expected1 = "Дом "+tully.getName()+" имеет герб '"+tully.getSigil()+"'\n";
        assertEquals(expected1,outContent.toString());
    }

}
