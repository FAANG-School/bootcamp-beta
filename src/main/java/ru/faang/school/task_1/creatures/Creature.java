package ru.faang.school.task_1.creatures;

public abstract class Creature {
    private final String name;
    private final int level;
    private final int damage;
    private final int armor;
    private int count;
    private final int speed;

    public Creature(String name, int level, int damage,
                    int armor, int speed, int count) {
        this.name = name;
        this.level = level;
        this.damage = damage;
        this.armor = armor;
        this.speed = speed;
        this.count = count;
    }

    public int takeDamage(int damage) {
        return this.count = count - (damage / armor);
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getDamage() {
        return damage;
    }

    public int getArmor() {
        return armor;
    }

    public int getSpeed() {
        return speed;
    }

    public int getCount() {
        return count;
    }
}
