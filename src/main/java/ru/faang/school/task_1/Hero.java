package ru.faang.school.task_1;

import java.util.ArrayList;
import java.util.List;

public class Hero {
    String name;
    String faction;
    Integer experience;
    Integer level;

    List<Creature> army = new ArrayList<>();

    void addCreature(Creature creature, int quantity) {
        creature.quantity = quantity;
        army.add(creature);
    }

    void removeCreature(Creature creature) {
        army.remove(creature);
    }
    List<Creature> getArmy() {
        return army;
    }
}
