package ru.faang.school.task_1.model.creature.human;

public class Pikeman extends HumanCreature {

    private static final String name = "Копейщики";

    private static final Double attack = 25.0;

    private static final Integer level = 1;

    private static final Double defense = 35.0;

    private static final Double speed = 28.0;

    private static final Double multiplier = 1.6;

    private static final Double health = 50.0;

    public Pikeman(Integer amount) {
        super(name, level, attack, defense, speed, amount, health, multiplier);
    }
}
