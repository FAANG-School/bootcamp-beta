package ru.faang.school.task_1.Entities;

import java.util.LinkedList;
import java.util.List;

public class Hero {
    protected int level = 0;
    protected String name;
    public String fraction;
    public int exp = 0;

    List<Creature> army;

    public Hero(String name){
        this.name = name;
        army = new LinkedList<>();
    }

    public Hero(String name, String fraction){
        this.name = name;
        this.fraction = fraction;
        army = new LinkedList<>();
    }

    public void addCreature(Creature creature, int quantity){
        for(Creature entity : army){
            if(creature.name.equals(entity.name)){
                entity.quantity += quantity;
                return;
            }
        }
        creature.setQuantity(quantity);
        army.add(creature);
    }

    public void removeCreature(Creature creature, int quantity){
        for(Creature entity : army){
            if(creature.name.equals(entity.name)){
                entity.quantity -= quantity;
                if(entity.quantity <= 0)
                    army.remove(entity);
                return;
            }
        }
    }

    @Override
    public String toString() {
        return "Winner{" +
                "name=" + name +
                ", level='" + level + '\'' +
                ", exp='" + exp + '\'' +
                ", fraction=" + fraction +
                '}' + "\nHis army is:\n" + army.toString();
    }
}
