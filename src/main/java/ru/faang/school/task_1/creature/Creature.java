package ru.faang.school.task_1.creature;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public abstract class Creature {
    private String name;
    private int level;
    private int attack;
    private int defense;
    private int speed;

    private int health;
    private int quantity;

    public abstract int getDamage();

    Creature(String name, int level, int quantity, int attack, int defense, int speed, int health) {
        this.name = name;
        this.level = level;
        this.quantity = quantity;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getSpeed() {
        return speed;
    }

    public int getHealth() {
        return health;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return String.format("%s [lvl %s] [q %s]", name, level, quantity);
    }

    protected int getRandomDamage(int from, int to) {
        List<Integer> range = IntStream.rangeClosed(from, to)
                .boxed().collect(Collectors.toList());
        Random random = new Random();
        int damageIndex = random.nextInt(range.size());
        return range.get(damageIndex);
    }
}
