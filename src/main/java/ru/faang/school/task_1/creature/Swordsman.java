package ru.faang.school.task_1.creature;

public class Swordsman extends Creature {
    protected final String name = "Swordsman";
    protected final int level = 4;
    protected final int attack = 4;
    protected final int defense = 12;
    protected final int speed = 5;

    @Override
    public int getDamage() {
        return this.level * this.qty * this.attack;
    }
}
