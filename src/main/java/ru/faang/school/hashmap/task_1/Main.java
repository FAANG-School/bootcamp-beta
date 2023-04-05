package ru.faang.school.hashmap.task_1;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Main {
    private final Map<String, House> houseMap = new HashMap<>();

    {
        houseMap.put("Stark", new House("Stark", "The Direwolf"));
        houseMap.put("Lannister", new House("Lannister", "The Lion"));
        houseMap.put("Targaryen", new House("Targaryen", "The Three-Headed Dragon"));
        houseMap.put("Baratheon", new House("Baratheon", "The Stag"));
        houseMap.put("Tully", new House("Tully", "The Trout"));
        houseMap.put("Tyrell", new House("Tyrell", "The Rose"));
        houseMap.put("Arryn", new House("Arryn", "The Falcon"));
        houseMap.put("Greyjoy", new House("Greyjoy", "The Kraken"));
    }

    public static void main(String[] args) {
        Main main = new Main();

        House houseMartell = new House("Martell", "The Sun and Spear");
        main.addHouse(houseMartell);

        main.removeHouse("Tully");

        main.showHouse("Baratheon1");

        main.showAllHouses();
    }


    private void addHouse(House house) {
        houseMap.putIfAbsent(house.getName(), house);
    }

    private void removeHouse(String key) {
        houseMap.remove(key);
    }

    private void showHouse(String key) {
        House house = houseMap.get(key);
        if (Objects.isNull(house)) {
            System.out.println("House not found");
        } else {
            System.out.println(house);
        }
    }

    private void showAllHouses() {
        for (Map.Entry<String, House> entry : houseMap.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}