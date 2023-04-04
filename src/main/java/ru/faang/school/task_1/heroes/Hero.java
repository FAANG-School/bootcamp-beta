package ru.faang.school.task_1.heroes;

import ru.faang.school.task_1.models.*;

import java.util.ArrayList;
import java.util.List;

public class Hero {
    private String name;
    private String fraction;
    private int level;
    private int experience;
    List<Creature> army = new ArrayList<>();

    public Hero(String name, String fraction, int level) {
        this.name = name;
        this.fraction = fraction;
        this.level = level;
    }

    public void attackHero(Hero hero, Creature enemyCreature, Creature myCreature){
        double attack = myCreature.attack(enemyCreature);
        if (attack <= 0){
            removeCreature(enemyCreature, 1);
            myCreature.creatureLevelUp();
            heroLevelUp();
        }
    }

    public void heroLevelUp(){
        level += 1;
    }

    public void addCreature(Creature creature, int quantity){
        for (int i = 0; i < quantity; i++) {
            army.add(creature);
        }
    }

    public void removeCreature(Creature creature, int quantity){
        army.remove(creature);
    }

    public List<Creature> getArmy() {
        return army;
    }

    @Override
    public String toString() {
        return name;
    }
}
