package ru.faang.school.hashmap.task_1;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private static final Map<String, House> houseMap = new HashMap<>();

    public static void main(String[] args) {

        House stark = new House("Старк", "эм");
        House lannister = new House("Ланнистер", "ok");
        House barateon = new House("Баратеон", "da");

        add(stark.getName(), stark);
        add(lannister.getName(), lannister);
        add(barateon.getName(), barateon);

        remove(stark.getName());

        find(lannister.getName());

        printAll();
    }
    private static void add(String name, House house) {
        houseMap.put(name, house);
    }
    private static void remove(String name) {
        houseMap.remove(name);
    }
    private static String find(String name) {
        return houseMap.get(name).getSigil();
    }

    private static void printAll() {
        houseMap.forEach((s, house) -> System.out.println(s + ":" + house.getSigil()));
    }
}
