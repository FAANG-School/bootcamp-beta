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

class ThronesGameTest {
    final static ThronesGame THRONES_GAME = new ThronesGame();

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
        THRONES_GAME.setHouses(houses);
    }

    private static Stream<Arguments> provideStringsForAddHouse() {
        return Stream.of(
                Arguments.of(null, null),
                Arguments.of("", "")
        );
    }

    @Test
    void testIsHouseExist() {
        assertFalse(THRONES_GAME.isHouseExist("Tully"));
        THRONES_GAME.addHouse("Tully", "Silver Trout");
        assertTrue(THRONES_GAME.isHouseExist("Tully"));
    }

    @ParameterizedTest
    @MethodSource("provideStringsForAddHouse")
    void testMethodsWithNullOrEmptyArgs(String arg1, String arg2) {
        assertThrows(IllegalArgumentException.class, () -> THRONES_GAME.isHouseExist(arg1));
        assertThrows(IllegalArgumentException.class, () -> THRONES_GAME.addHouse(arg1, arg2));
        assertThrows(IllegalArgumentException.class, () -> THRONES_GAME.removeHouseByName(arg1));
        assertThrows(IllegalArgumentException.class, () -> THRONES_GAME.getSigilByHouseName(arg1));
    }

    @Test
    void testAddExistingHouse() {
        assertTrue(THRONES_GAME.isHouseExist("Greyjoy"));

        String oldSigil = THRONES_GAME.getSigilByHouseName("Greyjoy");
        THRONES_GAME.addHouse("Greyjoy", "Gold Kraken");
        String newSigil = THRONES_GAME.getSigilByHouseName("Greyjoy");

        assertEquals(oldSigil, newSigil);
    }

    @Test
    void testAddNonExistingHouse() {
        assertFalse(THRONES_GAME.isHouseExist("Lannister"));
        THRONES_GAME.addHouse("Lannister", "Golden Lion");
        assertTrue(THRONES_GAME.isHouseExist("Lannister"));
    }

    @Test
    void testRemoveExistingHouse() {
        assertTrue(THRONES_GAME.isHouseExist("Bronn"));
        THRONES_GAME.removeHouseByName("Bronn");
        assertFalse(THRONES_GAME.isHouseExist("Bronn"));
    }

    @Test
    void testRemoveNonExistingHouse() {
        assertFalse(THRONES_GAME.isHouseExist("Tully"));
        THRONES_GAME.removeHouseByName("Tully");
        assertFalse(THRONES_GAME.isHouseExist("Tully"));
    }

    @Test
    void testGetSigilOfNonExistingHouse() {
        assertFalse(THRONES_GAME.isHouseExist("Martell"));
        assertEquals(THRONES_GAME.getSigilByHouseName("Martell"), "unknown");
    }

    @Test
    void testGetSigilOfExistingHouse() {
        assertTrue(THRONES_GAME.isHouseExist("Arryn"));
        assertEquals(THRONES_GAME.getSigilByHouseName("Arryn"), "White Falcon");
    }

    @Test
    void testSetHouses() {
        assertThrows(IllegalArgumentException.class, () -> THRONES_GAME.setHouses(null));
        assertThrows(HousesNotEmptyException.class, () -> THRONES_GAME.setHouses(new HashMap<>()));
    }
}