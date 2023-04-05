package ru.faang.school.hashmap.task_1;

public class House {
    private String name;
    private String sigil;

    public House(String sigil) {
        this.sigil = sigil;
    }

    @Override
    public String toString() {
        return sigil;
    }
}
