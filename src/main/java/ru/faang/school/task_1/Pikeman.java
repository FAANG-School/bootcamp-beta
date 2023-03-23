package ru.faang.school.task_1;

public class Pikeman extends Creature {
    public Pikeman(int quantity) {
        super("Pikeman", 1, 2, 3, 4, quantity);
    }

    public int getDamage() {
        return getQuantity() * 1;
    }
}
