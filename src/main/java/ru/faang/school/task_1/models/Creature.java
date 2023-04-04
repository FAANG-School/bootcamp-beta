package ru.faang.school.task_1.models;

public abstract class Creature {
    private String name;
    private int level;
    private double damage;
    private double armor;
    private int speed;
    private int quantity;
    private double health;
    private final double MIN_HEALTH = 0;

    public Creature(String name, int level, double damage, double armor, int speed, int quantity) {
        this.name = name;
        this.level = level;
        this.damage = damage;
        this.armor = armor;
        this.speed = speed;
        this.quantity = quantity;
        health = 100;
    }

    public void creatureLevelUp(){
        level += 1;
    }

    public double attack(Creature creature){
        double damageScore = damage * (1 - creature.damage);
        return health -= damage;
    }

    public double getDamage() {
        return damage;
    }

    @Override
    public String toString() {
        return name + health;
    }
}
