package ru.faang.school;

import ru.faang.school.task_1.*;

public class App {
    public static void main(String[] args) {
        Hero hero1 = new Hero("Roland", "Castle", 0, 1);
        Hero hero2 = new Hero("Mutare", "Dungeon", 0, 1);
        hero1.addCreature(new Pikeman(10), 10);
        hero1.addCreature(new Griffin(5), 5);
        hero1.addCreature(new Swordman(3), 3);

        hero2.addCreature(new Pikeman(12), 12);
        hero2.addCreature(new Griffin(7), 7);
        hero2.addCreature(new Angel(1), 1);

        Battlefield battlefield = new Battlefield(hero1, hero2);
        Hero winner = battlefield.battle();

        if (winner != null) {
            System.out.println("The winner is " + winner.getName() + " from " + winner.getFraction() + " fraction");
        } else {
            System.out.println("It's a tie");
        }
    }
}
