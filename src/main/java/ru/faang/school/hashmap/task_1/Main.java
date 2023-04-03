package ru.faang.school.hashmap.task_1;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private final Map<String, Home> HOMES = new HashMap<>();


    public void putHouseToMap(String name, String sigil) {
        HOMES.put(name, new Home(name, sigil));
    }

    public void removeHouseFromMap(String name) {
        HOMES.remove(name);
    }

    public void showHomeInfo(String name) {
        final Home home = HOMES.get(name);
        if (home != null) {
            System.out.println("House: " + name + ". Sigil: " + home.getSigil());
        } else {
            System.out.println("House is not found");
        }
    }

    public void showAllHomeInfo() {
        for (Map.Entry<String, Home> home : HOMES.entrySet()) {
            System.out.println("House: " + home.getKey() + ". Sigil: " + home.getValue().getSigil() + "\n");
        }
    }
}
