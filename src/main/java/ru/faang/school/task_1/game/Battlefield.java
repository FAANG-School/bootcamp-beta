package ru.faang.school.task_1.game;

import ru.faang.school.task_1.game.creatures.*;
import ru.faang.school.task_1.game.heroes.Hero;
import java.util.concurrent.ThreadLocalRandom;

public class Battlefield {
    private Hero firstHero;

    private Hero secondHero;

    public Battlefield(Hero firstHero, Hero secondHero) {
        this.firstHero = firstHero;
        this.secondHero = secondHero;
    }

    public Hero battle() {
        int lot = draw();
        Hero winner;
        if(lot == 1) {
            System.out.println(firstHero.getName() + " goes first.");
            winner = battle(firstHero, secondHero);
        } else {
            System.out.println(secondHero.getName() + " goes first.");
            winner = battle(secondHero, firstHero);
        }
        return winner;
    }

    private Hero battle(Hero firstHero, Hero secondHero) {
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

    private int draw() {
        return ThreadLocalRandom.current().nextInt(1, 2 + 1);
    }
    private void sortingArmiesBySpeedDesc(Hero firstHero, Hero secondHero) {
        firstHero.getArmy().sort(((o1, o2) -> o2.getSpeed().compareTo(o1.getSpeed())));
        secondHero.getArmy().sort(((o1, o2) -> o2.getSpeed().compareTo(o1.getSpeed())));
    }

    private void makeAMove(Hero hero, Hero enemyHero) {
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
