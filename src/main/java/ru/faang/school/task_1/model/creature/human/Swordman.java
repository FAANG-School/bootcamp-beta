package ru.faang.school.task_1.model.creature.human;

public class Swordman extends HumanCreature {

    private static final String name = "Мечники";

    private static final Double attack = 20.0;

    private static final Integer level = 1;

    private static final Double defense = 45.0;

    private static final Double speed = 24.0;

    private static final Double multiplier = 1.5;

    private static final Double health = 40.0;

    public Swordman(final Integer amount) {
        super(name, level, attack, defense, speed, amount, health, multiplier);
    }
}
