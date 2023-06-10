package ru.faang.school.task_1;

public class Griffin extends Creature {
    private static final String NAME = "Griffin";
    private static final int LEVEL = 3;
    private static final int ATTACK = 8;
    private static final int PROTECTION = 8;
    private static final int SPEED = 6;
    private static final int HEALTH = 30;
    public Griffin() {
        super(NAME,LEVEL,ATTACK,PROTECTION,SPEED,HEALTH);
    }
}
