package ru.faang.school.task_1.model.creatures;

public class Pikeman extends Creature {

    public Pikeman() {
        this.name = getClass().getSimpleName();
        this.level = 1;
        this.attack = 4;
        this.defence = 5;
        this.velocity = 4;
        this.amount = 14;
    }
}
