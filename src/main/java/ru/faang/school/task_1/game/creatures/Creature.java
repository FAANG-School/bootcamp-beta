package ru.faang.school.task_1.game.creatures;

import ru.faang.school.task_1.game.exceptions.ValidationException;
import ru.faang.school.task_1.game.heroes.Hero;

public abstract class Creature {

    private static final double DAMAGE_MULTIPLIER = 0.05;

    protected String name;

    protected int level;

    protected int attack;

    protected double damage;

    protected int defense;

    protected int speed;

    protected double health;

    protected int quantity;

    public Creature(String name, int level, int attack, double damage, int defense, int speed, double health) {
        if (attack < 0) {
            throw new ValidationException("Attack must be greater than zero.");
        }
        if (damage < 0) {
            throw new ValidationException("Damage must be greater than zero.");
        }
        if (defense < 0) {
            throw new ValidationException("Defense must be greater than zero.");
        }
        if (speed < 0) {
            throw new ValidationException("Speed must be greater than zero.");
        }
        if (health < 0) {
            throw new ValidationException("Health must be greater than zero.");
        }
        this.name = name;
        this.level = level;
        this.attack = attack;
        this.damage = damage;
        this.defense = defense;
        this.speed = speed;
        this.health = health;
    }

    public void takeADamage(Hero attackingHero, Hero hero, Creature attackingUnit) {
        double damage = attackingUnit.getDamage();
        damage += (attackingUnit.getAttack() - defense) * DAMAGE_MULTIPLIER * damage;
        int quantityToDelete = 0;
        while (damage > 0 && quantity > 0) {
            if (health > damage) {
                health -= damage;
                break;
            } else {
                damage -= health;
                quantityToDelete++;
                attackingHero.increaseExperience(10);
                health = getDefaultHealth();
            }
        }
        if (quantityToDelete > 0) {
            hero.removeCreature(attackingUnit, quantityToDelete);
        }
    }

    public abstract double getDefaultHealth();

    public double getDamage() {
        return damage;
    }

    public Integer getSpeed() {
        return speed;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getAttack() {
        return attack;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void reducingQuantity(int quantityToReduce) {
        this.quantity -= quantityToReduce;
    }
}
