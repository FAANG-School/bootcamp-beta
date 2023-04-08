package ru.faang.school.hashmap.task_1;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private final Map<String, House> houseMap = new HashMap<>();

    public Map<String, House> getHouseMap() {
        return houseMap;
    }

    public void addHouse(final String name, final String sigil) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name cannot be null or empty");
        }
        if (sigil == null || sigil.isBlank()) {
            throw new IllegalArgumentException("sigil cannot be null or empty");
        }
        houseMap.putIfAbsent(name, new House(name, sigil));
    }

    public void removeHouseByName(final String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name cannot be null or empty");
        }
        houseMap.remove(name);
    }

    public String getSigilByHouseName(final String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name cannot be null or empty");
        }
        return houseMap.getOrDefault(name, new House("unknown", "unknown")).sigil();
    }

    public Collection<House> getListOfHouse() {
        return houseMap.values();
    }

    private void printListOfHouse() {
        getListOfHouse().forEach(System.out::println);
    }
}
