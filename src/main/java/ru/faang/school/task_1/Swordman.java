package ru.faang.school.task_1;

public class Swordman extends Creature {
    private static final String NAME = "Swordman";
    private static final int LEVEL = 4;
    private static final int ATTACK = 10;
    private static final int PROTECTION = 12;
    private static final int SPEED = 5;
    private static final int HEALTH = 40;
    public Swordman() {
        super(NAME,LEVEL,ATTACK,PROTECTION,SPEED,HEALTH);

    }
}
