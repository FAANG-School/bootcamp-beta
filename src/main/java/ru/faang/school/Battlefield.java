package ru.faang.school;

import java.util.ArrayList;

public class Battlefield {
    //создаем героев
   private Hero hero1;
   private Hero hero2;

    public Battlefield(Hero hero1, Hero hero2) {
        this.hero1 = hero1;
        this.hero2 = hero2;
    }
//конструктор для имитации битвы с возвращением победителя
    public Hero battle() {

        int army1Strength = calculateArmyStrength(hero1.getArmy());
        int army2Strength = calculateArmyStrength(hero2.getArmy());

        if (army1Strength > army2Strength) {
            return hero1;
        } else if (army1Strength < army2Strength) {
            return hero2;
        } else {
            return null;
        }
    }
//калькулятор для подсчёта силы армии
    private int calculateArmyStrength(ArrayList<Creature> army) {

        int armyStrength = 0;

        for (Creature creature : army) {
            armyStrength += creature.getPower();
        }

        return armyStrength;
    }
}

