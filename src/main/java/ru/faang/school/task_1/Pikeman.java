package ru.faang.school.task_1;

public class Pikeman extends Creature{

    public Pikeman() {
        super("Копейщик", 1, 4, 5, 4);
    }

    @Override
    int getDamage() {
        return getAttack() * getQuantity();
    }
}
