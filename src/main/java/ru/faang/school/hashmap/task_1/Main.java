package ru.faang.school.hashmap.task_1;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, House> houses = new HashMap<>();
        addHouse("Cool guys","Starks", "Wolf", houses);
        addHouse("Starks Friend", "Baratheon", "Deer", houses);
        addHouse("Rich Bastards", "Lanister", "Lion", houses);

        addHouse("n", "N", "Lion", houses);
        System.out.println(houses);

        System.out.println(houses.get("Cool guys"));

        printHouses(houses);


    }

    public static void findHouseByName(String name, Map<String, House> house){
        System.out.println(house.get(name));
    }

    public static void removeHouse(String name, Map<String, House> house){
        house.remove(name);
    }

    public static void addHouse(String nameOfHouse, String name, String sigil, Map<String, House> house){
        house.put(nameOfHouse, new House(name,sigil));
    }


    public static void printHouses(Map<String, House> house) {
        for(Map.Entry<String, House> entry : house.entrySet()){
            System.out.println(entry.getKey() + entry.getValue());
        }
    }
}
