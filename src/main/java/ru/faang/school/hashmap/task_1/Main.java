package ru.faang.school.hashmap.task_1;

import java.util.HashMap;
import java.util.Map;

public class Main {


    public static void main(String[] args) {



        Map<String,House> gameOfThrones = new HashMap<>();
        gameOfThrones.put("Starks",new House("Starks", "Winter is Coming"));
        gameOfThrones.put("Lanesters", new House("Lanisters", "Hear my roar"));
        gameOfThrones.put("Tallies", new House("Tallies", "Family, Duty, Honor"));
        gameOfThrones.put("Barrateons", new House("Barrateons", "Ours is the Fury"));



        House house = new House("Targarriens", "Fire and Blood");
        addNewHouse(house,gameOfThrones);

        delHouse("Lanesters", gameOfThrones);

        printHouse("Starks", gameOfThrones);

        printAllHouses(gameOfThrones);


    }


    public static void addNewHouse(House house, Map<String, House> gameOfThrones) {
        gameOfThrones.put(house.getName(), house);
    }

    public static void delHouse(String nameOfHouse, Map<String, House> gameOfThrones) {
        gameOfThrones.remove(nameOfHouse);
    }

    public static void printHouse(String nameOfHouse, Map<String, House> gameOfThrones){
        House house = gameOfThrones.get(nameOfHouse);
        System.out.println(house.toString());
    }

    public static void printAllHouses(Map<String, House> gameOfThrones) {
        for (var entry: gameOfThrones.entrySet()) {
            System.out.println(entry.toString());
        }
    }



}
