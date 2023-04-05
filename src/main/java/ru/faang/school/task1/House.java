package ru.faang.school.task1;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class House {
    private String name;
    private String sigil;

    public House(String name, String sigil) {
        this.name = name;
        this.sigil = sigil;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSigil() {
        return sigil;
    }

    public void setSigil(String sigil) {
        this.sigil = sigil;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return Objects.equals(name, house.name) && Objects.equals(sigil, house.sigil);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sigil);
    }


    public static void main(String[] args) {
        Map<String, House> data = new HashMap<>();
        House stark = new House("Stark", "Stark");
        House lanister = new House("Lanister", "Lanister");
        House barateon = new House("Barateon", "Barateon");
    }

    static void addHouse(Map<String, House> data, House house) {
        data.put(house.getName(), house);
    }

    static void deleteHouse(Map<String, House> data, String name) {
        data.remove(name);
    }

    static String findHouse(Map<String, House> data, String name) {
        return data.get(name).getSigil();
    }

    static void printAllHouse(Map<String, House> data) {
        for (Map.Entry<String, House> d : data.entrySet()) {
            System.out.println(d.getKey() + " : " + d.getValue().getSigil());
        }
    }
}
