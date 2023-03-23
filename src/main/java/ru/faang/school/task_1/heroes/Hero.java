package ru.faang.school.task_1.heroes;

import ru.faang.school.task_1.creatures.Creature;

import java.util.PriorityQueue;

public class Hero {

    private final String name;
    private final Fraction fraction;
    private final int experience;
    private final int level;
    private PriorityQueue<Creature> army;

    public Hero(Fraction fraction, String name) {
        this.name = name;
        this.fraction = fraction;
        this.experience = 0;
        this.level = 1;
    }

    public void addCreature(Creature creature) {
        if (army == null) {
            army = new PriorityQueue<>();
        }
        army.add(creature);
    }

    public void removeCreature(Creature creature) {
        if (army == null) {
            return;
        }
        army.remove(creature);
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

    public PriorityQueue<Creature> getArmy() {
        return army;
    }
}
