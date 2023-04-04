package ru.faang.school.task_1;

public class Angel extends Creature {
    public Angel(int quantity) {
        super("Angel", 4, 12, 12, 7, quantity);
    }

    public int getDamage() {
        return getQuantity() * 4;
    }
}
