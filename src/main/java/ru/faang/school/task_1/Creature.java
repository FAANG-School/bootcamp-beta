package ru.faang.school.task_1;

public abstract class Creature {
    private String name;
    private int level;
    private int attack;
    private int defence;
    private int baseHealth;
    private int speed;
    private int quantity;
    private int totalHealth = -1; //Костыль. Нужнен, чтобы один раз установить общее здоровье для отряда. Иначе здоровье будет обновляться постоянно и отряд никогда не погибнет.

    public Creature(String name, int level, int attack, int defence, int health, int speed) {
        this.name = name;
        this.level = level;
        this.attack = attack;
        this.defence = defence;
        this.baseHealth = health;
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

    public int getTotalHealth() {
        return totalHealth;
    }

    public void setTotalHealth(int totalHealth) {
        this.totalHealth = totalHealth;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        if(totalHealth == -1) { //Тот самый костыль.
            totalHealth = baseHealth * quantity;
        }
    }

    @Override
    public String toString() {
        return "Squad of "+ name + "s" +
                ": {level=" + level +
                ", attack=" + attack +
                ", defence=" + defence +
                ", quantity=" + quantity +
                ", totalHealth=" + totalHealth +
                '}';
    }

    public abstract int getDamage();


}
