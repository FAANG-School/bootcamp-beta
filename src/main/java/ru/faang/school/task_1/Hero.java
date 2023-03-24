package ru.faang.school.task_1;

import ru.faang.school.task_1.creatures.Creature;


import java.util.*;

public class Hero {
    private String name;
    private Faction faction;
    private int experience;
    private int level;
    private final List<Creature> creatureList = new ArrayList<>();

    public Hero(String name, Faction faction, int experience, int level) {
        this.name = name;
        this.faction = faction;
        this.experience = experience;
        this.level = level;
    }

    public void addCreature (Creature creature, int quantity){
        boolean isHavingCreature = false;
        for (Creature creatureOfHero : creatureList){
            if (creatureOfHero.getName().equals(creature.getName())){
                creatureOfHero.setQuantity(creatureOfHero.getQuantity()+creature.getQuantity());
                isHavingCreature =true;
            }
        }
        if(!isHavingCreature){
            creature.setQuantity(quantity);
            creatureList.add(creature);
        }
    }

    public void removeCreature (Creature creature, int quantity){
        boolean isHavingCreature = false;
        for (Creature creatureOfHero : creatureList){
            if (creatureOfHero.getName().equals(creature.getName())){
                if (creatureOfHero.getQuantity() > quantity){
                    creatureOfHero.setQuantity(creatureOfHero.getQuantity()-creature.getQuantity());
                }
                else {
                    creatureOfHero.setQuantity(0);
                }
                isHavingCreature =true;
            }
        }
        if(!isHavingCreature){
            throw new IllegalArgumentException("Hero haven't this type of creature in his army");
        }

    }

    public List<Creature> getArmy(){
        return creatureList;
    }

    @Override
    public String toString() {
        return "Hero named " + name;
    }
}
