package ru.faang.school.hashmap.task_1;

import java.util.HashMap;
import java.util.Map;

public class Main {


    public static void main(String[] args) {
        Map<String, House> houses = new HashMap<>();
        houses.put("Stark", new House("Stark", "Wolf"));
        houses.put("Lanister", new House("Lanister", "Lion"));
        houses.put("Baratteon", new House("Baratteon", "Deer"));
        addHouses(houses,"Bear","Mirrador");
        removeHouse(houses,"Lanister");
        searchFlag(houses,"Baratteon");
        getAllHouses(houses);
        System.out.println(searchFlag(houses,"Arro"));
    }
    private static void addHouses(Map<String, House> houses,String name, String sigil) {
        houses.put(name, new House(name, sigil));
    }

    private static void removeHouse(Map<String, House> houses, String name) {

        houses.remove(name);
    }

    private static String searchFlag(Map<String, House> houses, String houseName) {
        if (houses.isEmpty() || !(houses.containsKey(houseName))) {
            return "Error something goes wrong....";
        }
        return houses.get(houseName).getSigil();
    }

    private static void getAllHouses(Map<String, House> houses) {
        for (Map.Entry<String, House> entry : houses.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}