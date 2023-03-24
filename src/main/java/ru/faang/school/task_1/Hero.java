package ru.faang.school.task_1;

import ru.faang.school.task_1.Creatures.Creature;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Hero {
    private final String name;
    private final String fraction;
    private int level;
    private int xp;
    private List<Creature> army;

    public Hero(String name, String fraction, int level, int xp) {
        this.name = name;
        this.fraction = fraction;
        this.level = level;
        this.xp = xp;
    }

    public void addCreature(Creature creature){
        if (army == null){
            army = new LinkedList<>();
        }
        army.add(creature);
    }
    public void removeCreature(Creature creature){
        army.remove(creature);
    }
    public String getName() {
        return name;
    }

    public String getFraction() {
        return fraction;
    }

    public int getLevel() {
        return level;
    }

    public int getXp() {
        return xp;
    }

    public List<Creature> getArmy() {
        return army;
    }
}
