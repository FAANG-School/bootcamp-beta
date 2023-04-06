package ru.faang.school.hashmap.task_1;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class GameOfThrones {
    public static void main(String[] args) {
        //HashMap Task 1
        Map<String, House> houseMap = new HashMap<>();
        House lannister = new House("Lannister", "Lion");
        House stark = new House("Stark", "Wolf");
        House baratheon = new House("Baratheon", "Deer");
        addHouse(houseMap,"Lannister", lannister);
        addHouse(houseMap,"Stark", stark);
        addHouse(houseMap,"Baratheon", baratheon);
        removeHouse(houseMap,"Baratheon");
        outPut(houseMap);
    }

    public static void addHouse(Map<String, House> houseMap,String key,House house){
        houseMap.put(key, house);
    }

    public static void removeHouse(Map<String, House> houseMap,String key){
        houseMap.remove(key);
    }

    public static void outPut(Map<String, House> houseMap){
        for (Map.Entry<String, House> entry : houseMap.entrySet()) {
            String houseName = entry.getKey();
            House house = entry.getValue();
            String houseSigil = house.getSigil();
            System.out.println("House Name: " + houseName + ", House Sigil: " + houseSigil);
        }
    }


}
