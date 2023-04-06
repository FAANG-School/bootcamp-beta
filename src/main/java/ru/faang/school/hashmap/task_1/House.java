package ru.faang.school.hashmap.task_1;

class House {
    private String name;
    private String sigil;

    protected House(String name, String sigil) {
        this.name = name;
        this.sigil = sigil;
    }

    protected House(){}

    protected String getSigil(){
        return this.sigil;
    }

    protected String getName(){
        return this.name;
    }
}
