package ru.faang.school.hashmap.task_1.AlexTtkn_task_1;

import java.util.HashMap;
import java.util.Map;

public class Main {

    private static Map<String,House> map = new HashMap<>();

    public static void main(String[] args) {
        map.put("Старк", new House("Дворец", "Герб Дворца"));
        map.put("Ланнистер", new House("Усадьба", "Герб Усадьбы"));
        map.put("Баратеон", new House("Замок", "Герб Замка"));

    }

    public static void addNewHouse(String houseName, House house) {
        if (houseName == null) {
            throw new NullPointerException("Укажите имя дома.");
        }
        map.put(houseName, house);
    }

    public static void deleteHouse(String houseName) {
        map.remove(houseName);
    }

    public static String searchHouse(String houseName) {
        return  map.get(houseName).getSigil();
    }
    public static void getHouses() {
        for (Map.Entry<String, House> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getSigil());
        }
    }
}
