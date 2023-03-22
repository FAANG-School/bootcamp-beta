package ru.faang.school.task_1.hero;

import ru.faang.school.task_1.creature.Creature;

import java.util.HashMap;
import java.util.Map;

public class Hero {
    private String name;
    private String fraction;
    private int experience;
    private int level;

    private Map<Creature, Integer> army;

    public Hero(String name, String fraction, int experience, int level) {
        this.name = name;
        this.fraction = fraction;
        this.experience = experience;
        this.level = level;
        this.army = new HashMap<Creature, Integer>();
    }

    public void addCreature(Creature creature, int quantity) {
        if (army.containsKey(creature)) {
            army.put(creature, army.get(creature) + quantity);
        } else {
            army.put(creature, quantity);
        }
    }

    public void removeCreature(Creature creature, int quantity) {
        if (army.containsKey(creature)) {
            army.put(creature, army.get(creature) + quantity);
            int currentQuantity = army.get(creature);
            if ((currentQuantity - quantity) <= 0) {
                army.remove(creature);
            } else {
                army.put(creature, army.get(creature) - quantity);
            }
        }
    }

    public Map<Creature, Integer> getArmy() {
        return army;
    }

    @Override
    public String toString() {
        return String.format("[$s] (%s) [lvl %s, exp %s]", name, fraction, level, experience);
    }
}
