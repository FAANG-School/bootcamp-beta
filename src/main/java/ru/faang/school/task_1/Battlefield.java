package ru.faang.school.task_1;

import ru.faang.school.task_1.creatures.*;

import java.util.ArrayList;
import java.util.List;

public class Battlefield {
    private Hero firstHero;
    private Hero secondHero;
    public Battlefield(Hero firstHero, Hero secondHero) {
        this.firstHero = firstHero;
        this.secondHero = secondHero;
    }
    public String battle(){
        try {
            if (diffBetweenLevels(firstHero.getLevel(), secondHero.getLevel())) {
                for (int i = 0; i < firstHero.getARMY().size() + secondHero.getARMY().size(); i++) {
                    if(firstHero.getARMY().size()>secondHero.getARMY().size() || secondHero.getARMY().isEmpty())
                        return firstHero.getName() + " is " + "winner!";
                    else if(firstHero.getARMY().size()==secondHero.getARMY().size()){
                        if(firstHero.getARMY().get(i).getDamage()>secondHero.getARMY().get(i).getDamage()){
                            return firstHero.getName() + " is " + "winner!";
                        }
                        else{
                            return secondHero.getName() + " is " + "winner!";
                        }
                    }
                    else{
                        return secondHero.getName() + " is " + "winner!";
                    }
                }
            } else {
                return "Difference between heroes too big! Fight is canceled!";
            }
        }catch (Exception e){
            e.getStackTrace();
        }
        return "";
    }

    private boolean diffBetweenLevels(int firstHeroLevel,int secondHeroLevel){
         if (Math.abs(firstHeroLevel-secondHeroLevel)<=10) return true;
         else return false;
    }

    public void fillFirstHeroArmy(){
            int quantityHero1 = (int) (Math.random()*10);
            firstHero.setARMY(randomListOfCreature(quantityHero1));
    }

    public void fillSecondHeroArmy(){
        int quantityHero2 = (int) (Math.random()*10);
        secondHero.setARMY(randomListOfCreature(quantityHero2));
    }

    private List<Creature> randomListOfCreature(int quantity){ // for example about 100 Angels
         List<Creature> randomCreatureList = new ArrayList<>();
        for(int i=0;i<quantity;i++) {
            int creatureNumber = (int) (Math.random() * 4);// ordinal number of creature, 1 - Angel, 2 - Griffin etc.
            if(creatureNumber==1) {
                Creature someCreature1 = new Angel();
                someCreature1.setAttack(20);
                someCreature1.setDefense(20);
                someCreature1.setName("Mercy");
                someCreature1.setLevel((int) (Math.random() * 7));
                someCreature1.setSpeed(12);
                someCreature1.setCreatureNumber(quantity);
                randomCreatureList.add(someCreature1);
            }
            else if(creatureNumber==2) {
                Creature someCreature2 = new Griffin();
                someCreature2.setAttack(8);
                someCreature2.setDefense(8);
                someCreature2.setName("Hippogriff");
                someCreature2.setLevel((int) (Math.random() * 7));
                someCreature2.setSpeed(6);
                someCreature2.setCreatureNumber(quantity);
                randomCreatureList.add(someCreature2);
            }

            else if(creatureNumber==3) {
                Creature someCreature3 = new Pikeman();
                someCreature3.setAttack(4);
                someCreature3.setDefense(5);
                someCreature3.setName("Pikey");
                someCreature3.setLevel((int) (Math.random() * 7));
                someCreature3.setSpeed(4);
                someCreature3.setCreatureNumber(quantity);
                randomCreatureList.add(someCreature3);
            }
            else if(creatureNumber==4) {
                Creature someCreature4 = new Swordman();
                someCreature4.setAttack(10);
                someCreature4.setDefense(12);
                someCreature4.setName("Jon Snow");
                someCreature4.setLevel((int) (Math.random() * 7));
                someCreature4.setSpeed(5);
                someCreature4.setCreatureNumber(quantity);
                randomCreatureList.add(someCreature4);
            }
        }
        return randomCreatureList;
    }
}
