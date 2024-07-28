package ru.faang.school.hashmap.task_1.solution;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        new Main().start();
    }

    public void start(){
        Map<String, House> houses = new HashMap<>();
        addHouse(houses, new House("Старки", "Лютоволк"));
        addHouse(houses, new House("Ланнистеры", "Лев"));
        addHouse(houses, new House("Баратеоны", "Олень"));

        printHouses(houses);

        addHouse(houses, new House("Тиреллы", "Золотая роза"));
        removeHouse(houses, "Баратеоны");

        printHouses(houses);

        System.out.println(getSigil(houses, "Старки"));
    }

    private House addHouse(Map<String, House> houses, House house){
        return houses.put(house.getName(), house);
    }

    private House removeHouse(Map<String, House> houses, String house){
        return houses.remove(house);
    }

    private String getSigil(Map<String, House> houses, String house){
        return houses.get(house).getSigil();
    }

    private void printHouses(Map<String, House> houses){
        for(Map.Entry<String, House> house : houses.entrySet()){
            System.out.println(house);
        }
        System.out.println();
    }
}
