package ru.faang.school.hashmap.task_1;

import java.util.HashMap;
import java.util.Map;

public class Main {
    static Map<String, House> houses = new HashMap<>();

    public static void main(String[] args) {
        House stark = new House("Stark", "ni znay))");
        House lannister = new House("Lannister", "toze ni znay))");

        addANewHouse(stark);
        addANewHouse(lannister);

        deleteHouse(lannister);

        infoAboutHouse(stark);

        housesInfo();

    }

    public static void addANewHouse(House house){
        houses.put(house.getName(), house);
    }
    public static void deleteHouse(House house){
        houses.remove(house.getName());
    }
    public static void infoAboutHouse(House house){
        System.out.println("House name is " + houses.get(house.getName()).getName() + ". "
                + "House sigil is " + houses.get(house.getName()).getSigil() + ".");
    }
    public static void housesInfo(){
        for(Map.Entry<String, House> entry: houses.entrySet()){
            System.out.println("House name is " + entry.getKey() + ". "
                    + "House sigil is " + entry.getValue().getSigil() + ".");
        }
    }
}