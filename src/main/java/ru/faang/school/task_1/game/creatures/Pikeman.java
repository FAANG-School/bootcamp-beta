package ru.faang.school.task_1.game.creatures;

import java.util.concurrent.ThreadLocalRandom;

public class Pikeman extends Creature {

    public Pikeman () {
        super("Pikeman", 1, 4, (double) ThreadLocalRandom.current().nextInt(1, 3 + 1), 5, 4, 10.0);
    }

    @Override
    public Double getDefaultHealth() {
        return 10.0;
    }
}

