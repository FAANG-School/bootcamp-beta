package ru.faang.school.task_1;

public class Angel extends Creature {
    private static final String NAME = "Angel";
    private static final int LEVEL = 7;
    private static final int ATTACK = 20;
    private static final int PROTECTION = 20;
    private static final int SPEED = 12;
    private static final int HEALTH = 200;

    public Angel() {
        super(NAME,LEVEL,ATTACK,PROTECTION,SPEED,HEALTH);
    }
}
