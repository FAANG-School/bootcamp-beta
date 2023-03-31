package ru.faang.school.task_1;

public abstract class Creature {
    public Creature(String name) {
        this.name = name;
    }

    String name;
    int level;
    int damage;
    int armor;
    int speed;
    int quantity;

    int getDamage(){
        return damage;
    }
}
