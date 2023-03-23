package ru.faang.school.task_1;

import java.util.ArrayList;
import java.util.List;

public class Hero {
    private String name;
    private  String fraction;
    private int experience;
    private int level;
    private  List<Creature> army;

    public Hero(String name, String fraction, int experience, int level) {
        this.name = name;
        this.fraction = fraction;
        this.experience = experience;
        this.level = level;
        this.army = new ArrayList<>();
    }

    public void addCreature(Creature creature, int quantity) {
        creature.setQuantity(quantity);
        this.army.add(creature);
    }

    public void removeCreature(Creature creature, int quantity) {
        for (Creature c : this.army) {
            if (c.getClass().equals(creature.getClass())) {
                int currentQuantity = c.getQuantity();
                if (currentQuantity <= quantity) {
                    this.army.remove(c);
                } else {
                    c.setQuantity(currentQuantity - quantity);
                }
                break;
            }
        }
    }
    public List<Creature> getArmy() {
        return this.army;
    }

    public String getName() {
        return this.name;
    }

    public String getFraction() {
        return fraction;
    }

}
