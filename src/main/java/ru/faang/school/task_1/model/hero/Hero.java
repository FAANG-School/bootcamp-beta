package ru.faang.school.task_1.model.hero;

import ru.faang.school.task_1.model.creature.Creature;

import java.util.ArrayList;
import java.util.List;


public abstract class Hero {

    private final String name;

    private final String fraction;

    private Integer level;

    private Double experience;

    private final List<Creature> army = new ArrayList<>();

    protected Hero(String name, String fraction, Integer level, Double experience) {
        this.fraction = fraction;
        this.name = name;
        this.level = level;
        this.experience = experience;
    }

    public void addCreature(Creature creature) {
        army.add(creature);
    }

    public void addCreature(List<Creature> creatures) {
        army.addAll(creatures);
    }

    public void removeCreature(Creature creature) {
        army.remove(creature);
    }

    public List<Creature> getArmy() {
        return army;
    }

    public String getName() {
        return name;
    }

    public void showArmyStatistics() {
        army.forEach(squad -> System.out.println("Отряд %s - %s существ".formatted(squad.getName(), squad.getQuantity())));
    }
}
