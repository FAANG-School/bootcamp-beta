package ru.faang.school.task_1.classes.hero;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ru.faang.school.task_1.classes.creatures.Creature;
import ru.faang.school.task_1.classes.util.Fraction;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Hero {
    private final String NAME;
    private final Fraction FRACTION;
     private int experience;
    private int level;
    private List<Creature> army = new ArrayList<>();

    public void addCreature(Creature creature, int quantity) {
        if (!army.contains(creature)) {
            creature.setQuantity(quantity);
            army.add(creature);
        } else {
            for (Creature curCreature : army) {
                if (curCreature.equals(creature)) {
                    curCreature.setQuantity(quantity);
                }
            }
        }
    }

    public void removeCreature(Creature creature, int quantity) {
        for (Creature curCreature : army) {
            if (curCreature.equals(creature)) {
                int curQuantity = curCreature.getQuantity() - quantity;
                if (curQuantity < 0) {
                    System.out.println("Количество удаляемых существ превышает существующих");
                } else {
                    curCreature.setQuantity(-quantity);
                }
            }
        }
    }

    public void getArmyToString() {
        for (Creature creature : army) {
            System.out.println(creature);
        }
    }

    public List<Creature> getArmy() {
        return army;
    }

    public Hero(String NAME, Fraction FRACTION, int experience, int level) {
        this.NAME = NAME;
        this.FRACTION = FRACTION;
        this.experience = experience;
        this.level = level;
    }
}