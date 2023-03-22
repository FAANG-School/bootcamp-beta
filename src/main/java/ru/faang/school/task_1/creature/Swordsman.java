package ru.faang.school.task_1.creature;

public class Swordsman extends Creature {
    public Swordsman(int quantity, int level) {
        super("Swordsman", level, quantity, 10, 12, 5, 35);
    }

    @Override
    public int getDamage() {
        return this.getRandomDamage(6, 9);
    }
}
