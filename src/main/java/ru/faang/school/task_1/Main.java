package ru.faang.school.task_1;

public class Main {
    public static void main(String[] args) {
        Creature pikeman = new Pikeman();
        Creature pikeman1 = new Pikeman();
        Hero hero = new Hero("Dimon", "Kraken", 3, 2);

        hero.addCreature(new Griffin(), 2);
        hero.addCreature(new Pikeman(), 1);
        hero.addCreature(new Swordman(), 3);
        hero.addCreature(new Griffin(), 5);
        hero.printInfoArmy();

        System.out.println(hero.getArmy().keySet());

//
//        hero.removeCreature(new Griffin(), 2);
//        System.out.println("==============");
//        hero.printInfoArmy();
//
//        hero.removeCreature(new Pikeman(), 2);
//        System.out.println("==============");
//        hero.printInfoArmy();
    }
}
