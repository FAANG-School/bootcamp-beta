package ru.faang.school.task_1.creatures;

public abstract class Creature {
    private String name;
    private int level;
    private int attackPower;
    private int armor;
    private int speed;
    private int quantity;

    public int getDamage(){
        return level*attackPower;
    }
}
