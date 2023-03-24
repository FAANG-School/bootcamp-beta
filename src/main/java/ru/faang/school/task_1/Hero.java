package ru.faang.school.task_1;

import ru.faang.school.task_1.entities.Creature;

import java.util.ArrayList;
import java.util.List;

public class Hero {
    private final String name;
    private final String fraction;
    private int experience;
    private int level;
    private final List<Creature> army = new ArrayList<>();
    public Hero(String name, String fraction, int experience, int level) {
        this.name = name;
        this.fraction = fraction;
        this.experience = experience;
        this.level = level;
    }
    public void addCreature(Creature creature, int quantity) {
        creature.setQuantity(creature.getQuantity() + quantity);
        creature.setAbsHealth(creature.getQuantity() * creature.getHealth());
        army.add(creature);
    }
    public void removeCreature(Creature creature, int quantity) {
        int q = creature.getQuantity() - quantity;
        if (q <= 0) {
            army.remove(creature);
        } else  {
            creature.setQuantity(q);
        }
    }
    public List<Creature> getArmy() {
        return army;
    }
    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public String getFraction() {
        return fraction;
    }
}
