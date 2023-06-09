package ru.faang.school.hashmap.task_1.Solution;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        addHouse("Targaryen", "Three-headed dragon");
        addHouse("Stark", "Direwolf");
        addHouse("Lannister", "Lion rampant");
        addHouse("Greyjoy", "Golden kraken");
        addHouse("Arren", "Falcon's Nest");
        addHouse("Baratheon", "Black crowned deer");

        System.out.println(getHouseInfo("Arrsen") + "\n");
        System.out.println(getAllHousesInfo());
        removeHouse("Stark");
        System.out.println(getAllHousesInfo());
    }

    private static final Map<String, House> houses = new HashMap<>();

    private static void addHouse(String name, String sigil) {
        houses.put(name, new House(name, sigil));
    }

    private static void removeHouse(String name) {
       if (validation(name)){
           return;
       }
        houses.remove(name);
    }

    private static String getHouseInfo(String name) {
        if (validation(name)){
            return "";
        }
        return houses.get(name).toString();

    }

    private static String getAllHousesInfo() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, House> entry : houses.entrySet()) {
            sb.append(entry.getValue()).append("\n");
        }
        return sb.toString();
    }

    private static boolean validation(Object obj) {
        if (!houses.containsKey(obj)) {
            System.out.println("This house does not exist!");
            return true;
        }
        return false;
    }

}
