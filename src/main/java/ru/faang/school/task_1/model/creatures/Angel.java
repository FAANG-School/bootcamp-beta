package ru.faang.school.task_1.model.creatures;

public class Angel extends Creature {
    private final String NAME = getClass().getSimpleName();
    private final int LEVEL = 13;
    private final int ATTACK = 20;
    private final int DEFENCE = 20;
    private final int VELOCITY = 12;
    private final int AMOUNT = 1;

    public Angel() {
        this.name = getClass().getSimpleName();
        this.level = 7;
        this.attack = 20;
        this.defence = 20;
        this.velocity = 12;
        this.amount = 1;
    }
}
