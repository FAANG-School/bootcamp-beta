package ru.faang.school.task_1;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Battlefield {
    public Battlefield(Hero hero1, Hero hero2) {
        this.hero1 = hero1;
        this.hero2 = hero2;
    }

    Hero hero1;
    Hero hero2;

    String battle(){
        int hero1Power = 0;
        for(Map.Entry<Creature, Integer> entry : hero1.army.entrySet()){
           hero1Power += entry.getValue();
        }
        int hero2Power = 0;
        for(Map.Entry<Creature, Integer> entry : hero2.army.entrySet()){
            hero2Power += entry.getValue();
        }

        int res = Integer.compare(hero1Power,hero2Power);
        switch (res){
            case 1 -> {
                return hero1.name;
            }
            case 0 -> {
                return "Draw!";
            }
            case -1 -> {
                return hero2.name;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        HashMap<Creature, Integer> hero1Army = new HashMap<>();
        hero1Army.put(new Griffin("Grif"), 100);
        Hero hero1 = new Hero("Oleg", hero1Army);
        HashMap<Creature, Integer> hero2Army = new HashMap<>();
        hero2Army.put(new Swordman("Sword"), 200);
        Hero hero2 = new Hero("Vlad", hero2Army);

        Battlefield battlefield = new Battlefield(hero1,hero2);
        System.out.println(battlefield.battle());
    }
}
