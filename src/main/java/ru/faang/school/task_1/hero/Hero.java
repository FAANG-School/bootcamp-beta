package ru.faang.school.task_1.hero;

import ru.faang.school.task_1.creature.Creature;

import java.util.HashMap;
import java.util.Map;

/**
 * A class representing a hero in the game, with a name, a fraction, experience, level, and an army of creatures.
 */
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

    /**
     * Adds a new creature to the army of the hero, with the specified quantity.
     *
     * @param creature the creature to add
     * @param quantity the quantity of the creature to add
     */
    public void addCreature(Creature creature, int quantity) {
        if (army.containsKey(creature)) {
            army.put(creature, army.get(creature) + quantity);
        } else {
            army.put(creature, quantity);
        }
    }

    /**
     * Removes a certain quantity of a creature from the army of the hero, updating its quantity and the map accordingly.
     * If the quantity to remove is greater than or equal to the current quantity of the creature, it is removed
     * from the army altogether.
     *
     * @param creature the creature to remove
     * @param quantity the quantity of the creature to remove
     */
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

    public int getArmySize() {
        return army.values().stream().reduce(0, Integer::sum);
    }

    @Override
    public String toString() {
        return String.format("[%s] (%s) [army %s]", fraction, name, this.getArmySize());
    }
}
