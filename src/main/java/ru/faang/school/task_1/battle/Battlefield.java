package ru.faang.school.task_1.battle;

import ru.faang.school.task_1.hero.Hero;
import ru.faang.school.task_1.units.Creature;

public class Battlefield {
    Hero firstHero;
    Hero secondHero;

    public Battlefield(Hero firstHero, Hero secondHero) {
        this.firstHero = firstHero;
        this.secondHero = secondHero;
    }

    public void battle(){
        int[] firstHeroParams = getHeroParams(firstHero);
        int[] secondHeroParams = getHeroParams(secondHero);

        int firstHeroEndStatus = firstHeroParams[1]+firstHeroParams[2]-secondHeroParams[0];
        int secondHeroEndStatus = secondHeroParams[1]+secondHeroParams[2]-firstHeroParams[0];

        if(firstHeroEndStatus>secondHeroEndStatus){
            System.out.println("Hero "+ firstHero.getName()+" from fruction '"+firstHero.getFruction()+"' wins!");
        } else if(firstHeroEndStatus<secondHeroEndStatus){
            System.out.println("Hero "+ secondHero.getName()+" from fruction '"+secondHero.getFruction()+"' wins!");
        } else {
            System.out.println("Dead heat!");
        }
    }

    int[] getHeroParams(Hero hero){
        int finalDamage = 0;
        int finalHp = 0;
        int finalDefence = 0;
        for(Creature c: hero.getArmy()){
            finalDamage+=c.getDamage()*c.getCount();
            finalHp+=c.getHp()*c.getCount();
            finalDefence+=c.getDefence()*c.getCount();
        }
        return new int[]{finalDamage,finalHp,finalDefence};
    }
}
