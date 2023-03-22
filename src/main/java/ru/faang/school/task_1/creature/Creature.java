package ru.faang.school.task_1.creature;

import ru.faang.school.task_1.utils.RandomUtils;

public abstract class Creature {
    private final String name;
    private final int level;
    private final int attack;
    private final int defense;
    private final int speed;
    private final int health;
    private int quantity;

    public abstract int getDamage();

    Creature(String name, int level, int quantity, int attack, int defense, int speed, int health) {
        this.name = name;
        this.level = Math.max(1, level);
        this.quantity = Math.max(1, quantity);
        this.attack = Math.max(1, attack);
        this.defense = Math.max(1, defense);
        this.speed = Math.max(1, speed);
        this.health = Math.max(1, health);
    }

    public int getHealth() {
        return health;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return String.format("%s [%s units]", name, quantity);
    }

    protected int getRandomDamage(int from, int to) {
        return RandomUtils.getRandomNumberFromRange(from, to);
    }

    public int getDamagePoints() {
        return level * RandomUtils.getRandomNumberFromRange(1, 30) + (speed + attack + this.getDamage() + health) / 3;
    }

    public int getDefensePoints() {
        return (defense + health) / 3;
    }
}
