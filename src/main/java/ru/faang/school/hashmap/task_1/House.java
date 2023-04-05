package ru.faang.school.hashmap.task_1;

public class House {

    private String name;
    private String sigil;

    public House(String name, String sigil) {
        this.name = name;
        this.sigil = sigil;
    }

    public String getName(){
        return this.name;
    }

    public String getSigil(){
        return this.sigil;

    }

    @Override
    public String toString() {
        return "Welcome to the house of " + this.name + "! Our sigil is \"" + this.sigil + "\"";

    }


}
