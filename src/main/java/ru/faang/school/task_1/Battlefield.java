package ru.faang.school.task_1;

import ru.faang.school.task_1.creature.*;

import java.util.Set;

public class Battlefield {
    private Hero hero1;
    private Hero hero2;
    private Set<? extends Creature> hero1Army;
    private Set<? extends Creature> hero2Army;

    public Battlefield (Hero hero1, Hero hero2) {
        this.hero1 = hero1;
        this.hero2 = hero2;
        this.hero1Army = hero1.getArmy();
        this.hero2Army = hero2.getArmy();
    }

    public Hero battle() { // the formula is self-authored
        int hero1Damage = 0;
        int hero2Damage = 0;

        for (Creature unit : hero1Army) {
            hero1Damage += unit.getDamage();
        }
        hero1Damage *= hero1.getLevel() / 2 + 1;

        for (Creature unit : hero2Army) {
            hero2Damage += unit.getDamage();
        }
        hero2Damage *= hero2.getLevel() / 2 + 1;

        if (hero1Damage > hero2Damage) {
            return hero1;
        } else if (hero2Damage > hero1Damage) {
            return hero2;
        } else { // when heroDamages are even, winner is defined randomly
            if (Math.random() > 0.5) {
                return hero1;
            } else {
                return hero2; // hero2 has a slightly better chance, since they win if < 0.5 AND if == 0.5
            }
        }
    }
}
