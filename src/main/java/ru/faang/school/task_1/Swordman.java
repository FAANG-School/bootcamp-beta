package ru.faang.school.task_1;

public class Swordman extends Creature{

    String name = "swordman";
    int level = 10;
    int damage = 80;
    int defense = 60;


    @Override
    public int getDamage() {
        return damage;
    }

    public int getDefense() {
        return defense;
    }
}
