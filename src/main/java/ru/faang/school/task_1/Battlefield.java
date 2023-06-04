package ru.faang.school.task_1;

import java.util.Map;

public class Battlefield {
    private Hero heroOne;
    private Hero heroTwo;
    public Battlefield(Hero heroOne, Hero heroTwo) {
        this.heroOne = heroOne;
        this.heroTwo = heroTwo;

    }
    public Hero battle() {
        System.out.println("The battle begins...");
        double diffFirstArmy = heroOne.getPowerOfArmy() - heroTwo.getDefenseOfArmy();
        double diffSecondArmy = heroTwo.getPowerOfArmy() - heroOne.getDefenseOfArmy();

        Hero winner = diffFirstArmy >= diffSecondArmy ? heroOne : heroTwo;
        System.out.println("The battle finished!");
        return winner;
    }
}
