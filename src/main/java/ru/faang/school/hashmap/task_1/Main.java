package ru.faang.school.hashmap.task_1;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static Map<String, House> houses = new HashMap<>();

    public static void main(String[] args) {

        houses.put("Stark", new House("Stark" , "Direwolf"));
        houses.put("Lannisters", new House("Lannisters" , "Lion"));
        houses.put("Baratheon", new House("Baratheon" , "Stag"));

        addHouse("Greyjoy", new House("Greyjoy" , "Kraken"));

        removeHouse("Lannisters");

        printSigilByName("Baratheon");

        printAllHouses();




    }

    private static void addHouse(String name, House house){
        houses.put(name, house);
    }

    private static void removeHouse(String name){
        houses.remove(name);
    }

    private static void printSigilByName(String name){
        System.out.println(houses.get(name).getSigil());
    }

    private static void printAllHouses(){
        for (Map.Entry<String, House> entry : houses.entrySet()){
            System.out.println(entry.getValue());
        }
    }


}
