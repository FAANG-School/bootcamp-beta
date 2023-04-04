package ru.faang.school.hashmap.task_1;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, House> map = new HashMap<>();
        addNewHouse(map, new House("Старк", "zxc"));
        addNewHouse(map, new House("Ланнистер", "true"));
        addNewHouse(map, new House("Баратеон", "ghoul"));

//        Methods.addNewHouse(map, house);
//        Methods.removeHouse(map, house);

        for(Map.Entry<String, House> entry : map.entrySet()) {
            System.out.println("Name: "+entry.getKey()+" sigil: "+entry.getValue().getSigil());
        }
    }
    static void addNewHouse(Map<String, House> map, House house) {
        map.put(house.getName(), house);
    }

    static void removeHouse(Map<String, House> map, String nameOfHome) {
        map.remove(nameOfHome);
    }

}

class House {
    private String name;
    private String sigil;

    public House(String name, String sigil) {
        this.name = name;
        this.sigil = sigil;
    }

    public String getName() {
        return name;
    }

    public String getSigil() {
        return sigil;
    }
}