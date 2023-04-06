package ru.faang.school.hashmap.task_1;

public class House {
    public House(String name, String sigil) {
        this.name = name;
        this.sigil = sigil;
    }

    @Override
    public String toString() {
        return String.format("Название дома: %s, герб: %s", name, sigil);
    }

    String name;
    String sigil;

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


}
