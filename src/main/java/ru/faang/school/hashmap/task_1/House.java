package ru.faang.school.hashmap.task_1;

import java.util.Objects;

public class House {
    private final String name;
    private final String sigil;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof House)) return false;
        House house = (House) o;
        return Objects.equals(name, house.name) && Objects.equals(sigil, house.sigil);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sigil);
    }

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
}
