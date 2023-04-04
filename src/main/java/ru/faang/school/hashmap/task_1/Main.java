package ru.faang.school.hashmap.task_1;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private static final HashMap<String, House> mapOfHouses = new HashMap<>();

    public static void main(String[] args) {
        put("Stark", new House("Stark", "Stark's sigil"));
        put("Lannister", new House("Lannister", "Lannister's sigil"));
        put("Barateon", new House("Barateon", "Barateon's sigil"));

        printAllHouses();

        System.out.println(getSigilInfo("Lannister").toString());

        remove("Lannister");

        printAllHouses();
    }

    private static void put(String name, House house) {
        mapOfHouses.put(name, house);
    }

    private static void remove(String name) {
        mapOfHouses.remove(name);
    }

    private static House getSigilInfo(String name) {
        System.out.println(mapOfHouses.get(name).getSigil());
        return mapOfHouses.get(name);
    }

    private static void printAllHouses() {
        for (Map.Entry<String, House> entry : mapOfHouses.entrySet()) {
            System.out.println("House name " + entry.getKey() + ", house sigil" + entry.getValue().getSigil());
        }
    }
}
