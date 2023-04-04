package ru.faang.school.task_1.creatures;

public class Swordman extends Creature {
    @Override
    public int getDamage() {
        return 6+(int)(Math.random()*3);
    }
}

