package ru.faang.school.task_1.entities;

public abstract class Creature {
    private final String name;
    private int level;
    private int health;
    private int damage;
    private int armor;
    private int speed;
    private int quantity;
    private int absHealth;

    public Creature(String name, int level, int health, int damage, int armor, int speed, int quantity) {
        this.name = name;
        this.level = level;
        this.health = health;
        this.damage = damage;
        this.armor = armor;
        this.speed = speed;
        this.quantity = quantity;
    }
    public int getDamage() {
        return damage * quantity;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getArmor() {
        return armor * quantity;
    }

    public void setArmor(int armor) {
        this.armor = armor;
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

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAbsHealth() {
        return absHealth;
    }

    public void setAbsHealth(int absHealth) {
        this.absHealth = absHealth;
    }
}
