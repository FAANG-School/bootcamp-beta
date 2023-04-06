package ru.faang.school.hashmap.task_1;

import java.util.Objects;

public class House {

    private final String name;
    private final String sigil;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        House house = (House) o;

        if (!Objects.equals(name, house.name)) return false;
        return Objects.equals(sigil, house.sigil);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (sigil != null ? sigil.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "House{" +
                "name='" + name + '\'' +
                ", sigil='" + sigil + '\'' +
                '}';
    }
}
