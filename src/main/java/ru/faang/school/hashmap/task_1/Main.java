package ru.faang.school.hashmap.task_1;

import java.util.HashMap;
import java.util.Map;

public class Main {
    Map<String, House> map;
    public static void main(String[] args) {
        Main main = new Main();
        main.map = new HashMap<>();
        main.map.put("Stark", new House());
        main.map.put("Lannister", new House());
        main.map.put("Barateon", new House());
    }

    void addNewHouse(String name, House house){
        map.put(name, house);
    }

    void removeHouse(String name){
        map.remove(name);
    }

    String getEmblem(String name){
        return map.get(name).getSigil();
    }

    void getHouses(){
        for (Map.Entry<String, House> entry : map.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
