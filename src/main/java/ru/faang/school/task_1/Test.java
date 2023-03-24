package ru.faang.school.task_1;

import ru.faang.school.task_1.creatures.*;

import java.util.HashSet;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        Hero hero1 = new Hero("Hero1", Faction.GOOD_GUYS, 1000, 1);
        Hero hero2 = new Hero("Hero2", Faction.BAD_GUYS, 1000, 1);

        hero1.addCreature(new Angel(), 1);
        hero1.addCreature(new Griffin(), 1);
        hero1.addCreature(new Pikeman(), 1);
        hero1.addCreature(new Swordman(),1);

        hero2.addCreature(new Angel(), 10);
        hero2.addCreature(new Griffin(), 10);
        hero2.addCreature(new Pikeman(), 10);
        hero2.addCreature(new Swordman(),10);

        Battlefield battlefield = new Battlefield(hero1, hero2);
        Hero winner = battlefield.battle();
        System.out.println("WINNER IS:");
        System.out.println(winner);


    }
}
