package ru.faang.school.task_1;

import java.util.Objects;

public abstract class Creature {
    private String name;
    private int attack;
    private int defense;
    private int speed;
    private int fullHealth;
    private int health;
    private int quantity;

    protected int getDamage(Creature enemyCreature, Hero myHero) {
        int damage = Math.max((enemyCreature.getAttack() * enemyCreature.getQuantity()) - (getDefense() * getQuantity()), 1);
        int loosenQuantity = damage / getFullHealth();
        int loosenHealth = damage % getFullHealth();
        if (loosenQuantity>0) {
            if (getQuantity() < loosenQuantity) {
                myHero.removeCreature(this, loosenQuantity);
                return damage;
            } else {
                myHero.removeCreature(this, loosenQuantity);
                setHealth(getHealth() - loosenHealth);
            }
        } else {
            setHealth(getHealth() - loosenHealth);
        }
        if (getHealth() <= 0) {
            setHealth(getFullHealth() + getHealth());
            myHero.removeCreature(this, 1);
        }
        return damage;
    }

    public Creature(String name, int attack, int defense, int speed, int health, int fullHealth) {
        setName(name);
        setAttack(attack);
        setDefense(defense);
        setSpeed(speed);
        setHealth(health);
        setQuantity(1);
        setFullHealth(fullHealth);
    }

    public int getFullHealth() {
        return fullHealth;
    }

    protected void setFullHealth(int fullHealth) {
        this.fullHealth = fullHealth;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = Math.max(quantity, 0);
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
                + "\nhealth: " + health + "/" + fullHealth
                + "\nquantity: " + quantity;

    }
}
