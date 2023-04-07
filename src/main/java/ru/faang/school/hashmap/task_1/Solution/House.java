package ru.faang.school.hashmap.task_1.Solution;

public class House {
    private final String name;
    private final String sigil;

    public House(String name, String sigil) {
        this.name = name;
        this.sigil = sigil;
    }

    public String toString(){
        return name + " : " + sigil;
    }


}
