package ru.faang.school.task_1.testMain;

import ru.faang.school.task_1.battle.Battlefield;
import ru.faang.school.task_1.hero.Creatures;
import ru.faang.school.task_1.hero.Fructions;
import ru.faang.school.task_1.hero.Hero;

public class TestMain {
    public static void main(String[] args){
        Hero hero1 = new Hero("Aragorn", Fructions.Humans, 10);
        Hero hero2 = new Hero("Legolas", Fructions.Elfs, 9);
        Hero hero3 = new Hero("Gimli", Fructions.Dwarfs, 8);
        Hero hero4 = new Hero("Ainz", Fructions.Undead, 15);

        hero1.addCreature(Creatures.Angels, 2);
        hero1.addCreature(Creatures.Pikermen, 2);
        hero1.addCreature(Creatures.Swordsmen, 2);

        hero2.addCreature(Creatures.Griffins, 3);
        hero2.addCreature(Creatures.Swordsmen, 4);

        hero3.addCreature(Creatures.Pikermen, 5);
        hero3.addCreature(Creatures.Swordsmen, 5);

        hero4.addCreature(Creatures.Griffins, 4);
        hero1.addCreature(Creatures.Swordsmen, 6);

        Battlefield battlefield1 = new Battlefield(hero1, hero2);
        Battlefield battlefield2 = new Battlefield(hero3, hero4);

        System.out.println("Battle between "+hero1.getName()+" and "+hero2.getName()+ " starts!\n\n");
        battlefield1.battle();
        System.out.println("\n\n\n");
        System.out.println("Battle between "+hero3.getName()+" and "+hero4.getName()+ " starts!\n\n");
        battlefield2.battle();
    }
}
