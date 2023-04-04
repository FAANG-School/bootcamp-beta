package ru.faang.school.task_1.Creatures;

public abstract class Creature {
    private final String name;
    private int level;
    private int attack;
    private int defence;
    private int speed;
    private int count;

    public Creature(String name, int level, int attack, int defence, int speed, int count) {
        this.name = name;
        this.level = level;
        this.attack = attack;
        this.defence = defence;
        this.speed = speed;
        this.count = count;
    }

    public int getDamage(){
        return attack;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getProtection() {
        return defence;
    }

    public int getSpeed() {
        return speed;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
