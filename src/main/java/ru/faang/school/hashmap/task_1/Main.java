package ru.faang.school.hashmap.task_1;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private final Map<String, House> houses = new HashMap<>();

    public Map<String, House> getHouses() {
        return houses;
    }

    public void addHouse(final String name, final String sigil) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name cannot be null or empty");
        }
        if (sigil == null || sigil.isBlank()) {
            throw new IllegalArgumentException("sigil cannot be null or empty");
        }
        houses.putIfAbsent(name, new House(name, sigil));
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
        return houses.getOrDefault(name, new House("unknown", "unknown")).sigil();
    }

    public Collection<House> getListOfHouse() {
        return houses.values();
    }

    private void printListOfHouse() {
        getListOfHouse().forEach(System.out::println);
    }
}
