package ru.faang.school.task_1.game.creatures;

public class Angel extends Creature {

    public Angel () {
        super("Angel", 7, 20, 50.0, 20, 12, 200.0);
    }

    @Override
    public Double getDefaultHealth() {
        return 200.0;
    }
}
