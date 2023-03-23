package ru.faang.school.task_1.game.creatures;

import java.util.concurrent.ThreadLocalRandom;

public class Swordman extends Creature {

    public Swordman () {
        super("Swordman", 4, 10, (double) ThreadLocalRandom.current().nextInt(6, 9 + 1), 12, 5, 35.0);
    }

    @Override
    public Double getDefaultHealth() {
        return 35.0;
    }
}
