package ru.faang.school.task_1.creature;

public class Pikeman extends Creature {
    public Pikeman(int quantity, int level) {
        super("Pikeman", level, quantity, 4, 5, 4);
    }

    @Override
    public int getDamage() {
        return getRandomDamage(1, 3);
    }
}
