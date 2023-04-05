package ru.faang.school.hashmap.task_1;

import java.util.HashMap;
import java.util.Map;

public class Main {
    static Map<String, House> houseMap = new HashMap<>();

    public static void addHouse(String name, String sigil) {
        House house = new House(name.toLowerCase(),sigil.toLowerCase());
        houseMap.put(name.toLowerCase(),house);
    }

    public static void deleteHouse(String name) {
        houseMap.remove(name.toLowerCase());
    }

    public static void findHouse(String name) {
        if(houseMap.containsKey(name.toLowerCase())) {
            System.out.println(houseMap.get(name.toLowerCase()).getSigil());
        } else {
            System.out.println(name + " not found");
        }
    }

    public static void printAll() {
        for(var entry : houseMap.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue().getSigil());
        }
    }

    public static void main(String[] args) {
        addHouse("Stark", "Wolf");
        addHouse("Lannister", "Lion");
        addHouse("Barateon", "Deer");
        deleteHouse("Lannister");
        findHouse("Talli");
        printAll();

    }
}
