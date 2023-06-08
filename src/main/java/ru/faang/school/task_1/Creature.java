package ru.faang.school.task_1;

public abstract class Creature {
    private String name;
    private int level;
    private int attack;
    private int protection;
    private int speed;
    private int quantity;
    private int health;

    public Creature(String name, int level, int attack, int protection, int speed,int health) {
        this.name = name;
        this.level = level;
        this.attack = attack;
        this.protection = protection;
        this.speed = speed;
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getProtection() {
        return protection;
    }

    public void setProtection(int protection) {
        this.protection = protection;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getDamage(){
        return (int) ((Math.random()*getAttack()+1)*getQuantity());
    }
    public int currentHealth(){
        int currentHealth = (health * getQuantity());
        return currentHealth;
    }

}
