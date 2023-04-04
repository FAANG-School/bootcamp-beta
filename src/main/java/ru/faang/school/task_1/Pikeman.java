package ru.faang.school.task_1;

public class Pikeman extends Creature {

    String name = "pikeman";
    int level = 10;
    int damage = 50;
    int defense = 25;


    @Override
    public int getDamage() {
        return damage;
    }


    public int getDefense() {
        return defense;
    }



}
