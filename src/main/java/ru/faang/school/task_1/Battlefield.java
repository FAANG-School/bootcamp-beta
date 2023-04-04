package ru.faang.school.task_1;

import java.util.List;
import java.util.Random;

public class Battlefield {
    private Hero leftHero;
    private Hero rightHero;

    public Battlefield(Hero leftHero, Hero rightHero) {
        this.leftHero = leftHero;
        this.rightHero = rightHero;
    }

    public Hero battle() {
        while (!isBattleOver()) {
            attack(rightHero, leftHero);
            attack(leftHero, rightHero);
        }
        return determineTheWinner();
    }

    private boolean isBattleOver() {
        return leftHero.getArmy().isEmpty() || rightHero.getArmy().isEmpty();
    }

    private void attack(Hero defending, Hero attacking) {
        if (isBattleOver()) return;
        Creature defendingCreature = getRandomCreature(defending.getArmy());
        Creature attackingCreature = getRandomCreature(attacking.getArmy());

        int numberOfAttackers = attacking.getCreatureQuantity(attackingCreature);
        int totalDamage = determineTheDamage(defendingCreature, attackingCreature, numberOfAttackers);

        int diedCreatures = defineLoses(defendingCreature, totalDamage);
        defending.removeCreature(defendingCreature, diedCreatures);
    }

    private Creature getRandomCreature(List<Creature> army) {
        int bound = army.size();
        return army.get(new Random().nextInt(bound));
    }

    private int determineTheDamage(Creature defending, Creature attacking, int quantity) {
        int attackDamage = getPotentialDamage(defending, attacking);
        return attackDamage * quantity;
    }

    private int getPotentialDamage(Creature defending, Creature attacking) {
        int damage = attacking.getDamage() - defending.getDefend();
        if (damage <= 0) {
            return 1;
        }
        return damage;
    }

    private int defineLoses(Creature defending, int damage) {
        Integer healthPoints = defending.getHealthPoints();
        if (healthPoints > damage) {
            defending.setHealthPoints(healthPoints - damage);
            return 0;
        }
        damage = damage - healthPoints;
        setRemainingCreatureHealth(defending, damage);
        return 1 + damage / defending.getHealth();
    }

    private void setRemainingCreatureHealth(Creature creature, int damageTaken) {
        int health = damageTaken % creature.getHealth();
        creature.setHealthPoints(health);
    }

    private Hero determineTheWinner() {
        if (leftHero.getArmy().isEmpty()) {
            return rightHero;
        }
        return leftHero;
    }
}
