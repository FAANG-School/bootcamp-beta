package ru.faang.school.task_1;

public abstract class Creature {
    protected String name;
    protected int level;
    protected int attack;
    protected int defense;
    protected double speed;
    protected int countCreature;
    public int getDamage() {
        return attack;
    }
}
