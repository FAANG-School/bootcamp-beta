package ru.faang.school.task_1.model.creature.necromancer;


public class Zombie extends UndeadCreature {

    private static final String name = "Зомби";

    private static final Double attack = 20.0;

    private static final Integer level = 1;

    private static final Double defense = 55.0;

    private static final Double speed = 15.0;

    private static final Double multiplier = 1.9;

    private static final Double health = 120.0;

    public Zombie(final Integer amount) {
        super(name, level, attack, defense, speed, amount, health, multiplier);
    }
}
