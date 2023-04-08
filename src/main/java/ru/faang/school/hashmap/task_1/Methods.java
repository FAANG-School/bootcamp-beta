package ru.faang.school.hashmap.task_1;

import java.util.HashMap;
import java.util.Map;

public class Methods {
    public boolean createNewHouse(Map<String, House> map, String name, House house) {
        if (!map.containsKey(name)) {
            map.put(name, house);
            return true;
        }
        return false;
    }

    public boolean deleteHouse(Map<String, House> map, String name) {
        if (!map.containsKey(name)) {
            return false;
        }
        map.remove(name);
        return true;
    }

    public String getSigilByName(Map<String, House> map, String name) {
        String sigil = "";
        for (Map.Entry<String, House> entry : map.entrySet()) {
            if (map.containsKey(name)) {
                sigil = entry.getValue().getSigil();
            }
        }
        return sigil;
    }

    public void getAllHouses(Map<String, House> map) {
        for (Map.Entry<String, House> entry : map.entrySet()) {
            System.out.println(entry.getValue().getName() + " " + entry.getValue().getSigil());
        }
    }
}
