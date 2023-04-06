package ru.faang.school.hashmap.task_1;

import java.util.HashMap;
import java.util.Map;

public class GameOfThrones {
    public static void main(String[] args) {
        //HashMap Task 1
        Map<String, House> houseMap = new HashMap<>();
        House lannister = new House("Lannister", "Lion");
        House stark = new House("Stark", "Wolf");
        House baratheon = new House("Baratheon", "Deer");
        put(houseMap,"Lannister", lannister);
        put(houseMap,"Stark", stark);
        put(houseMap,"Baratheon", baratheon);
        remove(houseMap,"Baratheon");
        searchHouse(houseMap, "Stark");
        outPutAllHouse(houseMap);
    }

    private static void put(Map<String, House> houseMap, String key, House house){
        houseMap.put(key, house);
    }


    private static void remove(Map<String, House> houseMap, String key){
        houseMap.remove(key);
    }

    private static void searchHouse(Map<String, House> houseMap, String key){
        int count = 0;
        System.out.println("Search result: ");
        for (Map.Entry<String, House> entry : houseMap.entrySet())
        {
            House house = entry.getValue();
            String houseName = house.getName();
            String houseSigil = house.getSigil();
            if(houseName.equals(key)){
                count++;
                System.out.println("House Name: " + houseName + ", House Sigil: " + houseSigil);
            }
        }
        if(count == 0){
            System.out.println("In this hashmap is no house with name: " + key);
        }
    }

    private static void outPutAllHouse(Map<String, House> houseMap){
        System.out.println("Result of output all house: ");
        for (Map.Entry<String, House> entry : houseMap.entrySet()) {
            String houseName = entry.getKey();
            House house = entry.getValue();
            String houseSigil = house.getSigil();
            System.out.println("House Name: " + houseName + ", House Sigil: " + houseSigil);
        }
    }


}
