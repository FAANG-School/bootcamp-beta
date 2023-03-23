package ru.faang.school.task_1.game.creatures;

import java.util.concurrent.ThreadLocalRandom;

public class Griffin extends Creature {

    public Griffin () {
        super("Griffin", 3, 8, (double) ThreadLocalRandom.current().nextInt(3, 6 + 1), 8, 6, 25.0);
    }

    @Override
    public Double getDefaultHealth() {
        return 25.0;
    }
}
