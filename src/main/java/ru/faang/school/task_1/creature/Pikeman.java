package ru.faang.school.task_1.creature;

public class Pikeman extends Creature {
    protected final String name = "Pikeman";
    protected final int level = 1;
    protected final int attack = 4;
    protected final int defense = 5;
    protected final int speed = 4;

    @Override
    public int getDamage() {
        return this.level * this.qty * this.attack;
    }
}
