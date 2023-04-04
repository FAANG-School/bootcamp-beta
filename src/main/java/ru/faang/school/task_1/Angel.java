package ru.faang.school.task_1;

public class Angel extends Creature{

    String name = "angel";
    int level = 10;
    int damage = 15;
    int defense = 10;

    @Override
    public int getDamage() {
        return damage;
    }

    public int getDefense() {
        return defense;
    }
}
