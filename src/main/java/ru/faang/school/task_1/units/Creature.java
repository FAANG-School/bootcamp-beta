package ru.faang.school.task_1.units;

public abstract class Creature {
    final int hp;
    final int damage;
    final int defence;
    final int level;
    int count = 0;

    public Creature(int hp, int damage, int defence, int level) {
        this.hp = hp;
        this.damage = damage;
        this.defence = defence;
        this.level = level;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getHp() {
        return hp;
    }

    public int getDamage() {
        return damage;
    }

    public int getDefence() {
        return defence;
    }

    public int getLevel() {
        return level;
    }

    public int getCount() {
        return count;
    }
}
