package ru.faang.school.task_1;

import java.util.Objects;

public abstract class Creature {
    private final String name;
    private final int level;
    private final int attack;
    private final int defence;
    private final int baseHealth;
    private final int speed;
    private int quantity;
    private Integer totalSquadHealth;

    public Creature(String name, int level, int attack, int defence, int baseHealth, int speed) {

        this.name = name;
        this.level = level;
        this.attack = attack;
        this.defence = defence;
        this.baseHealth = baseHealth;
        this.speed = speed;
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

    public int getDefence() {
        return defence;
    }

    public int getHealth() {
        return baseHealth;
    }

    public int getSpeed() {
        return speed;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if(quantity <= 0)
            this.quantity = 1;
        else if(quantity > 50)
            this.quantity = 50;
        else
            this.quantity = quantity;

        if(totalSquadHealth == null) {
            totalSquadHealth = baseHealth * this.quantity;
        }
    }

    public int getTotalSquadHealth() {
        return totalSquadHealth;
    }

    public void setTotalHealth(int totalHealth) {
        if(totalHealth <= 0){
            quantity = 0;
            this.totalSquadHealth = 0;
        }
        else
            this.totalSquadHealth = totalHealth;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Creature creature = (Creature) o;
        return level == creature.level && attack == creature.attack && defence == creature.defence && baseHealth == creature.baseHealth && speed == creature.speed && Objects.equals(name, creature.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, level, attack, defence, baseHealth, speed);
    }

    @Override
    public String toString() {
        return name + " Squad" +
                ": {level=" + level +
                ", attack=" + attack +
                ", defence=" + defence +
                ", quantity=" + quantity +
                ", totalHealth=" + totalSquadHealth +
                '}';
    }

    public int getDamage(){
        return (this.getAttack() + this.getLevel()) * this.getQuantity();
    };

}
