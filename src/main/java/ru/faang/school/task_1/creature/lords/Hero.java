package ru.faang.school.task_1.creature.lords;

import ru.faang.school.task_1.creature.warriors.Creature;
import ru.faang.school.task_1.fractions.Fraction;

import java.util.*;

public class Hero {
    private final String name;
    private final Fraction fraction;
    private final Integer experience;
    private final Map<Creature, Integer> army;

    public Hero(String name, Fraction fraction, Integer experience) {
        this.name = name;
        this.fraction = fraction;
        this.experience = experience;
        this.army = new HashMap<>();
    }

    public String getName() {
        return name;
    }


    public Fraction getFraction() {
        return fraction;
    }

    public Integer getExperience() {
        return experience;
    }

    public void addCreature(Creature creature, int quantity) {
        if (army.containsKey(creature)) {
            army.put(creature, army.get(creature) + quantity);
        } else {
            army.put(creature, quantity);
        }
    }

    public void removeCreature(Creature creature, int quantity) {
        if (!army.containsKey(creature)) throw new NoSuchElementException();
        if (army.get(creature) < quantity) throw new IllegalArgumentException();
        int newQuantity  = army.get(creature) - quantity;
        if (newQuantity == 0) {
            army.remove(creature);
            return;
        }
        army.put(creature, newQuantity);
    }

    public Map<Creature, Integer> getArmy() {
        return army;
    }

    @Override
    public String toString() {
        return name;
    }
}
