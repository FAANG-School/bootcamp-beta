package ru.faang.school.task_1;

public abstract class Creature {

    private String name;
    private int level;
    private int attack;
    private int protection;
    private int speed;
    private int quantity = 0;

    public Creature(String name, int level, int attack, int protection, int speed) {
        this.name = name;
        this.level = level;
        this.attack = attack;
        this.protection = protection;
        this.speed = speed;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    abstract int getDamage();

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getAttack() {
        return attack;
    }

    public int getProtection() {
        return protection;
    }

    public int getSpeed() {
        return speed;
    }

    public int getQuantity() {
        return quantity;
    }
}

