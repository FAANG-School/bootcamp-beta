package ru.faang.school.task_1;

import ru.faang.school.task_1.classes.creatures.Angel;
import ru.faang.school.task_1.classes.hero.Hero;
import ru.faang.school.task_1.classes.util.Battlefield;
import ru.faang.school.task_1.classes.util.Fraction;

public class App {
    public static void main(String[] args) {
        Hero blueHero = new Hero("Rustam", Fraction.INFERNO, 100, 2);
        Hero redHero = new Hero("Vlad", Fraction.STRONGHOLD, 10000, 999);
        blueHero.addCreature(new Angel(), 1 );

        redHero.addCreature(new Angel(), 1);

        Battlefield battlefield = new Battlefield(blueHero, redHero);
        battlefield.battle();
    }
}
