package ru.faang.school.task_1;

import java.util.List;

public class Battlefield {
    private Hero hero1;
    private Hero hero2;

    public Battlefield(Hero hero1, Hero hero2) {
        this.hero1 = hero1;
        this.hero2 = hero2;
    }

    private int calculateArmyPower(List<Creature> army) {
        int totalPower = 0;
        for (Creature creature : army) {
            totalPower += creature.getDamage();
        }
        return totalPower;
    }
    public Hero battle() {
        int army1Power = calculateArmyPower(this.hero1.getArmy());
        int army2Power = calculateArmyPower(this.hero2.getArmy());

        if (army1Power > army2Power) {
            return this.hero1;
        } else if (army1Power < army2Power) {
            return this.hero2;
        } else {
            return null;
        }
    }
}
