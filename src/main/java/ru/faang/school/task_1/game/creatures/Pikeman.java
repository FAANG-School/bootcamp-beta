package ru.faang.school.task_1.game.creatures;

import java.util.concurrent.ThreadLocalRandom;

public class Pikeman extends Creature {

    private static final String NAME = "Pikeman";

    private static final int LEVEL = 1;

    private static final int ATTACK = 4;

    private static final int MINIMUM_DAMAGE = 1;

    private static final int MAXIMUM_DAMAGE = 4;

    private static final ThreadLocalRandom RANDOMIZER = ThreadLocalRandom.current();

    private static final double DAMAGE = RANDOMIZER.nextInt(MINIMUM_DAMAGE, MAXIMUM_DAMAGE);

    private static final int DEFENSE = 5;

    private static final int SPEED = 4;

    private static final double DEFAULT_HEALTH = 10.0;

    public Pikeman () {
        super(NAME, LEVEL, ATTACK, DAMAGE, DEFENSE, SPEED, DEFAULT_HEALTH);
    }

    @Override
    public double getDefaultHealth() {
        return DEFAULT_HEALTH;
    }
}

