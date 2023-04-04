package ru.faang.school;

import ru.faang.school.task_1.Battlefield;
import ru.faang.school.task_1.Heroes.Axe;
import ru.faang.school.task_1.Heroes.Hero;
import ru.faang.school.task_1.Heroes.Slark;
import ru.faang.school.task_1.creatures.Angel;
import ru.faang.school.task_1.creatures.Griffin;
import ru.faang.school.task_1.creatures.Swordman;

public class App {
    public static void main(String[] args) {

        Hero axe = new Axe();
        Hero slark = new Slark();

        Angel angel = new Angel();
        Griffin griffin = new Griffin();
        Swordman swordman = new Swordman();

        axe.addCreature(angel,3);
        axe.addCreature(griffin,5);
        axe.addCreature(swordman,2);

        slark.addCreature(angel,3);
        slark.addCreature(griffin,5);
        slark.addCreature(swordman,2);

        Battlefield battlefield = new Battlefield(axe,slark);
        battlefield.battle();
    }
}
