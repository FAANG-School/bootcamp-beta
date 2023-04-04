package ru.faang.school;

public abstract class Creature {
    private String name = "Misha";
    private String level = "Beginner";
    private int attack = 10;
    private int protection = 8;
    private int speed = 15;
    private int count = 12;

    public int getDamage() {
        return attack;
    }
}
