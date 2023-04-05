package ru.faang.school.hashmap.task_1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;


class MainTest {

    private Main underTest;

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        underTest = new Main();
        underTest.houses.put("Lannister", new House("Lannister", "The Lion"));
        underTest.houses.put("Targaryen", new House("Targaryen", "The Three-Headed Dragon"));
        underTest.houses.put("Baratheon", new House("Baratheon" ,"The Stag"));
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    @DisplayName("Add new house")
    void testAddHouse() {
        //given
        String name = "Stark";
        String sigil = "The Direwolf";
        int size = underTest.houses.size();
        //when
        underTest.addHouse(name, sigil);
        //then
        assertEquals(size + 1, underTest.houses.size());
    }

    @Test
    void deleteHouseByName() {
        //given
        String name = "Lannister";
        //when
        underTest.deleteHouseByName(name);
        //then
        assertNull(underTest.houses.get(name));
    }

    @Test
    void getSigilInfoByName() {
        String name = "Targaryen";
        underTest.getSigilInfoByName(name);
        assertEquals("The Three-Headed Dragon", outputStreamCaptor.toString().trim());
    }

    @Test
    void printAllHouses() {
        underTest.printAllHouses();
        String expected = "name - \"Lannister\", sigil - \"The Lion\"\r\n" +
                "name - \"Targaryen\", sigil - \"The Three-Headed Dragon\"\r\n" +
                "name - \"Baratheon\", sigil - \"The Stag\"";
        assertEquals(expected, outputStreamCaptor.toString().trim());
    }

}