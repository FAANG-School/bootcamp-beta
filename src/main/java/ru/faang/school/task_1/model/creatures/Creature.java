package ru.faang.school.task_1.model.creatures;

public abstract class Creature {
    String name;
    int level;
    int attack;
    int defence;
    int velocity;
    int amount;

    public int getDamage() {
        return attack;
    }

    public int getArmor() {
        return defence;
    }
}
