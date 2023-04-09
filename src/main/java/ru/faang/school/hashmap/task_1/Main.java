package ru.faang.school.hashmap.task_1;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<String, House> houseInfo = new HashMap<>();

    public static void main(String[] args) {
        addHouse("Stark", "wolf");
        addHouse("Barateon", "horns");
        addHouse("Lannister", "lion");
        printAllHouses();
    }

    public static void addHouse(String name, String sigil) {
        houseInfo.put(name, new House(name, sigil));
    }

    public static void removeHouse(String name) {
        houseInfo.remove(name);
    }

    public static void searchHouse(String name) {
        System.out.println(houseInfo.get(name).getSigil());
    }

    public static void printAllHouses() {
        for (Map.Entry<String, House> entry : houseInfo.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getSigil());
        }
    }
}
