package ru.faang.school.task_1.model.creatures;

public class Swordman extends Creature {
    private final String NAME = getClass().getSimpleName();
    private final int LEVEL = 7;
    private final int ATTACK = 10;
    private final int DEFENCE = 12;
    private final int VELOCITY = 5;
    private final int AMOUNT = 4;

    public Swordman() {
        this.name = getClass().getSimpleName();
        this.level = 4;
        this.attack = 10;
        this.defence = 12;
        this.velocity = 5;
        this.amount = 4;
    }
}
