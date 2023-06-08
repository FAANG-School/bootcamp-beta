package ru.faang.school.task_1;

import java.util.ArrayList;

public class Battlefield {


    public static void main(String[] args) {

        Hero valeska = new Hero("Валеска", "Замок");
        Hero tazar = new Hero("Тазар", "Крепость");

        Creature pikeman = new Pikeman();
        Creature griffin= new Griffin();
        Creature swordman= new Swordman();
        Creature angel = new Angel();

        valeska.addCreature(pikeman,20);
        valeska.addCreature(griffin,30);
        valeska.addCreature(swordman,15);
        valeska.addCreature(angel,5);

        tazar.addCreature(angel,1);

        Battlefield battlefield = new Battlefield();

        System.out.println("Winner: " + battlefield.battle(valeska,tazar).getHeroName());
        
    }


    public Hero battle(Hero hero1,Hero hero2){

        ArrayList<Creature> armyHero1 = hero1.getArmy();
        ArrayList<Creature> armyHero2 = hero2.getArmy();


        while (!armyHero1.isEmpty() && !armyHero2.isEmpty()) {

            Creature creature1 = armyHero1.get(0);
            Creature creature2 = armyHero2.get(0);

            int damage1 = creature2.currentHealth() - creature1.getDamage();
            int damage2 = creature1.currentHealth() - creature2.getDamage();
            
            if (creature1.currentHealth()-damage1 <= 0) {
                armyHero1.remove(0);
            }
            if (creature2.currentHealth()-damage2 <= 0) {
                armyHero2.remove(0);
            }
        }

        if (armyHero1.isEmpty()) {
            return hero2;
        } else {
            return hero1;
        }
    }
}
