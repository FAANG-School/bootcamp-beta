package ru.faang.school.task_1.game;

import ru.faang.school.task_1.game.creatures.*;
import ru.faang.school.task_1.game.heroes.Hero;

import java.util.concurrent.ThreadLocalRandom;

public class Battlefield {

    private static final ThreadLocalRandom RANDOMIZER = ThreadLocalRandom.current();

    private static final int FIRST_HERO_NUMBER = 1;

    /*
    Значение 3, а не 2, поскольку ThreadLocalRandom.current() возвращает число ниже верхней границы на 1
     */
    private static final int SECOND_HERO_NUMBER = 3;

    private final Hero firstHero;

    private final Hero secondHero;

    public Battlefield(Hero firstHero, Hero secondHero) {
        this.firstHero = firstHero;
        this.secondHero = secondHero;
    }

    public Hero battle() {
        sortArmies();
        int lot = draw();
        Hero winner;
        if (lot == 1) {
            announcementWhoGoesFirst(firstHero.getName());
            winner = battle(firstHero, secondHero);
        } else {
            announcementWhoGoesFirst(secondHero.getName());
            winner = battle(secondHero, firstHero);
        }
        return winner;
    }

    private Hero battle(Hero firstHero, Hero secondHero) {
        int strokeNumber = 1;
        while (!firstHero.isArmyEmpty() && !secondHero.isArmyEmpty()) {
            if (strokeNumber % 2 != 0) {
                makeAMove(firstHero, secondHero);
            } else {
                makeAMove(secondHero, firstHero);
            }
            strokeNumber++;
        }
        return firstHero.isArmyEmpty() ? secondHero : firstHero;
    }

    private int draw() {
        return RANDOMIZER.nextInt(FIRST_HERO_NUMBER, SECOND_HERO_NUMBER);
    }

    private void sortArmies() {
        sortArmy(firstHero);
        sortArmy(secondHero);
    }

    private void sortArmy(Hero hero) {
        hero.getArmy().sort(((o1, o2) -> o2.getSpeed().compareTo(o1.getSpeed())));
    }

    private void makeAMove(Hero hero, Hero enemyHero) {
        for (Creature unit : hero.getArmy()) {
            if (enemyHero.isArmyEmpty()) {
                return;
            }
            int indexOfUnitToAttack = RANDOMIZER.nextInt(0, enemyHero.getArmySize());
            Creature enemyUnit = enemyHero.getArmy().get(indexOfUnitToAttack);
            enemyUnit.takeADamage(hero, enemyHero, unit);
        }
    }

    private void announcementWhoGoesFirst(String heroName) {
        System.out.println(heroName + " goes first.");
    }
}
