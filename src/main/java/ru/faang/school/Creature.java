package ru.faang.school;

public abstract class Creature {
    //поля для характеристики героев
    protected String name;
    protected int level;
    protected int attack;
    protected double speed;
    protected int quantity;
    protected int damage;
    //конструктор для присвоения значений
    public Creature(String name, int level, int attack, double speed, int quantity) {
    }
    //система нанесения урона
    private int getDamage() {
        return(attack * quantity);
    }

    public int getPower() {
        return 0;
    }
}



