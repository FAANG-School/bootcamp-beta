package ru.faang.school.task_1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hero {
    private String name;
    private String fraction;
    private Integer experience;
    private Integer level;

    private Map<Creature, Integer> army;

    public Hero(String name, String fraction, Integer experience, Integer level) {
        this.name = name;
        this.fraction = fraction;
        this.experience = experience;
        this.level = level;
        this.army = new HashMap<>();
    }

    public void addCreature(Creature creature, int quantity) {
        if (army.containsKey(creature)) {
            int newQuantity = army.get(creature) + quantity;
            army.put(creature, newQuantity);
        } else if (quantity > 0) {
            army.put(creature, quantity);
        }
    }

    public void removeCreature(Creature creature, int quantity) {
        Integer aliveCreatures = army.getOrDefault(creature, 0);
        if (quantity >= aliveCreatures) {
            army.remove(creature);
        } else {
            army.put(creature, aliveCreatures - quantity);
        }
    }

    public List<Creature> getArmy() {
        return army.keySet().stream().toList();
    }

    public int getCreatureQuantity(Creature creature) {
        return army.getOrDefault(creature, 0);
    }

    public String getName() {
        return name;
    }
}
