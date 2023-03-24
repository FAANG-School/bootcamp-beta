package ru.faang.school.task_1;

import ru.faang.school.task_1.creatures.Creature;

import java.util.ArrayList;
import java.util.List;

public class Hero {
    private List<Creature> ARMY = new ArrayList<>();
    private String name;
    private String fraction;
    private long experience;
    private int level;
    public Hero(String name, String fraction, long experience, int level) {
        this.name = name;
        this.fraction = fraction;
        this.experience = experience;
        this.level = level;
    }

    public void setARMY(List<Creature> ARMY) {
        this.ARMY = ARMY;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFraction(String fraction) {
        this.fraction = fraction;
    }

    public void setExperience(long experience) {
        this.experience = experience;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public String getFraction() {
        return fraction;
    }

    public long getExperience() {
        return experience;
    }

    public int getLevel() {
        return level;
    }
    public List<Creature> getARMY() {
        return ARMY;
    }
    public void addCreature(Creature creature){
            ARMY.add(creature);
    }
    public void removeCreature(Creature creature,int quantity){
        for(int i=0;i<quantity;i++){
            ARMY.remove(creature);
        }
    }
}
