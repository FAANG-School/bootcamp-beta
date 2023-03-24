package ru.faang.school.task_1;


import ru.faang.school.task_1.creatures.Creature;

import java.util.List;
import java.util.Random;

public class Battlefield {
    private Hero firstHero;
    private Hero secondHero;

    public Battlefield(Hero firstHero, Hero secondHero) {
        this.firstHero = firstHero;
        this.secondHero = secondHero;
    }

    public Hero battle() {

        int firstHeroTotalAttackPower = getTotalAttackPower(firstHero.getArmy());
        int secondHeroTotalAttackPower = getTotalAttackPower(secondHero.getArmy());
        int firstHeroTotalArmor = getTotalArmor(firstHero.getArmy());
        int secondHeroTotalArmor = getTotalArmor(secondHero.getArmy());

        return (secondHeroTotalArmor - firstHeroTotalAttackPower) > (firstHeroTotalArmor - secondHeroTotalAttackPower) ?
                secondHero : firstHero;
    }

    private int getTotalAttackPower(List<Creature> creatureList) {
        int totalAttack = 0;
        for (Creature creature : creatureList) {
            totalAttack += creature.getAttackPower() * creature.getQuantity();
        }
        return totalAttack;
    }

    private int getTotalArmor(List<Creature> creatureList) {
        int totalArmor = 0;
        for (Creature creature : creatureList) {
            totalArmor += creature.getArmor() * creature.getQuantity();
        }
        return totalArmor;
    }


}
