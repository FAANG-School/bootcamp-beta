package main.java.ru.faang.school.task_1;


import main.java.ru.faang.school.task_1.Creature.Angel;
import main.java.ru.faang.school.task_1.Creature.Creature;

import java.util.ArrayList;
import java.util.List;


public class Hero {
    private final String name;
    private int experience;
    private String fraction;
    private int level;
    private List<Creature> troops=new ArrayList<>();

    public Hero(String name,String fraction){
        this.name=name;
        this.fraction=fraction;
        this.level=1;
        this.experience=1;
    }
    public void addCreature(Creature creature,int quantity){
        boolean flag=true;
        if (troops.size()==0){
            creature.setQuantity(quantity);
            troops.add(creature);
        }
        for (Creature creatureOfTroops: troops){
            if (creature.getName().equals(creatureOfTroops.getName())){
                int count=creatureOfTroops.getQuantity();
                creatureOfTroops.setQuantity(quantity+count);
                flag=false;
            }
            }
        if (flag){
            creature.setQuantity(quantity);
            troops.add(creature);
        }
    }
    public void removeCreature(Creature creature,int quantity){
        for (Creature creatureOfTroops: troops){
            if (creature.getName().equals(creatureOfTroops.getName()) && creature.getQuantity()==quantity){
                troops.remove(creatureOfTroops);
            }else{
                int count=creatureOfTroops.getQuantity();
                troops.remove(creatureOfTroops);
                creature.setQuantity(count-quantity);
                troops.add(creature);
            }
        }
    }
    public List<Creature> getArmy(){
        return troops;
    }
    public String getName(){
        return name;
    }
    public int getTotalQuantity(){
        return troops.stream().
                mapToInt(Creature::getQuantity).
                sum();
    }
}
