package ru.faang.school.hashmap.task_1;

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

        if (!name.equals(house.name)) return false;
        return sigil.equals(house.sigil);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + sigil.hashCode();
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
