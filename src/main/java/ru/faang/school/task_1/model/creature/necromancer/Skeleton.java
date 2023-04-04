package ru.faang.school.task_1.model.creature.necromancer;


public class Skeleton extends UndeadCreature {

    private static final String name = "Скелеты лучники";

    private static final Double attack = 5.0;

    private static final Integer level = 1;

    private static final Double defense = 5.0;

    private static final Double speed = 15.0;

    private static final Double multiplier = 1.2;

    private static final Double health = 10.0;

    public Skeleton(final Integer amount) {
        super(name, level, attack, defense, speed, amount, health, multiplier);
    }
}
