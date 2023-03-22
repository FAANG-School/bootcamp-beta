package ru.faang.school.task_1;

import java.util.Objects;

public abstract class Creature {
    private String name;
    private int attack;
    private int defense;
    private int speed;
    private int health;
    private int quantity;


    protected int getDamage(int damage) {
        System.out.println(getClass().getSimpleName() + " get " + damage + " damage");
        return damage;//?????
    }

    public Creature(String name, int attack, int defense, int speed, int health) {
        setName(name);
        setAttack(attack);
        setDefense(defense);
        setSpeed(speed);
        setHealth(health);
        setQuantity(1);
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (getQuantity() < 0) {
            this.quantity = 0;
        } else {
            this.quantity = quantity;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        if (getQuantity() < 0) throw new RuntimeException("Speed must be positive!");
        this.speed = speed;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Creature creature)) return false;
        return Objects.equals(getName(), creature.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAttack(), getDefense(), getSpeed(), getHealth());
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": attack: " + attack
                + "\ndefense: " + defense
                + "\nspeed: " + speed
                + "\nhealth: " + health
                + "\nquantity: " + quantity;

    }
}
