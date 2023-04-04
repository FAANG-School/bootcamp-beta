package ru.faang.school.hashmap.task_1;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, House> map = new HashMap<>();
        map.put("Старк", new House("a1", "b1"));
        map.put("Ланнистер", new House("a2", "b2"));
        map.put("Баратеон", new House("a3", "b3"));

        Methods.addNewHouse(map, "something", "a", "b");
        Methods.removeHouse(map, "something");

        for(Map.Entry<String, House> entry : map.entrySet()) {
            System.out.println(entry.getValue().getAll());
        }
        System.out.println(map);
    }

}

class House {
    private String name;
    private String sigil;

    public House() {

    }

    public House(String name, String sigil) {
        this.name = name;
        this.sigil = sigil;
    }

    public String getAll() {
        return name+" "+sigil;
    }

    public String getName() {
        return name;
    }

    public String getSigil() {
        return sigil;
    }
}

class Methods {
    static void addNewHouse(Map<String, House> map, String nameOfHome, String name, String sigil) {
        map.put(nameOfHome, new House(name, sigil));
    }

    static void removeHouse(Map<String, House> map, String nameOfHome) {
        map.remove(nameOfHome);
    }
}