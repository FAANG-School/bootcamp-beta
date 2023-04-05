package ru.faang.school.hashmap.task_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static Map<String, House> houseMap = new HashMap<>();

    static {
        House starkHouse = new House();
        starkHouse.setName("Старк");
        starkHouse.setSigil("Winter is coming");

        House lannisterHouse = new House();
        lannisterHouse.setName("Ланнистер");
        lannisterHouse.setSigil("Hear me roar");

        House barateonHouse = new House();
        barateonHouse.setName("Баратеон");
        barateonHouse.setSigil("Ours is the fury");

        houseMap.put("Старк", starkHouse);
        houseMap.put("Ланнистер", lannisterHouse);
        houseMap.put("Баратеон", barateonHouse);
    }

    public static void main(String[] args) {
        getAllHouses();
    }

    public static void addNewHouse(House house) {
        String houseName = house.getName();
        houseMap.put(houseName, house);
    }

    public static void removeHouse(String houseName) {
        houseMap.remove(houseName);
    }

    public static String searchAndGetInfoAboutSigil(String houseName) {
        if (!houseMap.containsKey(houseName)) {
            return "Об этом дома еще нет данных";
        }
        return houseMap.get(houseName).getSigil();
    }

    public static List getAllHouses() {
        List<House> houseList = new ArrayList<>();

        for (var pair : houseMap.entrySet()) {
            String house = pair.getKey();
            String sigil = pair.getValue().getSigil();
            houseList.add(pair.getValue());
            System.out.println(house + ", герб: " + sigil);
        }
        return houseList;
    }

}
