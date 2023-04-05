package ru.faang.school.hashmap.task_1;

import java.util.HashMap;

public class HouseHashMap extends HashMap<String, House> {

    public void addNewHouse(String name, String sigil) {
        House house = new House(name, sigil);

        this.put(name, house);
    }

    public void deleteHouse(String name) {
        this.remove(name);
    }

    public void showInfo() {

        for (String name : this.keySet()) {
            System.out.println(this.get(name));
        }

    }
}
