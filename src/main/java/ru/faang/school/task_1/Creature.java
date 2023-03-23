package ru.faang.school.task_1;

public abstract class Creature {
    private String name;
    private int level;
    private int damage;
    private int defence;
    private int speed;
    private int quantity;

    public Creature(String name, int level, int damage, int defence, int speed, int quantity) {
        this.name = name;
        this.level = level;
        this.damage = damage;
        this.defence = defence;
        this.speed = speed;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }


    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public abstract int getDamage();

}
