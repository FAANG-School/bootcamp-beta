package ru.faang.school.task_1.Hero;

import ru.faang.school.task_1.Creature.Creature;

import java.util.ArrayList;
import java.util.List;

public class Hero {
    private final String name;
    private final String fraction;
    private int experience;
    private int level;
    private int requiredExperience = 100;
    private final List<Creature> army = new ArrayList<>();


    public Hero(String name, String fraction, int level) {
        if(name == null){
            throw new RuntimeException("Имя не введено");
        }
        if(fraction == null){
            throw new RuntimeException("Фракция не введена");
        }
        if(level <= 0 ){
            throw new RuntimeException("Не корректное значение");
        }
        this.name = name;
        this.fraction = fraction;
        this.level = level;
    }

    public void addCreature(Creature creature, int quantity) {
        creature.setQuantity(quantity);
        army.add(creature);

    }

    public void removeCreature(Creature creature, int quantity) {
        int index = 0;

        for (int i = 0; i < army.size(); i++) {
            if (army.get(i).equals(creature)) {
                index = i;
                break;
            }
        }
        Creature c = army.get(index);
        if (c.getQuantity() <= quantity) {
            army.remove(index);
        } else {
            c.reducingQuantity(quantity);
        }

    }

    public Creature getRandomCreature() {
        return army.get((int) (Math.random() * army.size()));
    }

    public void levelUp() {
        experience += 10;
        if (experience >= requiredExperience) {
            level++;
            requiredExperience += 50;
        }
    }

    public int getArmySize() {
        int size = 0;
        for (Creature c : army) {
            size += c.getQuantity();
        }
        return size;
    }

    private String armyToString() {
        StringBuilder str = new StringBuilder();
        for (Creature c : army) {
            str.append(c.toString()).append(", ");
        }
        return str.toString();
    }

    public String toString() {
        return "Герой " + name +
                "\nФракция: " + fraction +
                "\nУровень: " + level +
                "\nАрмия: " + armyToString();
    }

    public String getName() {
        return name;
    }
}
