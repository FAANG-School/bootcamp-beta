package ru.faang.school.task_1.hero;

import ru.faang.school.task_1.units.*;

import java.util.ArrayList;
import java.util.List;

public class Hero {
    String name;
    Fructions fruction;
    int level;
    List<Creature> army = new ArrayList<>();

    public void addCreature(Creatures creature, int n){
        switch (creature){
            case Angels -> {
                int currentCount = army.get(0).getCount();
                army.get(0).setCount(currentCount+n);
            }
            case Griffins -> {
                int currentCount = army.get(1).getCount();
                army.get(1).setCount(currentCount+n);
            }
            case Pikermen -> {
                int currentCount = army.get(2).getCount();
                army.get(2).setCount(currentCount+n);
            }
            case Swordsmen -> {
                int currentCount = army.get(3).getCount();
                army.get(3).setCount(currentCount+n);
            }
        }
    }

    public Hero(String name, Fructions fruction, int level) {
        this.name = name;
        this.fruction = fruction;
        this.level = level;
        army.add(new Angel());
        army.add(new Griffin());
        army.add(new Pikerman());
        army.add(new Swordsman());
    }

    public String getName() {
        return name;
    }

    public Fructions getFruction() {
        return fruction;
    }

    public int getLevel() {
        return level;
    }

    public List<Creature> getArmy() {
        return army;
    }
}
