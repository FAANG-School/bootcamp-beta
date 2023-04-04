package ru.faang.school.task_1;

import ru.faang.school.task_1.Heroes.Hero;
import ru.faang.school.task_1.creatures.Creature;

public class Battlefield {

    private Hero hero1;
    private Hero hero2;

    public Battlefield(Hero hero1, Hero hero2) {
        this.hero1 = hero1;
        this.hero2 = hero2;
    }

    public void battle() {
        double hero1Hp = heroHp(hero1);
        double hero2Hp = heroHp(hero2);


        while (true) {
            hero1Hp -= (heroDamageOnePerRound(hero2) * (1 + hero2.getLvl() * 0.1)) * heroArmor(hero1);
            hero2Hp -= (heroDamageOnePerRound(hero1) * (1 + hero1.getLvl() * 0.1)) * heroArmor(hero2);

            if (hero1Hp <= 0 & hero2Hp <= 0) {
                System.out.println("Ничья");
                break;
            } else if (hero1Hp <= 0) {
                System.out.println("Победил " + hero2);
                break;
            } else if (hero2Hp <= 0){
                System.out.println("Победил " + hero1);
                break;
            }
        }
    }

    private int heroDamageOnePerRound(Hero hero) {
        int sumDamage = 0;
        for (Creature creature : hero.getArmy()) {
            sumDamage += creature.getDamage();
        }
        return sumDamage;
    }

    private double heroHp(Hero hero) {
        double sumHp = 0.0;
        for (Creature creature : hero.getArmy()) {
            sumHp += creature.getCountHp();
        }
        return sumHp;
    }

    private double heroArmor(Hero hero) {
        double sumArmor = 0;
        for (Creature creature : hero.getArmy()) {
            sumArmor += creature.getArmor();
        }
        return sumArmor;
    }
}
