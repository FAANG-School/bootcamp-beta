package ru.faang.school.hashmap.task_1;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static Map<String, House> houses = new HashMap<>();

    static {
        houses.put("Stark", new House("Stark", "wolf"));
        houses.put("Lannister", new House("Lannister", "Lion"));
        houses.put("Barateon", new House("Barateon", "Deer"));
        houses.put("Targaryen", new House("Targaryen", "Dragon"));
    }

    public static void main(String[] args) {
        printAllHouses();
        addNewHouse("Arryn", "Griffon");
        addNewHouse("Greyjoy", "Kraken");
        printAllHouses();
        deleteHouse("Barateon");
        deleteHouse("Tyrell");
        findSigilByHouseName("Arryn");
        findSigilByHouseName("Tyrell");
        findSigilByHouseName("Stark");


    }

    public static void addNewHouse(String name, String sigil) {
        houses.put(name, new House(name, sigil));
        System.out.println(name + " added");
    }

    public static void deleteHouse(String name) {
        if (houses.containsKey(name)) {
            houses.remove(name);
            System.out.println(name + " removed");
        } else {
            System.out.println("There is no such name");
        }
    }

    public static void findSigilByHouseName(String name) {
        if (houses.containsKey(name)) {
            System.out.printf("Sigil of the House of %s - %s \n", name, houses.get(name).getSigil());
        } else {
            System.out.println("There is no such name");
        }
    }

    public static void printAllHouses() {
        System.out.println("* * *");
        houses.entrySet().stream()
                .forEach(entry -> System.out.printf("Sigil of the House of %s - %s \n", entry.getKey(), entry.getValue()));
        System.out.println("* * *");
    }

}
