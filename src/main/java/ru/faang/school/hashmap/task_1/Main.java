package ru.faang.school.hashmap.task_1;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Main {
    final Map<String, House> houses;

    public Main() {
        this.houses = new HashMap<>();
    }

    public void addHouse(String name, String sigil) {
        houses.put(name, new House(name, sigil));
    }

    public void deleteHouseByName(String name) {
        houses.remove(name);
    }

    public void getSigilInfoByName(String name) {
        System.out.println(houses.get(name).getSigil());
    }

    public void printAllHouses() {
        for(var house : houses.values()) {
            System.out.println(house.toString());
        }
    }
}

class House{
    final private String name;
    final private String sigil;

    House(String name, String sigil) {
        this.name = name;
        this.sigil = sigil;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return name.equals(house.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return String.format("name - \"%s\", sigil - \"%s\"", name, sigil);
    }

    public String getName() {
        return name;
    }

    public String getSigil() {
        return sigil;
    }

}
