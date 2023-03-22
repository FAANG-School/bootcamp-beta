package ru.faang.school.task_1.battlefield;

import ru.faang.school.task_1.creature.Creature;
import ru.faang.school.task_1.hero.Hero;
import ru.faang.school.task_1.utils.RandomUtils;

import java.util.Map;
import java.util.Optional;

public class Battlefield {
    private Hero player1;
    private Hero player2;

    public Battlefield(Hero player1, Hero player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public Optional<Hero> battle() throws InterruptedException {
        System.out.println("=============== BATTLE STARTED ===============");
        Optional<Hero> maybeWinner = Optional.empty();
        Hero attackingHero;
        Hero defendingHero;
        System.out.println(String.format("Battle of %s vs %s", player1.toString(), player2.toString()));
        while (this.player1.getArmySize() > 0 && this.player2.getArmySize() > 0) {
            System.out.println("=============== NEXT TURN ===============");
            attackingHero = this.pickRandomHero();
            defendingHero = this.pickOpposingHero(attackingHero);

            System.out.println(String.format("%s attacks %s%n", attackingHero.getName(), defendingHero.getName()));
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
        System.out.println("=============== BATTLE ENDED ===============");
        return maybeWinner;
    }

    private Hero pickRandomHero() {
        int randomNumber = RandomUtils.getRandomNumberFromRange(1, 2);
        return randomNumber == 1 ? player1 : player2;
    }

    private Hero pickOpposingHero(Hero player) {
        return this.player1.hashCode() == player.hashCode() ? this.player2 : this.player1;
    }

    private Creature pickRandomCreature(Map<Creature, Integer> army) {
        return RandomUtils.getRandomSetElement(army.keySet());
    }

    private int calculateCreatureQuantityAfterHit(Creature creature, int damage) {
        double effectiveDamage = damage  - creature.getDefensePoints();
        int killedCreatures = (int) Math.ceil(effectiveDamage / creature.getHealth());
        return Math.max(0, killedCreatures);
    }

    private void performAttack(Hero attacker, Hero defender) {
        Creature attackingCreature = this.pickRandomCreature(attacker.getArmy());
        Creature defendingCreature = this.pickRandomCreature(defender.getArmy());

        int attackingCreatureDamagePoints = attackingCreature.getDamagePoints();
        int defensingCreatureDefensePoints = defendingCreature.getDefensePoints();

        int killedDefendingCreatures = this.calculateCreatureQuantityAfterHit(
                defendingCreature,
                attackingCreatureDamagePoints
        );
        System.out.println(
                String.format("%s attacks %s [defense %s] with damage %s. %s killed.",
                        attackingCreature.toString(),
                        defendingCreature.toString(),
                        defensingCreatureDefensePoints,
                        attackingCreatureDamagePoints,
                        killedDefendingCreatures));

        defender.removeCreature(defendingCreature, killedDefendingCreatures);
    }

    private Optional<Hero> getWinner(Hero hero1, Hero hero2) {
        int hero1ArmySize = hero1.getArmySize();
        int hero2ArmySize = hero2.getArmySize();

        if (hero1ArmySize == hero2ArmySize) {
            System.out.println("Battle is over. Nobody winds. Draw.");
            return Optional.empty();
        } else {
            Hero winner = hero1ArmySize > hero2ArmySize ? hero1 : hero2;
            System.out.println(String.format("Battle is over. %s wins the game.", winner.toString()));
            return Optional.of(winner);
        }
    }

    private boolean isBattleOver(Hero hero1, Hero hero2) {
        return hero1.getArmySize() == 0 || hero2.getArmySize() == 0;
    }
}
