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
        if (!(o instanceof House house)) return false;
        return Objects.equals(getName(), house.getName()) && Objects.equals(getSigil(), house.getSigil());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSigil());
    }

    public String getName() {
        return name;
    }

    public String getSigil() {
        return sigil;
    }
}
