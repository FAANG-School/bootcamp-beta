package ru.faang.school.hashmap.task_1;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {
    private static final HashMap<String, House> HOUSE_MAP = new HashMap<>();

    public static void main(String[] args) {

        House lannisterHouse = new House("Lannister", "Lion");
        House starkHouse = new House("Stark", "Direwolf");
        House baratheonHouse = new House("Baratheon", "Stag");
        House tullyHouse = new House("Tully", "Trout");
        House tyrellHouse = new House("Tyrell", "Rose");

        HOUSE_MAP.put("Lannister", lannisterHouse);
        HOUSE_MAP.put("Stark", starkHouse);
        HOUSE_MAP.put("Baratheon", baratheonHouse);
        HOUSE_MAP.put("Tully", tullyHouse);
        HOUSE_MAP.put("Tyrell", tyrellHouse);

        House targaryenHouse = new House("Targaryen", "Dragon");
        HOUSE_MAP.put("Targaryen", targaryenHouse);

        HOUSE_MAP.remove("Tully");

        displaySigilByHouseName(HOUSE_MAP, "Parrot");
        displaySigilByHouseName(HOUSE_MAP, "Baratheon");

        Set<Map.Entry<String, House>> entriesHouses = HOUSE_MAP.entrySet();
        for (Map.Entry<String, House> entry : entriesHouses) {
            System.out.println("House: " + entry.getKey() + " --->" + entry.getValue());
        }
    }
    private static void displaySigilByHouseName(Map<String, House> HOUSE_MAP, String name) {
        House house = HOUSE_MAP.get(name);
        if (house != null) {
            System.out.println("Sigil of " + name + ": " + house.getSigil());
        } else {
            System.out.println("House not found: " + name);
        }
    }

}
