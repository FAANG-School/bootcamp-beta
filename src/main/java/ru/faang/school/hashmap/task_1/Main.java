package ru.faang.school.hashmap.task_1;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final HashMap<String, House> HOUSE = new HashMap<>();

    public static void main(String[] args) {
        House lannisterHouse = new House("Lannister", "Lion");
        House starkHouse = new House("Stark", "Direwolf");
        House baratheonHouse = new House("Baratheon", "Stag");
        House tullyHouse = new House("Tully", "Trout");
        House tyrellHouse = new House("Tyrell", "Rose");

        HOUSE.put("Lannister", lannisterHouse);
        HOUSE.put("Stark", starkHouse);
        HOUSE.put("Baratheon", baratheonHouse);
        HOUSE.put("Tully", tullyHouse);
        HOUSE.put("Tyrell", tyrellHouse);

        House targaryenHouse = new House("Targaryen", "Dragon");
        HOUSE.put("Targaryen", targaryenHouse);

        HOUSE.remove("Tully");

        displayAllHouses();
        displaySigilByHouseName("Parrot");
        displaySigilByHouseName("Baratheon");
    }

    private static void displayAllHouses() {
        for (Map.Entry<String, House> entry : HOUSE.entrySet()) {
            System.out.println("House: " + entry.getKey() + " --->" + entry.getValue());
        }
    }
    private static void displaySigilByHouseName(String name) {
        if (HOUSE.containsKey(name)) {
            System.out.println("Sigil of " + name + ": " + HOUSE.get(name).getSigil());
        } else {
            System.out.println("House not found: " + name);
        }
    }

}
