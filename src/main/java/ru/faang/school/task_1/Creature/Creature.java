package ru.faang.school.task_1.Creature;
import ru.faang.school.task_1.Hero.Hero;


public abstract class Creature {
    private final String name;
    private final int attack;
    private int health;
    private final int speed;
    private int quantity;


    public Creature(String name, int level, int attack, int health, int speed){
        this.name = name;
        this.attack = attack;
        this.health = health;
        this.speed = speed;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage(){
        return attack*speed;
    }
    public void takeDamage(Hero hero, Creature attackingCreature){
        int damage = attackingCreature.getDamage();
        int quantityToDelete = 0;
        while (damage > 0 && quantity > 0){
            if (health > damage){
                health -= damage;
                break;
            }
            else {
                damage -= health;
                quantityToDelete++;
            }
        }
        if (quantityToDelete > 0){
            hero.removeCreature(this, quantityToDelete);
        }
    }
    public void reducingQuantity(int quantity) {
        this.quantity -= quantity;
    }

    public String toString(){
        return name + " " + quantity;
    }
}

