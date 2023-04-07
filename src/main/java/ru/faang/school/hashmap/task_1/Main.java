package ru.faang.school.hashmap.task_1;

import java.util.HashMap;
import java.util.Map;

public class Main {
    static Map<String, House> houses = new HashMap<>();

    public static void main(String[] args) {

        houses.put("Tully", new House("Tully", "Fish"));
        houses.put("Arryn", new House("Arryn", "Eagle"));
        houses.put("Baratheon", new House("Baratheon", "Deer"));
        houses.put("Lannister", new House("Lannister", "Lion"));
        houses.put("Targaryen", new House("Targaryen", "Dragon"));

        addHouse(new House("Stark", "Wolf"));
        deleteHouse("Arryn");
        getHouse("Lannister");
        allHouses();

    }

    public static void addHouse(House house) {
        houses.put(house.getName(), house);
    }

    public static void deleteHouse(String name) {
        houses.remove(name);
    }

    public static void getHouse(String name) {
        if (houses.get(name) != null) {
            System.out.println("sigil of house " + name + " - " + houses.get(name).getSigil());
        } else {
            System.out.println("house named " + name + " not found");
        }
    }

    public static void allHouses() {
        System.out.println("All houses:");
        for (Map.Entry<String, House> entry: houses.entrySet()) {
            System.out.println("name of house: " + entry.getKey() + "; sigil: " + entry.getValue().getSigil());
        }
    }

}
