package ru.faang.school.hashmap.task_1.solution;

import java.nio.file.Path;
import java.util.Objects;

public class House {
    private final String name;
    private final Path sigil;

    public House(String name, Path sigil) {
        this.name = name;
        this.sigil = sigil;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        House house = (House) o;

        return Objects.equals(name, house.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    public String getName() {
        return name;
    }

    public Path getSigil() {
        return sigil;
    }

    @Override
    public String toString() {
        return "House: " + name + "\n" +
                "Sigil: " + sigil + "\n";
    }
}
