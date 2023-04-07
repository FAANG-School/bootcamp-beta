package ru.faang.school.hashmap.task_1.java;
public class House {
    private String name;
    private String sigil;

    public House() {}

    public House(String name, String sigil) {
        this.name = name;
        this.sigil = sigil;
    }

    public String getName() {
        return this.name;
    }

    public String getSigil() {
        return this.sigil;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSigil(String sigil) {
        this.sigil = sigil;
    }
}
