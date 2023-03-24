package ru.faang.school.task_1;

import ru.faang.school.task_1.Creatures.Angel;
import ru.faang.school.task_1.Creatures.Creature;
import ru.faang.school.task_1.Creatures.Griffin;

public class main {
    public static void main(String[] args){
        Hero hero1 = new Hero("TestHero1", "TestFraction", 1, 1);
        Hero hero2 = new Hero("TestHero2", "TestFraction", 1, 1);
        hero1.addCreature(new Angel(1));
        hero1.addCreature(new Griffin(1000));
        hero1.addCreature(new Griffin(12));
        hero2.addCreature(new Angel(2));
        System.out.println(String.format("%s army:", hero1.getName()));
        for (Creature troop: hero1.getArmy()) {
            System.out.println(String.format("Troop name: %s, Count: %s", troop.getName(), troop.getCount()));
        }
        System.out.println(String.format("%s army:", hero2.getName()));
        for (Creature troop: hero2.getArmy()) {
            System.out.println(String.format("Troop name: %s, Count: %s", troop.getName(), troop.getCount()));
        }
        System.out.println("Battle starts!");
        System.out.println("Battle winner: " + Battlefield.battle(hero1, hero2).getName());
    }


}
