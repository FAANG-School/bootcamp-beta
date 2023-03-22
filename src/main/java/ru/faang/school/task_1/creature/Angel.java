package ru.faang.school.task_1.creature;

public class Angel extends Creature {
    Angel(int quantity, int level) {
        super("Angel", level, quantity,10, 12, 5, 35);
    }

    @Override
    public int getDamage() {
        return 50;
    }
}
