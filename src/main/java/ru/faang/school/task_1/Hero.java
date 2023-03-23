package ru.faang.school.task_1;

import java.util.ArrayList;

public class Hero {
    private String name;
    private String fraction;
    private int experience;
    private short level;
    private final ArrayList<Creature> army = new ArrayList<>(7);

    public Hero(String name, String fraction) {
        setName(name);
        setFraction(fraction);
        setExperience(0);
        setLevel(1);
//        addCreature(new Pikeman(), 1);
    }

    public void addCreature(Creature creature, int quantity) {
        if (army.contains(creature)) {
            for (Creature c : army) {
                if (creature.getClass().equals(c.getClass())) {
                    c.setQuantity(c.getQuantity() + quantity);
                    break;
                }
            }
        } else {
            creature.setQuantity(quantity);
            army.add(creature);
        }
    }

    public void removeCreature(Creature creature, int quantity) {
        ArrayList<Creature> toRemove = new ArrayList<>();
        if (army.contains(creature)) {
            for (Creature c : army) {
                if (creature.getClass().equals(c.getClass())) {
                    if (c.getQuantity() <= quantity) {
                        toRemove.add(c);
                    } else {
                        c.setQuantity(c.getQuantity() - quantity);
                    }
                }
            }
            army.removeAll(toRemove);
            army.trimToSize();
        } else {
            System.out.println("There is no " + creature.getClass().getSimpleName() + "s!");
        }
    }

    public ArrayList<Creature> getArmy() {
        return army;
    }

    public void showArmy() {
        for (Creature c : army) {
            System.out.println(c);
            System.out.println();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFraction() {
        return fraction;
    }

    public void setFraction(String fraction) {
        this.fraction = fraction;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public short getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = (short) level;
    }

    @Override
    public String toString() {
        return getName() + "\n" + getArmy();
    }
}

