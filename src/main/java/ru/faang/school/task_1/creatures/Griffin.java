package ru.faang.school.task_1.creatures;

public class Griffin extends Creature {
    @Override
    public int getDamage() {
        return 3+(int)(Math.random()*3);
    }
}
