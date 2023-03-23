package ru.faang.school.task_1.game;

import ru.faang.school.task_1.game.creatures.*;
import ru.faang.school.task_1.game.heroes.Hero;
import java.util.concurrent.ThreadLocalRandom;

public class Battlefield {
    public static void main(String[] args) {
        Hero firstHero = new Hero("Hero1", "Red Fraction");
        firstHero.addCreature(new Angel(), 1);
        firstHero.addCreature(new Griffin(), 4);
        firstHero.addCreature(new Pikeman(), 3);
        firstHero.addCreature(new Swordman(), 5);


        Hero secondHero = new Hero("Hero2", "Blue Fraction");
        secondHero.addCreature(new Angel(), 1);
        secondHero.addCreature(new Griffin(), 4);
        secondHero.addCreature(new Pikeman(), 3);
        secondHero.addCreature(new Swordman(), 5);

        int lot = ThreadLocalRandom.current().nextInt(1, 2 + 1);
        Hero winner;
        if(lot == 1) {
            System.out.println(firstHero.getName() + " goes first.");
            winner = battle(firstHero, secondHero);
        } else {
            System.out.println(secondHero.getName() + " goes first.");
            winner = battle(secondHero, firstHero);
        }
        System.out.println("Winner is " + winner);

        Hero thirdHero = new Hero("Hero3", "Red Fraction");
        thirdHero.addCreature(new Angel(), 3);


        Hero fourthHero = new Hero("Hero4", "Blue Fraction");
        fourthHero.addCreature(new Griffin(), 110);
        fourthHero.addCreature(new Pikeman(), 150);
        fourthHero.addCreature(new Swordman(), 100);

        lot = ThreadLocalRandom.current().nextInt(1, 2 + 1);
        if(lot == 1) {
            System.out.println(thirdHero.getName() + " goes first.");
            winner = battle(thirdHero, fourthHero);
        } else {
            System.out.println(fourthHero.getName() + " goes first.");
            winner = battle(fourthHero, thirdHero);
        }
        System.out.println("Winner is " + winner);
    }

    public static Hero battle(Hero firstHero, Hero secondHero) {
        firstHero.getArmy().sort(((o1, o2) -> o2.getSpeed().compareTo(o1.getSpeed())));
        secondHero.getArmy().sort(((o1, o2) -> o2.getSpeed().compareTo(o1.getSpeed())));
        int strokeNumber = 1;
        while (!firstHero.getArmy().isEmpty() || !secondHero.getArmy().isEmpty()) {
            if(secondHero.getArmy().isEmpty() || firstHero.getArmy().isEmpty()) {
                break;
            }
            if(strokeNumber % 2 != 0) {
                makeAMove(firstHero, secondHero);
            } else {
                makeAMove(secondHero, firstHero);
            }
            strokeNumber++;
        }
        return firstHero.getArmy().isEmpty() ? secondHero : firstHero;
    }

    private static void makeAMove(Hero hero, Hero enemyHero) {
        for (Creature unit : hero.getArmy()) {
            if(enemyHero.getArmy().isEmpty()) {
                return;
            }
            int index = ThreadLocalRandom.current().nextInt(0, enemyHero.getArmy().size());
            Creature enemyUnit = enemyHero.getArmy().get(index);
            int unitsToRemove = enemyUnit.takeADamage(unit.getDamage(), unit.getAttack(), enemyUnit.getHealth(), enemyUnit.getDefense());
            if(unitsToRemove > 0 || enemyHero.getArmy().get(index).getQuantity() == 0) {
                enemyHero.removeCreature(enemyUnit, unitsToRemove);
                hero.setExperience(hero.getExperience() + 10);
                if(hero.getExperience() % 100 == 0) {
                    hero.setLevel(hero.getLevel() + 1);
                }
            }
        }
    }
}
