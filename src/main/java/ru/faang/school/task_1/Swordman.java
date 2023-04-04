package ru.faang.school.task_1;

public class Swordman extends Creature{

    public Swordman() {
        super("Мечник", 2, 7, 9, 8);
    }

    @Override
    int getDamage() {
        return getAttack() * getQuantity();
    }
}
