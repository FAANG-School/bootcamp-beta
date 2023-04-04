package ru.faang.school.task_1.battlefield;

import ru.faang.school.task_1.creature.Creature;
import ru.faang.school.task_1.hero.Hero;
import ru.faang.school.task_1.utils.RandomUtils;

import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

/**
 * The Battlefield class represents a battle between two Heroes and their armies of Creatures.
 */
public class Battlefield {
    private final Hero player1;
    private final Hero player2;

    /**
     * Creates a new Battlefield object with the given Heroes.
     *
     * @param player1 the first Hero in the battle
     * @param player2 the second Hero in the battle
     */
    public Battlefield(Hero player1, Hero player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    /**
     * Simulates a battle between the two Heroes and their armies of Creatures.
     *
     * @return an Optional containing the winning Hero, or empty if the battle ended in a draw
     */
    public Optional<Hero> battle() {
        Optional<Hero> maybeWinner = Optional.empty();
        Hero attackingHero;
        Hero defendingHero;
        while (this.player1.getArmySize() > 0 && this.player2.getArmySize() > 0) {
            attackingHero = this.pickRandomHero();
            defendingHero = this.pickOpposingHero(attackingHero);

            this.performAttack(attackingHero, defendingHero);
            if (this.isBattleOver(attackingHero, defendingHero)) {
                maybeWinner = this.getWinner(attackingHero, defendingHero);
                break;
            }
            this.performAttack(defendingHero, attackingHero);
            if (this.isBattleOver(attackingHero, defendingHero)) {
                maybeWinner = this.getWinner(attackingHero, defendingHero);
                break;
            }
        }
        return maybeWinner;
    }

    /**
     * Picks a random Hero from the two Heroes in the battle.
     *
     * @return a randomly chosen Hero
     */
    private Hero pickRandomHero() {
        int randomNumber = RandomUtils.getRandomNumberFromRange(1, 2);
        return randomNumber == 1 ? player1 : player2;
    }

    /**
     * Picks the opposing Hero to the given Hero in the battle.
     *
     * @param player the Hero whose opponent is being picked
     * @return the opposing Hero to the given Hero
     */

    private Hero pickOpposingHero(Hero player) {
        return this.player1.hashCode() == player.hashCode() ? this.player2 : this.player1;
    }

    /**
     * Picks a random Creature from the given Hero's army.
     *
     * @param army the Hero's army from which to pick a Creature
     * @return a randomly chosen Creature from the Hero's army
     */
    private Creature pickRandomCreature(Map<Creature, Integer> army) {
        Set<Creature> creaturesSet = army.keySet();
        return creaturesSet.stream().skip(new Random().nextInt(creaturesSet.size())).findFirst().orElse(null);
    }

    /**
     * Calculates the number of Creatures killed by an attack, based on the attacking Creature's damage
     * and the defending Creature's defense.
     *
     * @param creature the defending Creature
     * @param damage   the damage dealt by the attacking Creature
     * @return the number of Creatures killed by the attack
     */
    public int calculateCreatureQuantityAfterHit(Creature creature, int damage) {
        double effectiveDamage = damage - creature.getDefensePoints();
        int killedCreatures = (int) Math.ceil(effectiveDamage / creature.getDefense());
        return Math.max(0, killedCreatures);
    }

    /**
     * Performs an attack by an attacking Hero's Creature on a defending Hero's Creature.
     *
     * @param attacker the attacking Hero
     * @param defender the defending Hero
     */
    private void performAttack(Hero attacker, Hero defender) {
        Creature attackingCreature = this.pickRandomCreature(attacker.getArmy());
        Creature defendingCreature = this.pickRandomCreature(defender.getArmy());

        int attackingCreatureDamagePoints = attackingCreature.getDamagePoints();

        int killedDefendingCreatures = this.calculateCreatureQuantityAfterHit(
                defendingCreature,
                attackingCreatureDamagePoints
        );
        defender.removeCreature(defendingCreature, killedDefendingCreatures);
    }

    /**
     * Determines the winner of the battle between two heroes based on the size of their armies.
     * If both heroes have the same army size, returns an empty Optional.
     * If one hero has a larger army size than the other, returns an Optional of the winner.
     *
     * @param hero1 the first hero to compare
     * @param hero2 the second hero to compare
     * @return an Optional of the winning hero or empty if the armies have the same size and there is draw
     */
    private Optional<Hero> getWinner(Hero hero1, Hero hero2) {
        int hero1ArmySize = hero1.getArmySize();
        int hero2ArmySize = hero2.getArmySize();

        if (hero1ArmySize == hero2ArmySize) {
            return Optional.empty();
        } else {
            Hero winner = hero1ArmySize > hero2ArmySize ? hero1 : hero2;
            return Optional.of(winner);
        }
    }

    /**
     * Checks whether the battle is over based on whether one of the heroes has lost all the creatures in their army.
     *
     * @param hero1 the first hero to check
     * @param hero2 the second hero to check
     * @return true if the battle is over, false otherwise
     */
    private boolean isBattleOver(Hero hero1, Hero hero2) {
        return hero1.getArmySize() == 0 || hero2.getArmySize() == 0;
    }
}
