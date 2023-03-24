package ru.faang.school.task_1;

import ru.faang.school.task_1.Creatures.Creature;

import java.util.List;

public class Battlefield {
    public static Hero battle(Hero hero1, Hero hero2){
        List<Creature> firstArmy = hero1.getArmy();
        int firstArmyTotalDamage = 0;
        int firstArmyTotalDefence = 0;

        List<Creature> secondArmy = hero2.getArmy();
        int secondArmyTotalDamage = 0;
        int secondArmyTotalDefence = 0;

        for (Creature troop: firstArmy) {
            firstArmyTotalDamage += troop.getDamage() * troop.getCount();
            firstArmyTotalDefence += troop.getProtection() * troop.getCount();
        }

        for (Creature troop: secondArmy) {
            secondArmyTotalDamage += troop.getDamage() * troop.getCount();
            secondArmyTotalDefence += troop.getProtection() * troop.getCount();
        }

        if (firstArmyTotalDamage > secondArmyTotalDefence && firstArmyTotalDefence > secondArmyTotalDamage){
            return hero1;
        } else if(firstArmyTotalDamage < secondArmyTotalDefence && firstArmyTotalDefence < secondArmyTotalDamage){
            return hero2;
        } else {
            return null;
        }

    }
}
