package ru.faang.school.task_1;

import ru.faang.school.task_1.creature.*;

import java.util.Set;
import java.util.HashSet;

public class Hero {
    private final String name;
    private final String faction;
    private int exp;
    private int level;
    private Set<Creature> army;

    public Hero(String name, String faction, int initialExp) {
        this.name = name;
        this.faction = faction;
        this.exp = initialExp;
        this.level = this.exp / 1000; // the formula is simplified
        this.army = new HashSet<>();
    }

    public void addCreature(Creature creature, int qty) {
        if (army.contains(creature) && qty > 0) {
            army.remove(creature);
            creature.setQty(creature.getQty() + qty);
            army.add(creature);
        } else {
            if (qty > 0) {
                creature.setQty(qty);
                army.add(creature);
            }
        }
    }

    public void removeCreature(Creature creature, int qty) {
        if (army.contains(creature)) {
            army.remove(creature);
            creature.setQty(creature.getQty() - qty);
            if (creature.getQty() > 0) {
                army.add(creature);
            }
        }
    }

    public Set<Creature> getArmy() {
        return army;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", faction='" + faction + '\'' +
                ", exp=" + exp +
                ", level=" + level +
                '}';
    }
}
