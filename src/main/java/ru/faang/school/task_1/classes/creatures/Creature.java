package ru.faang.school.task_1.classes.creatures;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Creature {
    private String name;
    private int level;
    private int damage;
    private int armor;
    private int speed;
    private int health;
    private int quantity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Creature creature = (Creature) o;

        return name.equals(creature.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public void setQuantity(int quantity) {
        if (this.quantity == 0) {
            this.quantity = quantity;
        } else {
            this.quantity = this.quantity + quantity;
        }
    }

    public Creature(String name, int level, int damage, int armor, int speed, int health) {
        if (level < 1 || damage < 0 || armor < 0 || speed < 0) {
            try {
                throw new IllegalArgumentException();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
        this.name = name;
        this.level = level;
        this.damage = damage;
        this.armor = armor;
        this.speed = speed;
        this.health = health;
        this.quantity = 0;
    }

    @Override
    public String toString() {
        return "Creature{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", damage=" + damage +
                ", armor=" + armor +
                ", speed=" + speed +
                ", health=" + health +
                ", quantity=" + quantity +
                '}';
    }
}
