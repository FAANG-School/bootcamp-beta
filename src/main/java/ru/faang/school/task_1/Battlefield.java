package ru.faang.school.task_1;

import ru.faang.school.task_1.creature.Creature;
import ru.faang.school.task_1.hero.Hero;

import java.util.logging.Logger;

public class Battlefield {
    private Hero redHero;
    private Hero blueHero;
    private static final int MAX_ROUND = 100;

    public final static Logger logger = Logger.getLogger(Battlefield.class.getName());

    public Battlefield(Hero redHero, Hero blueHero) {
        this.redHero = redHero;
        this.blueHero = blueHero;
    }

    public Hero battle() {
        redHero.getArmy().sort(new Creature.SortBySpeedDesc());
        blueHero.getArmy().sort(new Creature.SortBySpeedDesc());

        int roundCounter = 1;

        while (!isBattleOver() || roundCounter <= MAX_ROUND) {
            logger.info("Round %d:".formatted(roundCounter++) +
                    "%s VS %s".formatted(redHero.getName(), blueHero.getName()));

            redAttack();
            if (isBattleOver()) {
                break;
            }
            blueAttack();
        }

        if (roundCounter >= MAX_ROUND) {
            logger.warning("BattleDraw");
            throw new DrawBattleException();
        }

        Hero winner = redHero.getArmy().size() == 0 ? blueHero : redHero;

        logger.info("Winner is " + winner.getName() + "!!");

        return winner;
    }

    // reference - https://handbookhmm.ru/1-damage
    private void attackFromTo(Hero attackingHero, Hero defendingHero) {
        for (Creature creature : attackingHero.getArmy()) {
            if (isBattleOver()) {
                return;
            }

            Creature defendingCreature = defendingHero.getArmy().getFirst();

            int damage = calculateDamage(attackingHero, creature, defendingHero, defendingCreature);

            int defeatedCreatureQuantity = damage / defendingCreature.getHealth();

            logger.info(attackingHero.getName() + " : " + creature.getName() + "(%d) attacks ".formatted(creature.getQuantity()) +
                    defendingHero.getName() + " : " + defendingCreature.getName() + "(%d) with ".formatted(defendingCreature.getQuantity()) +
                    damage + " damage (%d was killed)".formatted(defeatedCreatureQuantity));

            defendingHero.removeCreature(defendingCreature, defeatedCreatureQuantity);
        }
    }

    private void redAttack() {
        attackFromTo(redHero, blueHero);
    }

    private void blueAttack() {
        attackFromTo(blueHero, redHero);
    }

    private int calculateDamage(Hero attackingHero, Creature attakingCreature, Hero defendingHero, Creature defendingCreature) {
        int attackingCreatureInitDamage = attakingCreature.getDamage();

        int attackDefenceDelta = (attakingCreature.getAttack() + attackingHero.getAttack() -
                (defendingCreature.getDefence() + defendingHero.getDefence()));

        double coefficient = Math.pow((1.0 + 0.1 * Integer.signum(attackDefenceDelta)), Math.abs(attackDefenceDelta));

        int damage = (int) (attackingCreatureInitDamage * coefficient);

        return damage;
    }

    private boolean isBattleOver() {
        return redHero.getArmy().size() == 0 || blueHero.getArmy().size() == 0;
    }

}
