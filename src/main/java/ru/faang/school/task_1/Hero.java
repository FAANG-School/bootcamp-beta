package ru.faang.school.task_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hero {
    private String name;
    private String fraction;
    private int experience;
    private int level;
    private Map<Creature, Integer> army = new HashMap<>();

    public Hero(String name, String fraction, int experience, int level) {
        this.name = name;
        this.fraction = fraction;
        this.experience = experience;
        this.level = level;
    }
    public void addCreature(Creature creature, int quantity) {
        if (army.containsKey(creature)) {
            army.put(creature, army.get(creature) + quantity);
        } else army.put(creature, quantity);
    }
    public void removeCreature(Creature creature, int quantity) {
        if (!(army.containsKey(creature))) {
            throw new IllegalArgumentException("Нет такого существа");
        }

        if (army.get(creature) > quantity) {
            army.put(creature, army.get(creature) - quantity);
        } else {
            army.remove(creature);
        }
    }
    public Map<Creature, Integer> getArmy() {
        return army;
    }
    public void printInfoArmy() {
        for (Map.Entry<Creature, Integer> entry: army.entrySet()) {
            System.out.println(String.format("Героев под названием %s - %d штук", entry.getKey().getName(), entry.getValue()));
        }
    }
}
