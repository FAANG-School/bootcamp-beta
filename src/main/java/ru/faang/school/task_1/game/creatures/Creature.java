package ru.faang.school.task_1.game.creatures;

public abstract class Creature {
    public Creature(String name, Integer level, Integer attack, Double damage, Integer defense, Integer speed, Double health) {
        this.name = name;
        this.level = level;
        this.attack = attack;
        this.damage = damage;
        this.defense = defense;
        this.speed = speed;
        this.health = health;
    }

    protected String name;

    protected Integer level;

    protected Integer attack;

    protected Double damage;

    protected Integer defense;

    protected Integer speed;

    protected Double health;

    protected Integer quantity;

    public Double getDamage() {
        return this.damage;
    }

    public Integer getSpeed() {
        return this.speed;
    }

    public int takeADamage(double damage, int attack, double health, int defense) {
        damage += (attack - defense) * 0.05 * damage;
        int quantityReducing = 0;
        while (damage > 0 && this.quantity > 0) {
            if(health > damage) {
                this.health -= damage;
                break;
            } else {
                damage -= this.health;
                quantityReducing++;
                this.health = getDefaultHealth();
            }
        }
        return quantityReducing;
    }

    public void setQuantity(int count) {
        this.quantity = count;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public Integer getAttack() {
        return attack;
    }

    public Double getHealth() {
        return health;
    }

    public Integer getDefense() {
        return defense;
    }

    public abstract Double getDefaultHealth();
}
