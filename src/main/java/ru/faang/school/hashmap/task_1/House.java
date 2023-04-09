package ru.faang.school.hashmap.task_1;

import java.util.HashMap;
import java.util.Map;

public class House {
    private final String name;
    private final String sigil;

    public House(String name, String sigil) {
        this.name = name;
        this.sigil = sigil;
    }

    public String getSigil() {
        return sigil;
    }

    public String getName() {
        return name;
    }
}
