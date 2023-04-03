package ru.faang.school.hashmap.task_1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

final class Westeros {
    private final Map<String, House> houseMap = new HashMap<>();

    public Westeros() {
        houseMap.put("stark", new House("stark", "wolf"));
        houseMap.put("lannister", new House("lannister", "lion"));
        houseMap.put("targaryen", new House("targaryen", "dragon"));
        houseMap.put("baratheon", new House("baratheon", "stag"));
        houseMap.put("tully", new House("tully", "trout"));
        houseMap.put("tyrell", new House("tyrell", "rose"));
        houseMap.put("arryn", new House("arryn", "falcon"));
        houseMap.put("greyjoy", new House("greyjoy", "kraken"));
        houseMap.put("martell", new House("martell", "sun and spear"));
    }

    public void addNewHouse(String key, House house) {
        houseMap.put(key, house);
    }

    public void removeHouseByName(String name) {
        houseMap.remove(name);
    }

    public String getSigilByName(String name) {
        House house = houseMap.get(name);

        if (house == null) return null;

        return house.sigil();
    }

    public void printAllHouses() {
        Arrays.toString(houseMap.values().toArray());
    }
}
