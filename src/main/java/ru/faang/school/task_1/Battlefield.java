package ru.faang.school.task_1;

public class Battlefield {


    public Hero battle(Hero hero1, Hero hero2){
        // не совсем разбираюсь в лямбдах, но такие выражения видел в туториалах
        int power1 = hero1.getArmy().stream().mapToInt(e -> e.getDamage()).sum();

        int power2 = hero2.getArmy().stream().mapToInt(e -> e.getDamage()).sum();



        if (power1 > power2)
            return hero1;
        else
            return hero2;

    }



}
