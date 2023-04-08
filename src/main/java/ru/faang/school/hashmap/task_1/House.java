package ru.faang.school.hashmap.task_1;

import java.util.Map;

public class House {
    String name;
    String sigil;
    public House (String name, String sigil){
        this.name=name;
        this.sigil=sigil;
    }
    public String getSigil() {
        return sigil;
    }

    @Override
    public String toString() {
        return name + " || " + sigil;
    }
}
