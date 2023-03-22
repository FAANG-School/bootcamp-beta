package ru.faang.school.task_1.hero;

import ru.faang.school.task_1.creature.Creature;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Hero {
    private final String name;
    private final String fraction;
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
            int currentQuantity = army.get(creature);
            if ((currentQuantity - quantity) <= 0) {
                army.remove(creature);
            } else {
                int updatedQuantity = army.get(creature) - quantity;
                creature.setQuantity(updatedQuantity);
                army.put(creature, updatedQuantity);
            }
        }
    }

    public Map<Creature, Integer> getArmy() {
        return army;
    }

    public String getFraction() {
        return fraction;
    }

    public int getArmySize() {
        return army.values().stream().reduce(0, Integer::sum);
    }

    public String getName() {
        return name;
    }

    public String getQuantity() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("[%s] (%s) [army %s]", fraction, name, this.getArmySize());
    }
}
