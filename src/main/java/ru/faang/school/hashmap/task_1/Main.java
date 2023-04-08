package ru.faang.school.hashmap.task_1;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Main {

    private static final Map<String, House> HOUSE_MAP = new HashMap<>();

    public static void main(String[] args) {
        addHouse("Stark", "Grey direwolf on a white field");
        addHouse("Lannister", "Golden lion rampant on a crimson field");
        addHouse("Targaryen", "Red three-headed dragon on a black field");

        removeHouse("Lannister");
        removeHouse("test");
        findHouseByName("Targaryen");
        printAll();
    }

    public static void addHouse(String name, String sigill) {
        House house = new House(name, sigill);
        HOUSE_MAP.put(house.name(), house);
    }

    public static void removeHouse(String name) {
        if (HOUSE_MAP.remove(name) == null) {
            System.out.println("There's no house with name " + name);
        }
    }

    public static void findHouseByName(String name) {
        House house = Optional.ofNullable(HOUSE_MAP.get(name))
                .orElseThrow(() -> new RuntimeException("House with name " + name + " not found!"));

        System.out.println(house.sigill());
    }

    public static void printAll() {
        HOUSE_MAP.values().forEach(System.out::println);
    }
}
