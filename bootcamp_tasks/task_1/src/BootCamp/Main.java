package BootCamp;

import java.util.HashMap;
import java.util.Map;

public class Main {

    static void addNewHome(Map<String, House> map, House house){
        map.put(house.getName(), house);
    }

    static void deleteHouseByName(Map<String, House> map, String name){
        map.remove(name);
    }

    static void searchByName(Map<String, House> map, String name){
        System.out.println(map.get(name).getSigil());
    }

    static void showInfo(Map<String, House> map){
        map.entrySet().forEach(n -> System.out.println(n.toString()));
    }

    public static void main(String[] args) {

        Map<String, House> houseMap = new HashMap<>();
        houseMap.put("Старк", new House("Старк", "Волк"));
        houseMap.put("Ланнистер", new House("Ланнистер", "Лев"));
        houseMap.put("Баратеон", new House("Баратеон", "Роза"));

        showInfo(houseMap);
        searchByName(houseMap,"Старк");
        deleteHouseByName(houseMap, "Ланнистер");
        addNewHome(houseMap, new House("Таргариен", "Дракон"));
        showInfo(houseMap);
    }
}
