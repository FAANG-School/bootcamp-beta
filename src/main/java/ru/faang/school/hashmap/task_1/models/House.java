package ru.faang.school.hashmap.task_1.models;

public class House {
    private final String _name;
    private final String _sigil;

    public House(String name, String sigil) {
        _name = name;
        _sigil = sigil;
    }

    public String getName() {
        return _name;
    }
    public String getSigil() {
        return _sigil;
    }
}
