package main.java.ru.faang.school.task_1;


import main.java.ru.faang.school.task_1.Creature.Creature;

import java.util.stream.Collectors;

public class Battlefield {
    private Hero hero1;
    private Hero hero2;

    public Battlefield(Hero hero1,Hero hero2){
        this.hero1=hero1;
        this.hero2=hero2;
    }
    protected Hero battle(){
        int firstHeroDamage=getTotalDamage(hero1);
        int secondHeroDamage=getTotalDamage(hero2);
        int firstHeroDefence=getTotalDefence(hero1);
        int secondHeroDefence=getTotalDefence(hero2);
        System.out.println(firstHeroDamage+firstHeroDefence+secondHeroDefence+secondHeroDamage);
        if (firstHeroDamage-secondHeroDefence>secondHeroDamage-firstHeroDefence){
            return hero1;
        }else{
            return hero2;
        }
    }
    protected static int getTotalDamage(Hero hero){
        int damage=0;
        for (Creature creature: hero.getArmy()){
            damage+=creature.getDamage()*creature.getQuantity();
        }
        return damage;
    }
    protected static int getTotalDefence(Hero hero){
        int defence=0;
        for (Creature creature: hero.getArmy()){
            defence+=creature.getArmor()*creature.getQuantity();
        }
        return defence;
    }
}
