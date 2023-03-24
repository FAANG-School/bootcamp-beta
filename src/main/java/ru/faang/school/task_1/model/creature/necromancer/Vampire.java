package ru.faang.school.task_1.model.creature.necromancer;


public class Vampire extends UndeadCreature {

    private static final String name = "Вампиры";

    private static final Double attack = 32.0;

    private static final Integer level = 1;

    private static final Double defense = 25.0;

    private static final Double speed = 25.0;

    private static final Double multiplier = 1.6;

    private static final Double health = 60.0;

    public Vampire(Integer amount) {
        super(name, level, attack, defense, speed, amount, health, multiplier);
    }
}
