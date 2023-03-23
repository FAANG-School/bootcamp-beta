package ru.faang.school.task_1;

public class Griffin extends Creature {
    public Griffin(int quantity) {
        super("Griffin", 2, 6, 6, 6, quantity);
    }

    public int getDamage() {
        return getQuantity() * 2;
    }
}
