package ru.faang.school.hashmap.task_1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    final static Main MAIN = new Main();
    final static Map<String, House> HOUSE_MAP = MAIN.getHouseMap();

    @BeforeAll
    static void setUp() {
        try (Scanner scanner = new Scanner(
                new File("src/test/java/ru/faang/school/hashmap/task_1/sample.csv"))) {
            scanner.useDelimiter("\n");
            for (int i = 0; i <= 3; i++) {
                String[] house = scanner.next().split(";");
                HOUSE_MAP.put(house[0], new House(house[0], house[1]));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
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
        assertTrue(HOUSE_MAP.containsKey("Greyjoy"));

        String oldSigil = MAIN.getSigilByHouseName("Greyjoy");
        MAIN.addHouse("Greyjoy", "Gold Kraken");
        String newSigil = MAIN.getSigilByHouseName("Greyjoy");

        assertEquals(oldSigil, newSigil);
    }

    @Test
    void addNonExistingHouse() {
        assertFalse(HOUSE_MAP.containsKey("Lannister"));
        MAIN.addHouse("Lannister", "Golden Lion");
        assertTrue(HOUSE_MAP.containsKey("Lannister"));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void delHouseWithNullOrEmptyArg(String houseName) {
        assertThrows(IllegalArgumentException.class, () -> MAIN.removeHouseByName(houseName));
    }

    @Test
    void delExistingHouse() {
        assertTrue(HOUSE_MAP.containsKey("Bronn"));
        MAIN.removeHouseByName("Bronn");
        assertFalse(HOUSE_MAP.containsKey("Bronn"));
    }

    @Test
    void delNonExistingHouse() {
        assertFalse(HOUSE_MAP.containsKey("Tully"));
        MAIN.removeHouseByName("Tully");
        assertFalse(HOUSE_MAP.containsKey("Tully"));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void getSigilWithNullOrEmptyArg(String houseName) {
        assertThrows(RuntimeException.class, () -> MAIN.getSigilByHouseName(houseName));
    }

    @Test
    void getSigilOfNonExistingHouse() {
        assertFalse(HOUSE_MAP.containsKey("Martell"));
        assertEquals(MAIN.getSigilByHouseName("Martell"), "unknown");
    }

    @Test
    void getSigilOfExistingHouse() {
        assertTrue(HOUSE_MAP.containsKey("Arryn"));
        assertEquals(MAIN.getSigilByHouseName("Arryn"), "White Falcon");
    }

    @Test
    void getListOfHouse() {
        assertFalse(MAIN.getListOfHouse().isEmpty());
    }
}