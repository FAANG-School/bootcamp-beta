package ru.faang.school.task_1;

import java.util.HashMap;
import java.util.Map;

public class Hero {
    private String name;
    private String fraction;
    private int experience;
    private int level;

    private Map<Creature, Integer> army = new HashMap<>();

    public Hero(String name, String fraction, int experience, int level) {
        this.name = name;
        this.fraction = fraction;
        this.experience = experience;
        this.level = level;
    }

    public void addCreature(Creature creature, int quantity){
            army.put(creature, quantity);
    }

    public void removeCreature(Creature creature, int quantity){
            army.put(creature, army.get(creature)-quantity);
    }

    public Map<Creature, Integer> getArmy() {
        return army;
    }

    public void createArmy(){
        addCreature(new Angel(), (int) (Math.random()*10));
        addCreature(new Griffin(), (int) (Math.random()*10));
        addCreature(new Pikeman(), (int) (Math.random()*10));
        addCreature(new Swordman(), (int) (Math.random()*10));
    }

    @Override
    public String toString() {
        return "Hero " +
                "name='" + name + '\'' +
                " from fraction '" + fraction + '\'' +
                " with experience " + experience +
                " and level " + level +
                " has army= " + army;
    }

    public String getName() {
        return name;
    }
}
