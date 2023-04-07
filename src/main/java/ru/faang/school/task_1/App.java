package ru.faang.school.task_1;

import ru.faang.school.task_1.Entities.*;

public class App {
    public static void main(String[] args) {
        Hero h1 = new Hero("Hero1", "frac1");
        Hero h2 = new Hero("Hero2", "frac2");
        Hero h3 = new Hero("Hero3", "frac3");

        h1.addCreature(new Angel(), 5);
        h1.addCreature(new Swordman(), 1);
        h1.addCreature(new Pikeman(), 2);
        h1.addCreature(new Griffin(), 4);

        h2.addCreature(new Angel(), 1);
        h2.addCreature(new Swordman(), 1);
        h2.addCreature(new Pikeman(), 1);
        h2.addCreature(new Griffin(), 1);

        h3.addCreature(new Angel(), 2);
        h3.addCreature(new Swordman(), 2);
        h3.addCreature(new Pikeman(), 2);
        h3.addCreature(new Griffin(), 3);

        Battlefield battle1 = new Battlefield(h1, h2);
        Battlefield battle2 = new Battlefield(h1, h3);

        battle1.battle();
        battle2.battle();
    }
}
