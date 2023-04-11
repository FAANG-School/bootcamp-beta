package ru.faang.school.hashmap.task_1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.faang.school.hashmap.task_1.exception.HousesNotEmptyException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    final static Main MAIN = new Main();

    @BeforeAll
    static void setUp() {
        Map<String, House> houses = new HashMap<>();
        try (Scanner scanner = new Scanner(
                new File("src/test/java/ru/faang/school/hashmap/task_1/sample.csv"))) {
            scanner.useDelimiter("\n");
            for (int i = 0; i <= 3; i++) {
                String[] house = scanner.next().split(";");
                houses.put(house[0], new House(house[0], house[1]));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        MAIN.setHouses(houses);
    }

    private static Stream<Arguments> provideStringsForAddHouse() {
        return Stream.of(
                Arguments.of(null, null),
                Arguments.of("", "")
        );
    }

    @Test
    void testIsHouseExist() {
        assertFalse(MAIN.isHouseExist("Tully"));
        MAIN.addHouse("Tully", "Silver Trout");
        assertTrue(MAIN.isHouseExist("Tully"));
    }

    @ParameterizedTest
    @MethodSource("provideStringsForAddHouse")
    void testMethodsWithNullOrEmptyArgs(String arg1, String arg2) {
        assertThrows(IllegalArgumentException.class, () -> MAIN.isHouseExist(arg1));
        assertThrows(IllegalArgumentException.class, () -> MAIN.addHouse(arg1, arg2));
        assertThrows(IllegalArgumentException.class, () -> MAIN.removeHouseByName(arg1));
        assertThrows(IllegalArgumentException.class, () -> MAIN.getSigilByHouseName(arg1));
    }

    @Test
    void testAddExistingHouse() {
        assertTrue(MAIN.isHouseExist("Greyjoy"));

        String oldSigil = MAIN.getSigilByHouseName("Greyjoy");
        MAIN.addHouse("Greyjoy", "Gold Kraken");
        String newSigil = MAIN.getSigilByHouseName("Greyjoy");

        assertEquals(oldSigil, newSigil);
    }

    @Test
    void testAddNonExistingHouse() {
        assertFalse(MAIN.isHouseExist("Lannister"));
        MAIN.addHouse("Lannister", "Golden Lion");
        assertTrue(MAIN.isHouseExist("Lannister"));
    }

    @Test
    void testRemoveExistingHouse() {
        assertTrue(MAIN.isHouseExist("Bronn"));
        MAIN.removeHouseByName("Bronn");
        assertFalse(MAIN.isHouseExist("Bronn"));
    }

    @Test
    void testRemoveNonExistingHouse() {
        assertFalse(MAIN.isHouseExist("Tully"));
        MAIN.removeHouseByName("Tully");
        assertFalse(MAIN.isHouseExist("Tully"));
    }

    @Test
    void testGetSigilOfNonExistingHouse() {
        assertFalse(MAIN.isHouseExist("Martell"));
        assertEquals(MAIN.getSigilByHouseName("Martell"), "unknown");
    }

    @Test
    void testGetSigilOfExistingHouse() {
        assertTrue(MAIN.isHouseExist("Arryn"));
        assertEquals(MAIN.getSigilByHouseName("Arryn"), "White Falcon");
    }

    @Test
    void testSetHouses() {
        assertThrows(IllegalArgumentException.class, () -> MAIN.setHouses(null));
        assertThrows(HousesNotEmptyException.class, () -> MAIN.setHouses(new HashMap<>()));
    }
}