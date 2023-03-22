package ru.faang.school;

import ru.faang.school.task_1.battlefield.Battlefield;
import ru.faang.school.task_1.creature.Angel;
import ru.faang.school.task_1.creature.Griffin;
import ru.faang.school.task_1.creature.Pikeman;
import ru.faang.school.task_1.creature.Swordsman;
import ru.faang.school.task_1.hero.Hero;

public class App {
    public static void main(String[] args) throws InterruptedException {
        Hero player1 = new Hero("Grindelwald", "Dark side", 0, 0);

        Hero player2 = new Hero("Anakin", "Light side", 0, 0);

        player1.addCreature(new Griffin(300, 2), 300);
        player1.addCreature(new Pikeman(100, 1), 100);

        player2.addCreature(new Angel(200, 2), 200);
        player2.addCreature(new Swordsman(200, 2), 200);

        Battlefield battlefield = new Battlefield(player1, player2);
        battlefield.battle();
    }
}
