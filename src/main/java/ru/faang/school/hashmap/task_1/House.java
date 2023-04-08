package ru.faang.school.hashmap.task_1;

import java.util.Objects;

public class House {
    String name;
    String sigal;

    public House(String name, String ligal) {
        this.name = name;
        this.sigal = ligal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSigal() {
        return sigal;
    }

    public void setSigal(String sigal) {
        this.sigal = sigal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return Objects.equals(name, house.name) && Objects.equals(sigal, house.sigal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sigal);
    }

    @Override
    public String toString() {
        return "House{" +
                "name='" + name + '\'' +
                ", ligal='" + sigal + '\'' +
                '}';
    }
}
