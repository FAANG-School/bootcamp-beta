package ru.faang.school.task_1.game.creatures;

public class Angel extends Creature {

    private static final String NAME = "Angel";

    private static final int LEVEL = 7;

    private static final int ATTACK = 20;

    private static final double DAMAGE = 50.0;

    private static final int DEFENSE = 20;

    private static final int SPEED = 12;

    private static final double DEFAULT_HEALTH = 200.0;

    public Angel() {
        super(NAME, LEVEL, ATTACK, DAMAGE, DEFENSE, SPEED, DEFAULT_HEALTH);
    }

    @Override
    public double getDefaultHealth() {
        return DEFAULT_HEALTH;
    }
}
