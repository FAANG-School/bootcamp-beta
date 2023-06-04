package ru.faang.school.task_1;

import java.util.Objects;
import java.util.Random;

public abstract class Creature {
    private String name;
    private int level;
    private int attack;
    private int defense;
    private double speed;
    private int countCreature;

    //@Override
    //public String toString() {
    //    return name;
    //}

    public Creature(String name, int level, int attack, int defense, double speed, int quantity) {
        this.name = name;
        this.level = level;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        countCreature += quantity;
    }
    public int getCountCreature() {
        return countCreature;
    }

    public double getDamage() {
        return level + (1.0 * attack) * (0.2 * defense) * (0.2 * speed) * (Math.random() * 3 + 1);
    }
    public double getDefense() {
        return level + (0.3 * attack) * (1.0 * defense) * (0.2 * speed) * (Math.random() * 10 + 1);
    }
    public String getName() {
        return name;
    }
}
