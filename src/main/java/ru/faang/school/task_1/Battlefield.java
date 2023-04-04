package ru.faang.school.task_1;

import ru.faang.school.task_1.heroes.Hero;
import ru.faang.school.task_1.heroes.Octavia;
import ru.faang.school.task_1.heroes.Strucker;
import ru.faang.school.task_1.models.Angel;
import ru.faang.school.task_1.models.Griffin;
import ru.faang.school.task_1.models.Pikeman;
import ru.faang.school.task_1.models.Swordman;

public class Battlefield {

    public void battle(Hero firstHero, Hero secondHero){
        Angel angel = new Angel();
        Griffin griffin = new Griffin();
        Pikeman pikeman = new Pikeman();
        Swordman swordman = new Swordman();
        firstHero.attackHero(secondHero, angel, griffin);
        secondHero.attackHero(firstHero, pikeman, swordman);
        firstHero.attackHero(secondHero, swordman, angel);
        secondHero.attackHero(firstHero, angel, swordman);
        System.out.println(firstHero.getArmy());
        System.out.println(secondHero.getArmy());
    }
}
