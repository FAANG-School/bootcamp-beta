package ru.faang.school.task_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Hero {
    private String heroName;
    private String heroFraction;
    private int heroExperience;
    private int heroLevel;
    private Map<Creature,Integer> list;

    public Hero(String heroName, String heroFraction) {
        this.heroName = heroName;
        this.heroFraction = heroFraction;
        this.heroExperience = 0;
        this.heroLevel = 1;
        this.list = new HashMap<>();
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public String getHeroFraction() {
        return heroFraction;
    }

    public void setHeroFraction(String heroFraction) {
        this.heroFraction = heroFraction;
    }

    public int getHeroExperience() {
        return heroExperience;
    }

    public void setHeroExperience(int heroExperience) {
        this.heroExperience = heroExperience;
    }

    public int getHeroLevel() {
        return heroLevel;
    }

    public void setHeroLevel(int heroLevel) {
        this.heroLevel = heroLevel;
    }

    public Map<Creature, Integer> getList() {
        return list;
    }

    public void setList(Map<Creature, Integer> list) {
        this.list = list;
    }

    public void addCreature(Creature creature, int quantity){
        if(list.containsKey(creature)){
            list.put(creature,list.get(creature)+quantity);
        }else
            list.put(creature,quantity);

    }
    public void removeCreature(Creature creature, int quantity){
        if(list.containsKey(creature)){
            if(list.get(creature)-quantity <= 0){
                list.remove(creature);
            }else
                list.put(creature,list.get(creature)- quantity);
        }

    }
    public ArrayList<Creature> getArmy(){
        ArrayList<Creature> arrayList = new ArrayList<>();
        for (Map.Entry<Creature, Integer> entry : list.entrySet()) {
            Creature creature = entry.getKey();
            int quantity = entry.getValue();
            for (int i = 0; i < quantity; i++) {
                arrayList.add(creature);
            }
        }
        return arrayList;
    }
}
