package ru.faang.school.task_1.core.utils;

import ru.faang.school.task_1.creature.lords.Hero;
import ru.faang.school.task_1.creature.warriors.Creature;

import java.util.Map;

public class BattleCalculator {

    public Integer calculateArmyDamage(Hero hero) {
        Map<Creature, Integer> army = hero.getArmy();
        int globalDamage = 0;
        for (Creature creature : army.keySet()) {
            globalDamage += creature.getDamage() * army.get(creature);
        }
        return globalDamage;
    }

    public Integer calculateArmyHP(Hero hero) {
        Map<Creature, Integer> army = hero.getArmy();
        int globalHelthPoint = 0;
        for (Creature creature : army.keySet()) {
            globalHelthPoint += creature.getProtectLevel() * army.get(creature);
        }
        return globalHelthPoint;
    }

    public Integer calculateArmySpeed(Hero hero) {
        Map<Creature, Integer> army = hero.getArmy();
        int globalSpeed = 0;
        for (Creature creature : army.keySet()) {
            globalSpeed += creature.getSpeed() * army.get(creature);
        }
        return globalSpeed;
    }

    public Double calculateLiquidDamage(Integer hero1Speed, Integer hero2Speed) {
        double speedRatio = (double) hero1Speed / hero2Speed;
        return Math.exp(Math.random() * speedRatio);
    }

}
