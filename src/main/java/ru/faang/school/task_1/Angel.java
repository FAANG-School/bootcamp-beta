package ru.faang.school.task_1;

public class Angel extends Creature {

    public Angel() {
        super("Ангел", 0, 20, 20, 12);
    }

    @Override
    int getDamage() {
        return getAttack() * getQuantity();
    }
}
