package ru.faang.school.task_1;

import java.util.List;

public class Battlefield {
    Hero battle(Hero h1, Hero h2) {
        List<Creature> armyFirst =  h1.getArmy();
        List<Creature> armySecond =  h2.getArmy();
        int healthArmyFirst = 0;
        int attackArmyFirst = 0;
        for(Creature c : armyFirst) {
            healthArmyFirst += c.health;
            attackArmyFirst += c.attack;
        }
        int healthArmySecond = 0;
        int attackArmySecond = 0;
        for(Creature c : armySecond) {
            healthArmyFirst += c.health;
            attackArmyFirst += c.attack;
        }
        if (healthArmySecond - attackArmyFirst < 0) {
            return h1;
        }
        else if (healthArmyFirst - attackArmySecond < 0) {
            return h2;
        }
        return null;
    }


}
