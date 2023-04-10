package ru.faang.school.hashmap.task_1;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Main {
    private static final Map <String, House> HOUSES = new HashMap<>();
    public static void main(String[] args) {
        House stark = new House("Старк","Волк");
        House lannister = new House("Ланнистер","Лев");
        House barateon = new House("Баратеон","Олень");
        House amber = new House("Амбер","Великан");
        add(stark.getName(),stark);
        add(lannister.getName(),lannister);
        remove(stark.getName());
        find(lannister.getName());
        printAll();
    }
    public static void add(String name, House house){
        HOUSES.put(name,house);
    }
    public static String find(String name){
        return HOUSES.get(name).getSigil();
    }
    public static void remove(String name){
        HOUSES.remove(name);
    }
    public static void printAll(){
        for(Map.Entry<String, House> entry: HOUSES.entrySet()){
            System.out.println(entry.getKey() + ":" +
                    entry.getValue());
        }
    }
}

