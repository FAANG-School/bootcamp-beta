package ru.faang.school.task_1;

import java.util.Objects;

public abstract class Creature {
    private String name;
    private int level;
    private int attack;
    private int defense;
    private double speed;
    private int countCreature;

    @Override
    public String toString() {
        return name;
    }

    public Creature(String name, int level, int attack, int defense, double speed) {
        this.name = name;
        this.level = level;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        countCreature++;
    }

    public int getDamage() {
        return attack;
    }
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Creature creature = (Creature) o;

        if (level != creature.level) return false;
        if (attack != creature.attack) return false;
        if (defense != creature.defense) return false;
        if (Double.compare(creature.speed, speed) != 0) return false;
        if (countCreature != creature.countCreature) return false;
        return Objects.equals(name, creature.name);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name != null ? name.hashCode() : 0;
        result = 31 * result + level;
        result = 31 * result + attack;
        result = 31 * result + defense;
        temp = Double.doubleToLongBits(speed);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + countCreature;
        return result;
    }
}
