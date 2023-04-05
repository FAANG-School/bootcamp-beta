package ru.faang.school.hashmap.task_1;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static Map<String, House> houses = new HashMap<>();
    static {
        houses.put("Stark", new House("Stark", "wolf"));
        houses.put("Frey", new House("Frey", "towers"));
        houses.put("Tyrell", new House("Tyrell", "flower"));
    }

    public static void main(String[] args) {

        printHouses();
        addHouse("ZUZU", "bebe");
        printHouses();
        removeHouse("Stark");
        printHouses();
        System.out.println(getSigil("ZUZU"));
    }

    public static House addHouse(String name, String sigil){
        return houses.put(name, new House(name, sigil));
    }

    public static House removeHouse(String name){
        return houses.remove(name);
    }

    public static String getSigil(String name){
        String sigil = null;
        try {
            sigil = houses.get(name).getSigil();
        } catch (Exception e) {
            System.out.println("error during method execution");
        }
        return sigil;
    }

    public static void printHouses(){
        for (House house : houses.values()) {
            System.out.printf("Name: %s, sigil: %s \n", house.getName(), house.getSigil());
        }
    }

}

