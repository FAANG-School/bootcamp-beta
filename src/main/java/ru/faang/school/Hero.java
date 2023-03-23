package ru.faang.school;

import java.util.ArrayList;
public class Hero {
    //поля для характеристики героев
    private String name;
    private String faction;
    private int experience;
    private int level;
    //армия героев
    private ArrayList<Creature> army;
    //Для присваивания значений героям
    public Hero(String name, String faction, int experience, int level) {
        this.name = name;
        this.faction = faction;
        this.experience = experience;
        this.level = level;
        this.army = new ArrayList<Creature>();
    }
    //для увеличения армии
    public void addCreature(Creature creature, int quantity) {
        for (int i = 0; i < quantity; i++) {
            this.army.add(creature);
        }
    }
    //для уменьшения армии
    public void removeCreature(Creature creature, int quantity) {
        for (int i = 0; i < quantity; i++) {
            this.army.remove(creature);
        }
    }
    public ArrayList<Creature> getArmy() {
        return this.getArmy();
    }
}

