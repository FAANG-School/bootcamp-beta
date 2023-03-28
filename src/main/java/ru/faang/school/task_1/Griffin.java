package ru.faang.school.task_1;

public class Griffin extends Creature{

    String name = "griffin";
    int level = 10;
    int damage = 100;
    int defense = 50;

    @Override
    public int getDamage() {
        return damage;
    }

    public int getDefense() {
        return defense;
    }
}
