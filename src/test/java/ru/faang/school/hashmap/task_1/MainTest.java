package ru.faang.school.hashmap.task_1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

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

    @ParameterizedTest
    @MethodSource("provideStringsForAddHouse")
    void addHouseWithNullOrEmptyArgs(String name, String sigil) {
        assertThrows(IllegalArgumentException.class, () -> MAIN.addHouse(name, sigil));
    }

    @Test
    void addExistingHouse() {
        assertTrue(MAIN.isHouseExist("Greyjoy"));

        String oldSigil = MAIN.getSigilByHouseName("Greyjoy");
        MAIN.addHouse("Greyjoy", "Gold Kraken");
        String newSigil = MAIN.getSigilByHouseName("Greyjoy");

        assertEquals(oldSigil, newSigil);
    }

    @Test
    void addNonExistingHouse() {
        assertFalse(MAIN.isHouseExist("Lannister"));
        MAIN.addHouse("Lannister", "Golden Lion");
        assertTrue(MAIN.isHouseExist("Lannister"));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void removeHouseWithNullOrEmptyArg(String houseName) {
        assertThrows(IllegalArgumentException.class, () -> MAIN.removeHouseByName(houseName));
    }

    @Test
    void removeExistingHouse() {
        assertTrue(MAIN.isHouseExist("Bronn"));
        MAIN.removeHouseByName("Bronn");
        assertFalse(MAIN.isHouseExist("Bronn"));
    }

    @Test
    void delNonExistingHouse() {
        assertFalse(MAIN.isHouseExist("Tully"));
        MAIN.removeHouseByName("Tully");
        assertFalse(MAIN.isHouseExist("Tully"));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void getSigilWithNullOrEmptyArg(String houseName) {
        assertThrows(RuntimeException.class, () -> MAIN.getSigilByHouseName(houseName));
    }

    @Test
    void getSigilOfNonExistingHouse() {
        assertFalse(MAIN.isHouseExist("Martell"));
        assertEquals(MAIN.getSigilByHouseName("Martell"), "unknown");
    }

    @Test
    void getSigilOfExistingHouse() {
        assertTrue(MAIN.isHouseExist("Arryn"));
        assertEquals(MAIN.getSigilByHouseName("Arryn"), "White Falcon");
    }

    @Test
    void getListOfHouse() {
        assertFalse(MAIN.getListOfHouse().isEmpty());
    }
}