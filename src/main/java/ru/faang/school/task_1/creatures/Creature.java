package ru.faang.school.task_1.creatures;

public abstract class Creature {
    private final String name;
    private final int level;
    private final int damage;
    private final int armor;
    private final int quantity;
    private final int speed;

    public Creature(String name, int level, int damage,
                    int armor, int speed, int count) {
        this.name = name;
        this.level = level;
        this.damage = damage;
        this.armor = armor;
        this.speed = speed;
        this.quantity = count;
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

    public int getQuantity() {
        return quantity;
    }
}
