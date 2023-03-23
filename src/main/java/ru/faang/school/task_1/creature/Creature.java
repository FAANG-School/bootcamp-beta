package ru.faang.school.task_1.creature;

import java.util.Comparator;
import java.util.Random;

public abstract class Creature {
    protected String name;
    protected int lvl;
    protected int attack;
    protected int defence;
    protected int speed;
    protected int minDamage;
    protected int maxDamage;
    protected int health;
    protected int quantity;

    public Creature(String name,
                    int lvl,
                    int attack,
                    int defence,
                    int speed,
                    int minDamage,
                    int maxDamage,
                    int health,
                    int quantity) {

        this.name = name;
        this.lvl = lvl;
        this.attack = attack;
        this.defence = defence;
        this.speed = speed;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.health = health;
        this.quantity = quantity;

    }
    public int getDamage() {
        int damage = 0;
        Random random = new Random();

        for (int i = 0; i < quantity; i++) {
            damage += random.nextInt(minDamage, maxDamage + 1);
        }

        return damage;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity < 0) {
            quantity = 0;
        }
        this.quantity = quantity;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefence() {
        return defence;
    }

    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }

    public int getLvl() {
        return lvl;
    }

    public int getSpeed() {
        return speed;
    }

    public int getMinDamage() {
        return minDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Creature creature = (Creature) o;

        if (lvl != creature.lvl) return false;
        if (attack != creature.attack) return false;
        if (defence != creature.defence) return false;
        if (speed != creature.speed) return false;
        return name.equals(creature.name);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + lvl;
        result = 31 * result + attack;
        result = 31 * result + defence;
        result = 31 * result + speed;
        return result;
    }

    @Override
    public String toString() {
        return "Creature{" +
                "name='" + name + '\'' +
                ", lvl=" + lvl +
                ", attack=" + attack +
                ", defence=" + defence +
                ", speed=" + speed +
                ", minDamage=" + minDamage +
                ", maxDamage=" + maxDamage +
                ", health=" + health +
                ", quantity=" + quantity +
                '}';
    }

    public static class SortBySpeedDesc implements Comparator<Creature> {
        @Override
        public int compare(Creature o1, Creature o2) {
            return o2.speed - o1.speed;
        }
    }

}
