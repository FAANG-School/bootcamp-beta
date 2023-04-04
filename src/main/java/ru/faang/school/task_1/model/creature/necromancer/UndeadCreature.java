package ru.faang.school.task_1.model.creature.necromancer;

import ru.faang.school.task_1.model.creature.Creature;

import java.util.Random;


public abstract class UndeadCreature extends Creature {

    private static final Double undeadHealthMultiplier = 35.0;

    private static final Double undeadAttackMultiplier = 7.0;

    private final Double undeadCreatureDamageMultiplier;

    private final Random random = new Random();

    public UndeadCreature(String name, Integer level, Double attack,
                          Double defense, Double speed, Integer amount, Double health, Double multiplier) {

        super(name, level, attack + undeadAttackMultiplier, defense,
                speed, amount, health + undeadHealthMultiplier);
        this.undeadCreatureDamageMultiplier = multiplier;
    }

    @Override
    public Double getDamage() {
        double additionalDamage = random.nextDouble(undeadCreatureDamageMultiplier);
        double deathDamage = random.nextDouble(1.5);
        return getAttack() * additionalDamage * deathDamage * getQuantity();
    }

}
