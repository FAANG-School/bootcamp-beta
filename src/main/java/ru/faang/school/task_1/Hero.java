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
    private List<Creature> army = new ArrayList<>();

    public String getName() {
        return name;
    }

    public Hero(String name, String fraction, int experience, int level) {
        this.name = name;
        this.fraction = fraction;
        this.experience = experience;
        this.level = level;
    }

    public void addCreature(Creature creature, int quantity) {
        for (int i = 0; i < quantity; i++) {
            army.add(creature);
        }
    }

    public List<Creature> getArmy() {
        return army;
    }
    public double getPowerOfArmy() {
        double power = 0.0;
        for (Creature creature: army) {
            power += creature.getDamage() * creature.getCountCreature();
        }
        return power;
    }

    public double getDefenseOfArmy() {
        double defense = 0.0;
        for (Creature creature: army) {
            defense += creature.getDefense() * creature.getCountCreature();
        }
        return defense;
    }

    public void printInfoArmy() {
        for (Creature creature: army) {
            System.out.println(creature.getName() + " - количество: " + creature.getCountCreature());
        }
    }
}
