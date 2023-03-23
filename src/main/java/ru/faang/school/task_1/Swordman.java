package ru.faang.school.task_1;

public class Swordman extends Creature {
    public Swordman(int quantity) {
        super("Swordman", 3, 9, 9, 5, quantity);
    }

    public int getDamage() {
        return getQuantity() * 3;
    }
}
