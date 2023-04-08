package ru.faang.school.hashmap.task_1;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, House> sigals = new HashMap<>();

        sigals.put("Stark", new House("Stark", "Stark sigal"));
        sigals.put("Barteon", new House("Barteon", "Barteon sigal"));
        sigals.put("Lanister", new House("Lanister", "Lanister sigal"));


        create(sigals, "lords", new House("lords", "lords sigal"));
        del(sigals, "Stark");
        findSigal(sigals, "Lanister");
        allSigals(sigals);


    }

    public static void create(Map<String, House> map, String name, House house) {
        map.put(name, house);
    }

    public static void del(Map<String, House> map, String name) {
        map.remove(name);
    }

    public static void findSigal(Map<String, House> map, String name) {
        if (map.get(name) != null) {
            System.out.println(map.get(name).getSigal());
        } else {
            System.out.println("null");
        }
    }

    public static void allSigals(Map<String, House> map) {
        for (Map.Entry<String, House> entry : map.entrySet()) {
            System.out.println(entry.getKey() + entry.getValue());
        }
    }
}
