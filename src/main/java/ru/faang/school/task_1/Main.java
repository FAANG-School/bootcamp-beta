package ru.faang.school.task_1;

import ru.faang.school.task_1.creatures.CreatureType;

import static ru.faang.school.task_1.creatures.CreatureType.*;

public class Main {
    public static void main(String[] args) {
        Hero ragnar = new Hero("Ragnar", "Vikings");
        Hero william = new Hero("William Henry", "England");
        ragnar.addCreature(ANGEL, 14);
        ragnar.addCreature(SWORDSMAN, 85);
        william.addCreature(GRIFFIN, 30);
        william.addCreature(PIKEMAN, 145);

        Battlefield bf = new Battlefield(ragnar, william);
        Hero winner = bf.battle();
        System.out.println(winner);
    }
}
