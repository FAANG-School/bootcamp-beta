package ru.faang.school.task_1.model.human;

public class Griffin extends HumanCreature {

    private static final String name = "Griffin";

    private static final Double attack = 27.0;

    private static final Integer level = 1;

    private static final Double defense = 30.0;

    private static final Double speed = 20.0;

    private static final Double multiplier = 1.9;

    private static final Double health = 80.0;

    public Griffin(final Integer amount) {
        super(name, level, attack, defense, speed, amount, health, multiplier);
    }
}
