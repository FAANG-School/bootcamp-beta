package ru.faang.school.task_1.creature;

public class Griffin extends Creature {
    protected final String name = "Griffin";
    protected final int level = 3;
    protected final int attack = 8;
    protected final int defense = 8;
    protected final int speed = 6;

    @Override
    public int getDamage() {
        return this.level * this.qty * this.attack;
    }
}
