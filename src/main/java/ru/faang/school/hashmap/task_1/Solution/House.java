package ru.faang.school.hashmap.task_1.Solution;

public class House {
    private final String name;
    private final String sigil;

    public House(String name, String sigil) {
        if (name == null || sigil == null){
            throw new RuntimeException("Invalid value!");
        }
        this.name = name;
        this.sigil = sigil;
    }

    public String toString(){
        return String.format("%s : %s", name, sigil);
    }


}
