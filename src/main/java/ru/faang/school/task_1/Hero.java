package ru.faang.school.task_1;

import java.util.HashMap;

public class Hero {
    public Hero(String name, HashMap<Creature, Integer> army) {
        this.name = name;
        this.army = army;
    }

    String name;
    String fraction;
    int exp;
    int level;

    HashMap<Creature, Integer> army = new HashMap<>();

    void addCreature(Creature creature, int quantity){
        army.put(creature, quantity);
    }

    void removeCreature(Creature creature, int quantity){
        int oldNum = army.get(creature);
        army.put(creature, oldNum - quantity);
    }

    String getArmy(){
        String res = "";
        for(Creature creature : army.keySet()){
            res += creature.name + "\n ";
        }
        return res;
    }
}
