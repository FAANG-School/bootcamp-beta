package ru.faang.school.task_1;
import ru.faang.school.task_1.Hero.Hero;

public class Battlefield {
    private final Hero firstHero;
    private final Hero secondHero;


    public Battlefield(Hero firstHero, Hero secondHero){
        this.firstHero = firstHero;
        this.secondHero = secondHero;
    }

    public Hero battle(){
        for (int i = 1; firstHero.getArmySize() > 0 && secondHero.getArmySize() > 0; i++) {

            if (i % 2 == 0) {
                firstHero.getRandomCreature().takeDamage(firstHero, secondHero.getRandomCreature());
            }
            else {
                secondHero.getRandomCreature().takeDamage(secondHero, firstHero.getRandomCreature());
            }
        }
        if (firstHero.getArmySize() == 0){
           return winner(secondHero);
        }
        else { return winner(firstHero);}

    }


    private Hero winner(Hero hero){
        hero.levelUp();
        return hero;
    }





}
