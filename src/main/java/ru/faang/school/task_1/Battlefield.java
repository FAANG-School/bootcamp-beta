package ru.faang.school.task_1;


import ru.faang.school.task_1.creatures.Creature;

import java.util.List;
import java.util.Random;

public class Battlefield {
    private Hero firstHero;
    private Hero secondHero;

    public Battlefield(Hero firstHero, Hero secondHero) {
        this.firstHero = firstHero;
        this.secondHero = secondHero;
    }

    public Hero battle() {

        System.out.println("First army before battle " + firstHero.getArmy().size());
        System.out.println("Second army before battle " +secondHero.getArmy().size());

        int step = 0;
        while (!firstHero.isArmyDefeat()||!secondHero.isArmyDefeat()){
            oneMove(firstHero, secondHero);
            oneMove(secondHero, firstHero);
            System.out.println("First army at step " + step + firstHero.getArmy().size());
            System.out.println("Second army step " + step +secondHero.getArmy().size());
            step++;
        }

        System.out.println("First army after battle " + firstHero.getArmy().size());
        System.out.println("Second army after battle " +secondHero.getArmy().size());


        return firstHero.isArmyDefeat()?secondHero:firstHero;
    }

    private Creature getRandomCreature (List<Creature> creatureList){
        int randomIndex = (int) Math.random()*(creatureList.size()+1);
        return creatureList.get(randomIndex);
    }

    private void oneMove(Hero first, Hero second){
        Creature firstHeroCreature = getRandomCreature(first.getArmy());
        Creature secondHeroCreature = getRandomCreature(second.getArmy());


        int totalAttackPowerOfFirstCreature = firstHeroCreature.getAttackPower() * firstHeroCreature.getQuantity();
        int totalArmorOfSecondCreature = secondHeroCreature.getArmor() * secondHeroCreature.getQuantity();

        second.removeCreature(secondHeroCreature, (totalArmorOfSecondCreature-totalAttackPowerOfFirstCreature)/secondHeroCreature.getQuantity());

    }



}
