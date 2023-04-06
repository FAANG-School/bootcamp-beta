package ru.faang.school.hashmap.task_1;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, House> westerosHouseMap = new HashMap<>();
        House lanister = new House("Lannister of Casterly Rock", "Lion");
        House stark = new House("Stark of Winterfell", "Grey wolf");
        House greyjoy = new House("Greyjoy of Pyke", "Golden kraken");
        addHouse(westerosHouseMap, lanister);
        addHouse(westerosHouseMap, stark);
        addHouse(westerosHouseMap, greyjoy);
        showAllHouses(westerosHouseMap);
        removeHouse(westerosHouseMap, "Greyjoy of Pyke");
        System.out.println();
        showAllHouses(westerosHouseMap);
        System.out.println();
        System.out.println(showSigilbyName(westerosHouseMap, "Greyjoy of Pyke"));
        System.out.println();
        System.out.println(showSigilbyName(westerosHouseMap, "Stark of Winterfell"));
    }

    static void addHouse (Map<String, House> map, House house) {
        map.put(house.getName(), house);
    }

    static void removeHouse(Map<String, House> map, String name) {
        map.remove(name);
    }

    static void showAllHouses(Map<String, House> map) {
        for (Map.Entry<String, House> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getSigil());
        }
    }

    static String showSigilbyName (Map<String, House> map, String name) {
        House house = map.get(name);

        if (house == null) {
            return name + " нет на карте Westeros";
        } else {
            return house.getSigil();
        }

    }
}
