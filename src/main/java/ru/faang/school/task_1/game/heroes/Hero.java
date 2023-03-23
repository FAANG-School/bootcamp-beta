package ru.faang.school.task_1.game.heroes;

import ru.faang.school.task_1.game.creatures.Creature;

import java.util.ArrayList;
import java.util.List;

public class Hero {

    private final String name;

    private final String fraction;

    private Integer experience;

    private Integer level;

    private final List<Creature> units = new ArrayList<>();

    public String getName() {
        return name;
    }

    public Integer getExperience() {
        return experience;
    }

    public Integer getLevel() {
        return level;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

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
            if(units.get(i).equals(creature)) {
                index = i;
                break;
            }
        }
        if(units.get(index).getQuantity() <= quantity) {
            units.remove(index);
        } else {
            units.get(index).setQuantity(units.get(index).getQuantity() - quantity);
        }
    }
    public List<Creature> getArmy() {
        return this.units;
    }
}

