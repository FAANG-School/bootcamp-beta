package ru.faang.school.task_1;

import ru.faang.school.task_1.creature.*;

public class HeroesOfMightAndMagicThree {
    public static void main(String[] args) { // as of this version, only the Castle faction is available
        Hero christian = new Hero("Christian", "Castle", 2000);
        Hero sorsha = new Hero("Sorsha", "Castle", 3500);

        Creature hero1pikemen = new Pikeman();
        Creature hero1griffins = new Griffin();
        Creature hero1swordsmen = new Swordsman();

        Creature hero2pikemen = new Pikeman();
        Creature hero2griffins = new Griffin();
        Creature hero2angels = new Angel();

        christian.addCreature(hero1pikemen, 80);
        christian.addCreature(hero1griffins, 15);
        christian.addCreature(hero1swordsmen, 40);

        sorsha.addCreature(hero2pikemen, 60);
        sorsha.addCreature(hero2griffins, 25);
        sorsha.addCreature(hero2angels, 5);
        sorsha.removeCreature(hero2angels, 1);

        Battlefield battlefield = new Battlefield(christian, sorsha);
        System.out.println(battlefield.battle());
    }
}
