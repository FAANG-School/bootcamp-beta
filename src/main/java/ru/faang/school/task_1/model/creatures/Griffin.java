package ru.faang.school.task_1.model.creatures;

public class Griffin extends Creature {
    public Griffin() {
        this.name = getClass().getSimpleName();
        this.level = 5;
        this.attack = 8;
        this.defence = 8;
        this.velocity = 6;
        this.amount = 7;
    }
}
