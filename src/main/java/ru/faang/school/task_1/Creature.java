package ru.faang.school.task_1;

import lombok.Data;

@Data
public abstract class Creature {

    private String name;
    private int level;
    private int attack;
    private int protection;
    private int speed;
    private int quantity;
    private int health;

    public Creature(String name, int level, int attack, int protection, int speed, int health) {
        this.name = name;
        this.level = level;
        this.attack = attack;
        this.protection = protection;
        this.speed = speed;
        this.health = health;
    }

    public int getDamage() {
        return (int) ((Math.random() * getAttack() + 1) * getQuantity());
    }

    public int currentHealth() {
        int currentHealth = (health * getQuantity());
        return currentHealth;
    }

}
