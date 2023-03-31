package ru.faang.school.task_1;

import java.util.Random;

public class Battlefield {
    public Battlefield(Hero hero1, Hero hero2) {
        this.hero1 = hero1;
        this.hero2 = hero2;
    }

    Hero hero1;
    Hero hero2;

    String battle(){
        int scoreFirst = 0;

        scoreFirst += hero1.army.get(new Swordman()).compareTo(hero2.army.get(new Swordman()));
        scoreFirst += hero1.army.get(new Angel()).compareTo(hero2.army.get(new Angel()));
        scoreFirst += hero1.army.get(new Griffin()).compareTo(hero2.army.get(new Griffin()));
        scoreFirst += hero1.army.get(new Pikeman()).compareTo(hero2.army.get(new Pikeman()));
        if (scoreFirst > 0){
            return hero1.name;
        } else if (scoreFirst == 0) {
            Random rand = new Random();
            int res = rand.nextInt(2);
            switch (res){
                case 0 -> {
                    return hero1.name;
                }
                case 1 -> {
                    return hero2.name;
                }
            }
        } else if (scoreFirst < 0){
            return hero2.name;
        }
        return null;
    }
}
