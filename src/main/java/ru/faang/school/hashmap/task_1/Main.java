package ru.faang.school.hashmap.task_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public Map<String, House> map = new HashMap<>() {{
        put("Stark", new House("Stark", "Wolf"));
        put("Lannister", new House("Lannister", "Lion"));
        put("Barateon", new House("Barateon", "Deer"));
    }};

    public static void main(String[] args) {

    }

    public void addHouse(String name, String sigil) {
        map.put(name, new House(name, sigil));
    }

    public void removeHouseByName(String name) {
        if (map.containsKey(name))
            map.remove(name);
        else
            throw new IllegalArgumentException();
    }

    public String getSigilByHouseName(String name) {
        if (map.containsKey(name))
            return map.get(name).getSigil();
        else throw new IllegalArgumentException();
    }

    public List<String> getHouses(){
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, House> m : map.entrySet()) {
            list.add(m.getKey() + m.getValue());
        }
        return list;
    }

}
