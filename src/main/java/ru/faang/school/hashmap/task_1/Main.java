package ru.faang.school.hashmap.task_1;

import java.util.HashMap;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        Map<String, House> map = new HashMap<>();
        map.put("Дом1", new House("Дом1", "Герб1"));
        map.put("Дом2", new House("Дом2", "Герб2"));
        map.put("Дом3", new House("Дом3", "Герб3"));
        map.put("Дом4", new House("Дом4", "Герб4"));

        add(map, "Дом5", "Герб5");
        showAll(map);
        remove(map, "Дом1");
        showAll(map);
        show(map, "Дом2");
    }

    public static void add(Map<String, House> houseMap, String home, String gerb) {
        houseMap.put(home, new House(home, gerb));
    }

    public static void remove(Map<String, House> houseMap, String home) {
        houseMap.remove(home);
    }

    public static void show(Map<String, House> houseMap, String home) {
        System.out.println(houseMap.get(home));
        System.out.println();
    }

    public static void showAll(Map<String, House> houseMap) {
        for (Map.Entry<String, House> entry : houseMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue().getSigil());
        }
        System.out.println();
    }
}



