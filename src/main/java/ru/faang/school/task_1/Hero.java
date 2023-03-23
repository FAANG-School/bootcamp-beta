package ru.faang.school.task_1;

public class Hero {
    private String name;
    private String fraction;
    private float experience;
    private int level;

    public void addCreature(Creature creature, int quantity) {
        for (int i = 0; i < quantity; i++) {
            Creature.creatures.add(creature);
        }

    }

    public void removeCreature(Creature creature, int quantity) {
        for (int i = 0; i < quantity; i++) {
            Creature.creatures.remove(creature);
        }

    }

    public static void getArmy() {
        for(Creature cr : Creature.creatures) {
            System.out.println(cr.getName());
        }
    }

}
