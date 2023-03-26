package ru.faang.school.task_1.game.creatures;

import java.util.concurrent.ThreadLocalRandom;

public class Griffin extends Creature {

    private static final String NAME = "Griffin";

    private static final int LEVEL = 3;

    private static final int ATTACK = 8;

    private static final int MINIMUM_DAMAGE = 3;

    private static final int MAXIMUM_DAMAGE = 7;

    private static final ThreadLocalRandom RANDOMIZER = ThreadLocalRandom.current();

    private static final double DAMAGE = RANDOMIZER.nextInt(MINIMUM_DAMAGE, MAXIMUM_DAMAGE);

    private static final int DEFENSE = 8;

    private static final int SPEED = 6;

    private static final double DEFAULT_HEALTH = 25.0;

    public Griffin() {
        super(NAME, LEVEL, ATTACK, DAMAGE, DEFENSE, SPEED, DEFAULT_HEALTH);
    }

    @Override
    public double getDefaultHealth() {
        return DEFAULT_HEALTH;
    }
}
