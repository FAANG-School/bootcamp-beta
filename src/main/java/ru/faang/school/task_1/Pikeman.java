package ru.faang.school.task_1;

public class Pikeman extends Creature {
    private static final String NAME = "Pikeman";
    private static final int LEVEL = 1;
    private static final int ATTACK = 4;
    private static final int PROTECTION = 5;
    private static final int SPEED = 4;
    private static final int HEALTH = 10;
    public Pikeman(){
        super(NAME,LEVEL,ATTACK,PROTECTION,SPEED,HEALTH);

    }
}

