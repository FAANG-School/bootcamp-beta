package ru.faang.school.hashmap.task_1;

import java.util.HashMap;

import javax.print.attribute.HashPrintJobAttributeSet;
import java.security.Key;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        HashMap<String, House> housesAndSigil = new HashMap<>();


        Main.addHouse(housesAndSigil, "Stark", new House("Stark", "Wolf"));
        Main.addHouse(housesAndSigil, "Lanister", new House("Lanister", "Lion"));
        Main.addHouse(housesAndSigil, "Barateon", new House("Barateon", "Deer"));

        Main.showHouses(housesAndSigil);

        Main.removeHouse(housesAndSigil,"Stark");
        System.out.println(" ");

        Main.showHouses(housesAndSigil);
        System.out.println(" ");

        Main.searchHouse(housesAndSigil, "Barateon");


    }
    public static <K,V> void addHouse(HashMap<K,V> map, K key, V value){
        map.put(key, value);
    }
    public static void removeHouse(HashMap<String, House> map, String name) {
        Iterator<Map.Entry<String, House>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, House> entry = iterator.next();
            if (entry.getValue().getName().equals(name)) {
                iterator.remove();
            }
        }
    }

    public static void searchHouse(HashMap<String, House> map, String key ) {
        System.out.println(map.get(key));
    }
    public static void showHouses(HashMap<String, House> map) {
        for (Map.Entry<String, House> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
