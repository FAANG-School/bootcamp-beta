package ru.faang.school.task_1;

public class Griffin extends Creature {

    public Griffin() {
        super("Грифон", 0, 8, 8, 6);
    }

    @Override
    int getDamage() {
        return getAttack() * getQuantity();
    }
}
