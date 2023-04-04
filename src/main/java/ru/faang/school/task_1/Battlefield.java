package ru.faang.school.task_1;

import java.util.List;

public class Battlefield {
   private Hero firstHero;
    private Hero secondHero;

    public Battlefield(Hero firstHero, Hero secondHero) {
        this.firstHero = firstHero;
        this.secondHero = secondHero;
    }

    public Hero battle() {
        List<Creature> firstHeroArmy = firstHero.getArmy();
        List<Creature> secondHeroArmy = secondHero.getArmy();
        while (secondHeroArmy.size() != 0 && firstHeroArmy.size() != 0) {
            return firstHero;
        }
        return secondHero;
    }
}
