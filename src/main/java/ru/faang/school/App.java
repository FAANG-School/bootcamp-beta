package ru.faang.school;

import ru.faang.school.hashmap.task_1.House;

import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        //HashMap Task 1
        Map<String, House> houseMap = new HashMap<>();
        House lannister = new House("Lannister", "Lion");
        House stark = new House("Stark", "Wolf");
        House baratheon = new House("Baratheon", "Deer");
        houseMap.put("Lannister", lannister);
        houseMap.put("Stark", stark);
        houseMap.put("Baratheon", baratheon);



    }
}
