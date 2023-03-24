package ru.faang.school.task_1.model;

import ru.faang.school.task_1.model.creatures.Creature;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Hero {
    private final String name;
    private final Faction faction;
    private final int experience;
    private final int level;

    private final Map<Creature, Integer> armyMap;

    public Hero(String name, Faction faction, int experience, int level) {
        this.name = name;
        this.faction = faction;
        this.experience = experience;
        this.level = level;
        this.armyMap = new ConcurrentHashMap<>();
    }

    public void addCreature(Creature creature, int quantity) {
        armyMap.compute(creature, (creature1, integer) -> (integer==null) ? quantity : Integer.sum(integer, quantity));
    }

    public void removeCreature(Creature creature, int quantity) {
        armyMap.computeIfPresent(creature, (creature1, integer) -> (integer < quantity) ? null : integer-quantity);
    }

    public Map<Creature, Integer> getArmy() {
        return armyMap;
    }

    public String getName() {
        return name;
    }
}
