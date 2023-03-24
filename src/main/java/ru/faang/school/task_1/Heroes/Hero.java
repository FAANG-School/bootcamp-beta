package ru.faang.school.task_1.Heroes;

import ru.faang.school.task_1.creatures.Creature;

import java.util.ArrayList;
import java.util.List;

public abstract class Hero {

    private final String name;
    private final Fraction fraction;
    private  int experience;
    private final int lvl;
    private final List<Creature> army;

    public Hero(String name, Fraction fraction, int lvl) {
        this.name = name;
        this.fraction = fraction;
        this.lvl = lvl;
        army = new ArrayList<>();
    }

    public void addCreature(Creature creature, int quantity) {
        for (int i = 0; i < quantity; i++) {
            army.add(creature);
        }
    }

    public void removeCreature(Creature creature, int quantity) {
        for (int i = 0; i < quantity; i++) {
            if (!army.contains(creature)) break;
            army.remove(creature);
        }
    }

    public Fraction getFraction() {
        return fraction;
    }

    public int getExperience() {
        return experience;
    }

    public int getLvl() {
        return lvl;
    }

    public List<Creature> getArmy() {
        return army;
    }
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
