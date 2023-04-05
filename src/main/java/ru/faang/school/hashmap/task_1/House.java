package ru.faang.school.hashmap.task_1;

import java.util.Objects;

public class House {
    private final String name;
    private String sigil;

    public House(String name, String sigil) {
        this.name = name;
        this.sigil = sigil;
    }

    public String getName() {
        return name;
    }

    public String getSigil() {
        return sigil;
    }

    public void setSigil(String sigil) {
        this.sigil = sigil;
    }

    public String toString() {
        return "Герб дома: " + name + " это -  " + sigil;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return name.equals(house.name) && sigil.equals(house.sigil);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sigil);
    }
}
