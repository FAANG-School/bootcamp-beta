package ru.faang.school.task_1;

public class Test {
    static Battlefield battlefield = new Battlefield();

    public static void main(String[] args) throws InterruptedException {
        Hero blueHero = new Hero("Nila", "Tower", 1);
        Hero redHero = new Hero("Shiva", "Citadel", 1);

        Creature blueSquad1 = new Angel();
        Creature blueSquad2 = new Griffin();
        Creature blueSquad3 = new Swordman();
        Creature blueSquad4 = new Pikeman();

        Creature redSquad1 = new Griffin();
        Creature redSquad2 = new Pikeman();
        Creature redSquad3 = new Angel();

        blueHero.addCreature(blueSquad1, 1);
        blueHero.addCreature(blueSquad2, 5);
        blueHero.addCreature(blueSquad3, 9);
        blueHero.addCreature(blueSquad4, 5);

        redHero.addCreature(redSquad1, 3);
        redHero.addCreature(redSquad2, 4);
        redHero.addCreature(redSquad3, 8);

        battlefield.battle(blueHero, redHero);
    }

}
