package ru.faang.school.task_1;

import java.util.ArrayList;
import java.util.List;

public class Hero {
    private String name;
    private String fraction;
    private int experience;
    private int level;
    private List<Creature> army = new ArrayList<>();

    public Hero(String name, String fraction, int experience, int level) {
        this.name = name;
        this.fraction = fraction;
        this.experience = experience;
        this.level = level;
    }

    public boolean addCreature(Creature creature, int quantity) {
        creature.setQuantity(creature.getQuantity() + quantity);
        return army.add(creature);
    }

   public boolean removeCreature(Creature creature, int quantity) {
        if (creature.getQuantity() >= quantity) {
            creature.setQuantity(creature.getQuantity() - quantity);
            return true;
        }
       return army.remove(creature);
   }

    public List<Creature> getArmy() {
        return army;
    }
}
