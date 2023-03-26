package ru.faang.school.task_1.game.heroes;

import ru.faang.school.task_1.game.creatures.Creature;

import java.util.ArrayList;
import java.util.List;

public class Hero {

    private final String name;

    private final String fraction;

    private int experience;

    private int level;

    private final List<Creature> units = new ArrayList<>();

    public Hero(String name, String fraction) {
        this.name = name;
        this.fraction = fraction;
        this.level = 1;
        this.experience = 0;
    }

    public void addCreature(Creature creature, int quantity) {
        creature.setQuantity(quantity);
        units.add(creature);
    }

    public void removeCreature(Creature creature, int quantity) {
        int index = 0;
        for (int i = 0; i < units.size(); i++) {
            if (units.get(i).equals(creature)) {
                index = i;
                break;
            }
        }
        Creature c = units.get(index);
        if (c.getQuantity() <= quantity) {
            units.remove(index);
        } else {
            c.reducingQuantity(quantity);
        }
    }

    public void increaseExperience(int amount) {
        experience += amount;
        if (experience % 100 == 0) {
            level += 1;
        }
    }

    public String getName() {
        return name;
    }

    public List<Creature> getArmy() {
        return units;
    }

    public boolean isArmyEmpty() {
        return units.isEmpty();
    }

    public int getArmySize() {
        return units.size();
    }
}

