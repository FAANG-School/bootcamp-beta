package ru.faang.school.hashmap.task_1;

import java.util.Objects;

public class House {
    private String name;
    private String sigil;

    public House(String name, String sigil) {
        this.name = name;
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

    @Override
    public String toString() {
        return "House{" +
                "name='" + name + '\'' +
                ", sigil='" + sigil + '\'' +
                '}';
    }
}
