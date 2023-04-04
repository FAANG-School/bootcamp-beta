package ru.faang.school.task_1.heroes;

public enum Fraction {

    CASTLE("Замок"),
    RAMPART("Оплот"),
    TOWER("Башня"),
    INFERNO("Инферно"),
    NECROPOLIS("Некрополис"),
    DUNGEON("Подземелье"),
    CITADEL("Цитадель"),
    FORTRESS("Крепость"),
    CONFLUX("Сопряжение");


    private final String name;

    Fraction(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
