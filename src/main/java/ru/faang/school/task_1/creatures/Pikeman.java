package ru.faang.school.task_1.creatures;

public class Pikeman extends Creature {
    @Override
    public int getDamage() {
        return (int)(Math.random()*3);
    }
}
