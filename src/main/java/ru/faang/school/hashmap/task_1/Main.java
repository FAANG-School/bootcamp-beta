package ru.faang.school.hashmap.task_1;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    private final static Map<String, House> houseMap;

    private final static String[] houseName = new String[]
            {"Bronn", "Arryn", "Baratheon", "Greyjoy", "Lannister", "Martell", "Stark", "Tully"};
    private final static String[] houseSigil = new String[]
            {"Flaming Arrow", "White Falcon", "Black Stag", "Gold Kraken",
                    "Golden Lion", "Red Sun", "Grey Direwolf", "Silver Trout"};

    static {
        houseMap = new LinkedHashMap<>();
    }

    public static void main(String[] args) {
        for (int i = 0; i < houseName.length - 4; i++) {
            houseMap.put(houseName[i], new House(houseName[i], houseSigil[i]));
        }

        printListOfHouse();
        System.out.println();

        addHouse(houseName[4], houseSigil[4]);
        printListOfHouse();
        System.out.println();

        delHouse("Bronn");
        printListOfHouse();
        System.out.println();

        printSigil("Baratheon");
    }

    private static void addHouse(final String name, final String sigil) {
        houseMap.put(name, new House(name, sigil));
    }

    private static void delHouse(final String houseName) {
        houseMap.remove(houseName);
    }

    private static void printSigil(final String houseName) {
        System.out.println(houseMap.get(houseName).getSigil());
    }

    private static void printListOfHouse() {
        houseMap.values().forEach(System.out::println);
    }
}
