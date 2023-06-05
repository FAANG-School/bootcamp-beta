package ru.faang.school.task_1.Creature;
import ru.faang.school.task_1.Hero.Hero;


public abstract class Creature {
    private final String name;
    private final int attack;
    private int health;
    private final int speed;
    private int quantity;


    public Creature(String name, int level, int attack, int health, int speed){
        if(name == null){
            throw new RuntimeException("Имя не введено");
        }
        if(level <= 0 ){
            throw new RuntimeException("Не корректное значение");
        }
        if(attack<= 0 ){
            throw new RuntimeException("Не корректное значение");
        }
        if(health <= 0 ){
            throw new RuntimeException("Не корректное значение");
        }
        if(speed <= 0 ){
            throw new RuntimeException("Не корректное значение");
        }
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

    public int getDamage(){
        return attack*speed;
    }
    public void takeDamage(Hero hero, Creature attackingCreature){
        int damage = attackingCreature.getDamage();
        int quantityToDelete = 0;
        while (damage > 0 && quantity > 0 && quantityToDelete <= quantity ){
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

