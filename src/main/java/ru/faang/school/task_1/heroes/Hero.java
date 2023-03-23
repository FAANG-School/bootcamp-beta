package ru.faang.school.task_1.heroes;

import ru.faang.school.task_1.creatures.Creature;

import java.util.LinkedList;
import java.util.List;

public class Hero {

    private final String name;
    private final Fraction fraction;
    private final int experience;
    private final int level;
    private List<Creature> army;

    public Hero(Fraction fraction, String name) {
        this.name = name;
        this.fraction = fraction;
        this.experience = 0;
        this.level = 1;
    }

    public boolean addCreature(Creature creature) {
        if (army == null) {
            army = new LinkedList<>();
        }
        return army.add(creature);
    }

    public boolean removeCreature(Creature creature) {
        if (army == null) {
            return false;
        }
        return army.remove(creature);
    }

    public String getName() {
        return name;
    }

    public Fraction getFraction() {
        return fraction;
    }

    public int getExperience() {
        return experience;
    }

    public int getLevel() {
        return level;
    }

    public List<Creature> getArmy() {
        return army;
    }
}
