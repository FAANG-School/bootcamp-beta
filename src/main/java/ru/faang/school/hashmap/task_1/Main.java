package ru.faang.school.hashmap.task_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private Map<String, House> houses = new HashMap<>() {{
        put("Stark", new House("Stark", "Wolf"));
        put("Lannister", new House("Lannister", "Lion"));
        put("Barateon", new House("Barateon", "Deer"));
        put("Targaryen", new House("Targaryen", "Dragon"));
    }};

    public Map<String, House> getHouses() {
        return houses;
    }

    public void addNewHouse(String houseName, String sigil) {
        houses.put(houseName, new House(houseName, sigil));
    }

    public void deleteHouse(String houseName) {
        if (houses.containsKey(houseName)) {
            houses.remove(houseName);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public String getSigil(String houseName) {
        if (houses.containsKey(houseName)) {
            return houses.get(houseName).getSigil();
        } else {
            throw new IllegalArgumentException();
        }
    }

    public List<String> getAllHousesInfo() {
        List<String> res = new ArrayList<>();
        for (Map.Entry<String, House> entry : houses.entrySet()) {
            res.add(entry.getKey() + entry.getValue());
        }
        return res;
    }
}
