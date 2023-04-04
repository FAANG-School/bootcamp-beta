package ru.faang.school;

import ru.faang.school.task_1.model.Battlefield;
import ru.faang.school.task_1.model.Faction;
import ru.faang.school.task_1.model.Hero;
import ru.faang.school.task_1.model.creatures.*;

public class App {
    public static void main(String[] args) {
        Hero hero1 = new Hero("hero1", Faction.CASTLE, 1000, 1);
        Hero hero2 = new Hero("hero2", Faction.CASTLE, 1000, 1);

        Creature angel = new Angel();
        Creature griffin = new Griffin();
        Creature pikeman = new Pikeman();
        Creature swordsman = new Swordman();

        hero1.addCreature(angel, 10);

        hero2.addCreature(griffin, 10);
        hero2.addCreature(swordsman, 5);
        hero2.addCreature(pikeman, 30);

        Battlefield battlefield = new Battlefield(hero1, hero2);
        Hero battleWinner = battlefield.battle();

        System.out.println(battleWinner.getName());
    }
}
