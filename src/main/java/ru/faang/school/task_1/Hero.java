package ru.faang.school.task_1;

import java.util.ArrayList;
import java.util.List;

public class Hero {

    String name;
    String fraction;
    int xp;
    int level;

    public Hero(String name, String fraction, int xp, int level) {
        this.name = name;
        this.fraction = fraction;
        this.xp = xp;
        this.level = level;
    }

    public Hero(String name) {
        this.name = name;
    }

    List<Creature> army = new ArrayList<>();

    public void addCreature(Creature creature, int quantity){
        for (int i = 0; i < quantity; i++ ){
            army.add(creature);
        }
    }
    public void removeCreature(Creature creature, int quantity){
        for (int i = 0; i < quantity; i++ ){
            army.remove(creature);
        }
    }

    public List<Creature> getArmy() {
        return army;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                '}';
    }
}
