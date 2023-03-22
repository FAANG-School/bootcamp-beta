package ru.faang.school.task_1.creature;

public class Griffin extends Creature {
    Griffin(int quantity, int level) {
        super("Griffin", level, quantity, 8, 8, 6, 25);
    }

    @Override
    public int getDamage() {
        return getRandomDamage(3, 6);
    }
}
