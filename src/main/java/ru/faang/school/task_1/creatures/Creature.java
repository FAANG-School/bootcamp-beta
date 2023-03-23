package ru.faang.school.task_1.creatures;

public abstract class Creature implements Comparable<Creature>{
    private final String name;
    private final int level;
    private final int damage;
    private final int armor;
    private int quantity;
    private final int speed;

    public Creature(String name, int level, int damage,
                    int armor, int speed, int quantity) {
        this.name = name;
        this.level = level;
        this.damage = damage;
        this.armor = armor;
        this.speed = speed;
        this.quantity = quantity;
    }

    public void takeDamage(int damage) {
        quantity -= (damage / armor);
    }

    public int getSquadDamage() {
        return damage * quantity;
    }

    public boolean isAlive() {
        return quantity > 0;
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

    @Override
    public String toString() {
        return "Creature{" +
                "name='" + name + '\'' +
                ", damage=" + damage +
                ", armor=" + armor +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public int compareTo(Creature o) {
        return o.getSquadDamage() - getSquadDamage();
    }
}
