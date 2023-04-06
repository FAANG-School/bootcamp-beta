package ru.faang.school.hashmap.task_1;

import java.util.HashMap;
import java.util.Map;

public class Main {
    static HashMap<String, House> houses = new HashMap<>();
    public static void main(String[] args) {
        addHouse(new House("Stark", "Direwolf"));
        addHouse(new House("Lannister", "Lion"));
        addHouse(new House("Baratheon", "Stag"));
        addHouse(new House("Allyrion of Godsgrace", "Hand"));
        addHouse(new House("Cafferen of Fawnton", "Two white fawns"));

        System.out.println();

        removeHouse("Strange");
        removeHouse("Stark");

        System.out.println();

        showAllHouses();

        System.out.println();

        info("Lannister");
        info("Strange");
    }

    public static void addHouse(House house) {
        if(houses.containsKey(house.getName())) {
            System.out.println("There's already house with name \"" + house.getName() + "\".");
            return;
        }
        houses.put(house.getName(), house);
        System.out.println("House with name \"" + house.getName() + "\" is added to map.");
    }
    public static void removeHouse(String name) {
        if(houses.remove(name) == null) {
            System.out.println("There is no such house \"" + name + "\".");
        } else {
            System.out.println("House with name \"" + name + "\" is deleted.");
        }
    }

    public static void showAllHouses() {
        if(houses.size() == 0) {
            System.out.println("There's no any house on the map.");
            return;
        }
        System.out.println("List of houses:");
        for(Map.Entry<String, House> entry : houses.entrySet()){
            System.out.println("House:" + entry.getKey() + ". House's sigil:" + entry.getValue().getSigil() + ".");
        }
    }

    public static void info(String name) {
        House house = houses.get(name);
        if(house == null) {
            System.out.println("There is no such house \"" + name + "\".");
            return;
        }
        System.out.println("House: \"" + house.getName() + "\". Sigil: \"" + house.getSigil() + "\".");
    }
}
