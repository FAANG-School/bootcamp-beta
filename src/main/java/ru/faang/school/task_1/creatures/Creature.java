package ru.faang.school.task_1.creatures;

import java.util.Random;

public abstract class Creature {
    public String name;
    public int level;
    public int attackRating;

    public int defenceRating;

    public int speed;

    public int getQuantity() {
        return quantity;
    }

    public int quantity;
    public int getDamage(){
        return this.attackRating * quantity * speed * level * new Random().nextInt(1,4);
    }

    public int getDefenceRating() {
        return defenceRating * speed * level * new Random().nextInt(1,10);
    }
}
