package ru.faang.school.task_1.creature;

public class Angel extends Creature {
    protected final String name = "Angel";
    protected final int level = 7;
    protected final int attack = 20;
    protected final int defense = 20;
    protected final int speed = 12;

    @Override
    public int getDamage() {
        return this.level * this.qty * this.attack;
    }
}
