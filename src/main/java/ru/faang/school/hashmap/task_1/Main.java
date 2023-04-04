package ru.faang.school.hashmap.task_1;

import java.util.HashMap;
import java.util.Map;

public class Main {
    static Map<String, House> map = new HashMap<>();

    public static void addHouse(String name, House house){
        map.put(name, house);
    }

    public static void removeHouse(String name){
        map.remove(name);
    }

    public static void findHouse(String name){
        System.out.println(map.get(name));
    }

    public static void ListOAllHouses(){
        for (Map.Entry<String, House> entry: map.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        addHouse("Ланнистеры", new House("Герб Ланнистеров"));
        addHouse("Старки", new House("Герб Старков"));
        addHouse("Баратеоны", new House("Герб Баратеонов"));
        findHouse("Баратеоны");
        ListOAllHouses();
        removeHouse("Баратеоны");
        ListOAllHouses();
    }
}
