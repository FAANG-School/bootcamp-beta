package ru.faang.school.task_1;

import ru.faang.school.task_1.classes.creatures.Pikeman;
import ru.faang.school.task_1.classes.creatures.Swordman;
import ru.faang.school.task_1.classes.hero.Hero;
import ru.faang.school.task_1.classes.util.Fraction;

public class App {
    public static void main(String[] args) {
        Hero hero1 = new Hero("Рустам", Fraction.STRONGHOLD, 20, 1);
        hero1.addCreature(new Pikeman(), 20);
        hero1.getArmyToString();
        hero1.removeCreature(new Pikeman(), 21);
        hero1.getArmyToString();
    }
}
