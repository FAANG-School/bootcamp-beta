package ru.faang.school.task_1.model.creature.human;

import ru.faang.school.task_1.model.creature.Creature;

import java.util.Random;


public abstract class HumanCreature extends Creature {

    private static final Double humanDefenseMultiplier = 50.0;

    private static final Double humanSpeedMultiplier = 5.0;

    private final Double humanCreatureDamageMultiplier;

    private final Random random = new Random();

    public HumanCreature(String name, Integer level, Double attack,
                         Double defense, Double speed, Integer amount, Double health, Double multiplier) {

        super(name, level, attack, defense + humanDefenseMultiplier,
                speed + humanSpeedMultiplier, amount, health);
        this.humanCreatureDamageMultiplier = multiplier;
    }

    @Override
    public Double getDamage() {
        double additionalDamage = random.nextDouble(humanCreatureDamageMultiplier);
        return getAttack() * additionalDamage * getQuantity();
    }

}
