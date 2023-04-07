package ru.faang.school.task_1;

import ru.faang.school.task_1.creatures.Creature;
import ru.faang.school.task_1.creatures.CreatureFabrica;
import ru.faang.school.task_1.creatures.CreatureType;

import java.util.ArrayList;
import java.util.List;

public class Hero {
    String name;
    String fraction;
    int exp;
    int level;

    List<Creature> army = new ArrayList<>();

    public Hero(String name, String fraction) {
        this.name = name;
        this.fraction = fraction;
    }

    public void addCreature(CreatureType type, int quantity) {
        CreatureFabrica cf = new CreatureFabrica();
        army.add(cf.createCreature(type, quantity));
    }

    public List<Creature> getArmy() {
        return army;
    }

    public int getPowerOfArmy(){
        return  army.stream().mapToInt(creature -> creature.getDamage())
                .sum();
    }
    public int getDefenceOfArmy(){
        return  army.stream().mapToInt(creature -> creature.getDefenceRating())
                .sum();
    }

    @Override
    public String toString() {
        return  name + ' ' +
                ", fraction='" + fraction + ' ' +
                ", army=" + army;
    }
}
