package ru.faang.school.task_1.core.battle;

import ru.faang.school.task_1.core.utils.BattleCalculator;
import ru.faang.school.task_1.creature.lords.Hero;

public class BattleFilled {
    private final BattleCalculator battleCalculator = new BattleCalculator();

    public Hero battle(Hero hero1, Hero hero2) {
        int hero1HP = battleCalculator.calculateArmyHP(hero1);
        int hero1Speed = battleCalculator.calculateArmySpeed(hero1);
        int hero2HP = battleCalculator.calculateArmyHP(hero2);
        int hero2Speed = battleCalculator.calculateArmySpeed(hero2);
        Hero winner = null;
        while (hero1HP > 0 && hero2HP > 0) {
                hero2HP -= this.armyAttack(hero1, hero1Speed, hero2Speed);
                if (hero2HP <= 0) winner = hero1;
                hero1HP -= this.armyAttack(hero2, hero2Speed, hero1Speed);
                if (hero1HP <= 0) winner = hero2;
        }
        return winner;
    }

    private int armyAttack(Hero hero, int heroSpeed, int hero2Speed) {
        double damageCoefficient = battleCalculator.calculateLiquidDamage(heroSpeed, hero2Speed);
        double damage = battleCalculator.calculateArmyDamage(hero) - damageCoefficient;
        return (int) damage;
    }
}
