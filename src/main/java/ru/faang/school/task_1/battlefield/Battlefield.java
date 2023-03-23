package ru.faang.school.task_1.battlefield;

import ru.faang.school.task_1.creature.Creature;
import ru.faang.school.task_1.hero.Hero;
import ru.faang.school.task_1.utils.RandomUtils;

import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

public class Battlefield {
    private final Hero player1;
    private final Hero player2;

    public Battlefield(Hero player1, Hero player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

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

    public Hero pickRandomHero() {
        int randomNumber = RandomUtils.getRandomNumberFromRange(1, 2);
        return randomNumber == 1 ? player1 : player2;
    }

    public Hero pickOpposingHero(Hero player) {
        return this.player1.hashCode() == player.hashCode() ? this.player2 : this.player1;
    }

    public Creature pickRandomCreature(Map<Creature, Integer> army) {
        Set<Creature> creaturesSet = army.keySet();
        return creaturesSet.stream().skip(new Random().nextInt(creaturesSet.size())).findFirst().orElse(null);
    }

    public int calculateCreatureQuantityAfterHit(Creature creature, int damage) {
        double effectiveDamage = damage - creature.getDefensePoints();
        int killedCreatures = (int) Math.ceil(effectiveDamage / creature.getDefense());
        return Math.max(0, killedCreatures);
    }

    public void performAttack(Hero attacker, Hero defender) {
        Creature attackingCreature = this.pickRandomCreature(attacker.getArmy());
        Creature defendingCreature = this.pickRandomCreature(defender.getArmy());

        int attackingCreatureDamagePoints = attackingCreature.getDamagePoints();

        int killedDefendingCreatures = this.calculateCreatureQuantityAfterHit(
                defendingCreature,
                attackingCreatureDamagePoints
        );
        defender.removeCreature(defendingCreature, killedDefendingCreatures);
    }

    public Optional<Hero> getWinner(Hero hero1, Hero hero2) {
        int hero1ArmySize = hero1.getArmySize();
        int hero2ArmySize = hero2.getArmySize();

        if (hero1ArmySize == hero2ArmySize) {
            return Optional.empty();
        } else {
            Hero winner = hero1ArmySize > hero2ArmySize ? hero1 : hero2;
            return Optional.of(winner);
        }
    }

    public boolean isBattleOver(Hero hero1, Hero hero2) {
        return hero1.getArmySize() == 0 || hero2.getArmySize() == 0;
    }
}
