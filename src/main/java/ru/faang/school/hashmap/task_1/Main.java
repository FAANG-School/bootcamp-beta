package ru.faang.school.hashmap.task_1;

import java.util.Collection;
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
        for (int i = 0; i < houseName.length - 4; i++) {
            houseMap.put(houseName[i], new House(houseName[i], houseSigil[i]));
        }
    }

    public static void main(String[] args) {
        printListOfHouse();
        System.out.println();

        addHouse(houseName[4], houseSigil[4]);
        printListOfHouse();
        System.out.println();

        delHouse("Bronn");
        printListOfHouse();
        System.out.println();

        System.out.println(getSigil("Baratheon"));;
    }

    private static House addHouse(final String name, final String sigil) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name cannot be null or empty");
        }
        if (sigil == null || sigil.isBlank()) {
            throw new IllegalArgumentException("sigil cannot be null or empty");
        }
        return houseMap.put(name, new House(name, sigil));
    }

    private static House delHouse(final String houseName) {
        if (houseName == null || houseName.isBlank()) {
            throw new IllegalArgumentException("houseName cannot be null or empty");
        }
        return houseMap.remove(houseName);
    }

    private static String getSigil(final String houseName) {
        if (houseName == null || houseName.isBlank()) {
            throw new IllegalArgumentException("houseName cannot be null or empty");
        }
        return houseMap.get(houseName).sigil();
    }

    private static Collection<House> getListOfHouse() {
        return houseMap.values();
    }

    private static void printListOfHouse() {
        getListOfHouse().forEach(System.out::println);
    }
}
