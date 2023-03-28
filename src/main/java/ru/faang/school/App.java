package ru.faang.school;

import ru.faang.school.task_1.*;

public class App {
    public static void main(String[] args) {


        Creature pikeman = new Pikeman();
        Creature griffin = new Griffin();
        Creature swordman = new Swordman();
        Creature angel = new Angel();


        Hero hero1 = new Hero("Max", "fraction1", 100, 18);
        Hero hero2 = new Hero("William", "fraction2", 110, 20);


        hero1.addCreature(pikeman, 25);
        hero1.addCreature(griffin, 15);
        hero1.addCreature(swordman, 15);
        hero1.addCreature(angel, 20);

        hero2.addCreature(pikeman, 20);
        hero2.addCreature(griffin, 17);
        hero2.addCreature(swordman, 12);
        hero2.addCreature(angel, 30);

        Battlefield bf = new Battlefield();

        System.out.println("Congrats! Winner: " + bf.battle(hero1, hero2));


    }
}
