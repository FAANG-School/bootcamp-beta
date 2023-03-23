package ru.faang.school.task_1;

import ru.faang.school.task_1.creatures.Creature;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Hero {
    private String name;
    private Faction faction;
    private int experience;
    private int level;
    final private List<Creature> creatureList = new LinkedList<>();

    public void addCreature (Creature creature, int quantity){
        for (int i = 0; i < quantity; i++) {
            creatureList.add(creature);
        }
    }

    public void removeCreature (Creature creature, int quantity){
            for (int i = 0; i < quantity; i++) {
                creatureList.remove(creature);
            }
    }

    public List<Creature> getArmy(){
        return creatureList;
    }


}
