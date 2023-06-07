package ru.faang.school.task_1.classes.util;

import ru.faang.school.task_1.classes.creatures.Creature;
import ru.faang.school.task_1.classes.hero.Hero;

import java.util.List;

public class Battlefield {
    private final Hero blueHero;
    private final Hero redHero;
    List<Creature> firstArmy;
    List<Creature> secondArmy;

    public void battle() {
        if (choiceHero() % 2 == 0) {
            setupArmy(blueHero.getArmy(), redHero.getArmy());
        } else {
            setupArmy(redHero.getArmy(), blueHero.getArmy());
        }
        while (!firstArmy.isEmpty() && !secondArmy.isEmpty()) {
            Creature creatureFirstArmy = getCreature(firstArmy);
            Creature creatureSecondArmy = getCreature(secondArmy);
            fight(creatureFirstArmy, creatureSecondArmy);
        }

        if (secondArmy.isEmpty() && firstArmy.isEmpty()) {
            System.out.println("Победила дружба");
        }
        if (secondArmy.isEmpty()) {
            System.out.println(blueHero.getNAME() + " победил!");
        } else {
            System.out.println(redHero.getNAME() + " победил!");
        }
    }

    private int choiceHero() {
        int min = 0;
        int max = 100;
        return min + (int) (Math.random() * max);
    }

    private void setupArmy(List<Creature> firstArmy, List<Creature> secondArmy) {
        this.firstArmy = firstArmy;
        this.secondArmy = secondArmy;
    }

    private Creature getCreature(List<Creature> army) {
        return army.get((int) Math.round(0 + Math.random() * (army.size() - 1)));
    }

    private void fight(Creature firstCreature, Creature secondCreature) {
        int firstCreatureDamage = 1 + (int) Math.floor((double) firstCreature.getDamage() / (secondCreature.getArmor() * Math.random()));
        int secondCreatureDamage = 1 + (int) Math.floor((double) secondCreature.getDamage() / (firstCreature.getArmor() * Math.random()));
        secondCreature.setHealth(secondCreature.getHealth() - firstCreatureDamage);
        if (secondCreature.getHealth() > 0) {
            firstCreature.setHealth(firstCreature.getHealth() - secondCreatureDamage);
        } else {
            for (int i = 0; i < secondArmy.size(); i++) {
                if (secondArmy.get(i).equals(secondCreature)) {
                    if (secondArmy.get(i).getQuantity() == 1) {
                        secondArmy.remove(secondCreature);
                    } else {
                        secondArmy.get(i).setQuantity(-1);
                    }
                }
            }
        }

        if (firstCreature.getHealth() <= 0) {
            for (int i = 0; i < firstArmy.size(); i++) {
                if (firstArmy.get(i).equals(firstCreature)) {
                    if (firstArmy.get(i).getQuantity() == 1) {
                        firstArmy.remove(firstCreature);
                    } else {
                        firstArmy.get(i).setQuantity(-1);
                    }
                }
            }
        }
    }

    public Battlefield(Hero blueHero, Hero redHero) {
        this.blueHero = blueHero;
        this.redHero = redHero;
    }
}
