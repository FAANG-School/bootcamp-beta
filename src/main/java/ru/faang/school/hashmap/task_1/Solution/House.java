package ru.faang.school.hashmap.task_1.Solution;

import java.util.Objects;

public record House(String name, String sigil) {

    public String getName(){
        return name;
    }

    public String getSigil(){
        return sigil;
    }

    @Override
    public String toString(){
        return getName() + " : " + getSigil();
    }


    /**
     * Equals and hashCode used only for unit tests
     * @param o object to compare with
     * @return true if objects are equals
     */
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
}
