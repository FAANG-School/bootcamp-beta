package ru.faang.school.task_1.game.creatures;

import java.util.concurrent.ThreadLocalRandom;

public class Swordman extends Creature {
    private static final String NAME = "Swordman";

    private static final int LEVEL = 4;

    private static final int ATTACK = 10;

    private static final int MINIMUM_DAMAGE = 6;

    private static final int MAXIMUM_DAMAGE = 10;

    private static final ThreadLocalRandom RANDOMIZER = ThreadLocalRandom.current();

    private static final double DAMAGE = RANDOMIZER.nextInt(MINIMUM_DAMAGE, MAXIMUM_DAMAGE);

    private static final int DEFENSE = 12;

    private static final int SPEED = 5;

    private static final double DEFAULT_HEALTH = 35.0;

    public Swordman() {
        super(NAME, LEVEL, ATTACK, DAMAGE, DEFENSE, SPEED, DEFAULT_HEALTH);
    }

    @Override
    public double getDefaultHealth() {
        return DEFAULT_HEALTH;
    }
}
