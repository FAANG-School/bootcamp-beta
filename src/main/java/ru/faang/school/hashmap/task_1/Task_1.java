package ru.faang.school.hashmap.task_1;

import ru.faang.school.hashmap.task_1.models.House;
import java.util.HashMap;

public class Task_1 {
    public static void main(String[] args) {
        var houses = new HashMap<String, House>();
        AddNewHouse(houses, "Stark", new House("Stark", "Stark's sigil."));
        AddNewHouse(houses, "Lannister", new House("Lannister", "Lannister's sigil."));
        AddNewHouse(houses, "Barateon", new House("Barateon", "Barateon's sigil."));

        var house = RemoveHouse(houses, "Stark");
        AddNewHouse(houses, house.getName(), house);

        SearchHouse(houses, "Lannister");
        System.out.println("\n");

        PrintHousesInfo(houses);
    }

    private static House AddNewHouse(HashMap<String, House> houses, String key, House house) {
        return houses.put(key, house);
    }
    private static House RemoveHouse(HashMap<String, House> houses, String key) {
        return houses.remove(key);
    }
    private static void SearchHouse(HashMap<String, House> houses, String key) {
        var house = houses.get(key);
        System.out.println("House's name: " + house.getName() +
                "\nHouse's sigil: " + house.getSigil());
    }
    private static void PrintHousesInfo(HashMap<String, House> houses) {
        for (var house : houses.entrySet()) {
            System.out.println("House's name: " + house.getValue().getName() +
                               "\nHouse's sigil: " + house.getValue().getSigil());
        }
    }
}
