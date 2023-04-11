package ru.faang.school.hashmap.task_1;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private Map<String, House> houses = new HashMap<>();

    public void addHouse(final String name, final String sigil) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name cannot be null or empty");
        }
        if (sigil == null || sigil.isBlank()) {
            throw new IllegalArgumentException("sigil cannot be null or empty");
        }
        houses.putIfAbsent(name, new House(name, sigil));
    }

    public boolean isHouseExist(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name cannot be null or empty");
        }
        return houses.containsKey(name);
    }

    public void removeHouseByName(final String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name cannot be null or empty");
        }
        houses.remove(name);
    }

    public String getSigilByHouseName(final String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name cannot be null or empty");
        }
        if (houses.containsKey(name)) {
            return houses.get(name).sigil();
        } else {
            return "unknown";
        }
    }

    public Collection<House> getListOfHouse() {
        return houses.values();
    }

    private void printListOfHouse() {
        houses.values().forEach(System.out::println);
    }

    public Map<String, House> getHouses() {
        return Map.copyOf(houses);
    }

    public void setHouses(Map<String, House> houses) {
        if (houses == null) {
            throw new IllegalArgumentException("houses cannot be null");
        }
        this.houses = Map.copyOf(houses);
    }
}
