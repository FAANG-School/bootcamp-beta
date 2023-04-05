package ru.faang.school.hashmap.task_1;

import java.util.Map;

public class HouseService {
    public static void putNewHouses(Map<String, House> houseMap, House... newHouses) {
        for (House house : newHouses) {
            houseMap.put(house.getName(), house);
            System.out.println(house.getName() + " добавлен");
        }
    }

    public static void printHousesInfo(Map<String, House> houseMap) {
        for (Map.Entry<String, House> entry : houseMap.entrySet()) {
            System.out.println("ДОМ: " + entry.getKey() + ", " + "ГЕРБ: " + entry.getValue().getSigil());
        }
    }

    public static void removeHouse(Map<String, House> houseMap, String name) {
        if (houseMap.containsKey(name)) {
            houseMap.remove(name);
            System.out.println(name + " удален");
        } else {
            System.out.println(name + " не найден в списке");
        }
    }

    public static void getHouseInfo(Map<String, House> houseMap, String name) {
        if (houseMap.containsKey(name)) {
            House house = houseMap.get(name);
            System.out.println(house.getSigil());
        } else {
            System.out.println(name + " не найден в списке");
        }
    }
}
