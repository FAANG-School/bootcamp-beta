package ru.faang.school.task_1.hero;

import ru.faang.school.task_1.ArmySizeException;
import ru.faang.school.task_1.creature.Creature;

import java.util.LinkedList;

public class Hero {
    private final String name;
    private final Faction faction;
    private int exp;
    private int lvl;
    private int attack;
    private int defence;
    private LinkedList<Creature> army;

    public Hero(String name, Faction faction, int exp, int lvl, int attack, int defence) {
        this.name = name;
        this.faction = faction;
        this.exp = exp;
        this.lvl = lvl;
        this.attack = attack;
        this.defence = defence;
        army = new LinkedList<>();
    }

    public void addCreature(Creature creature, int quantity) {
        if (army.size() > 7) {
            throw new ArmySizeException();
        }
        creature.setQuantity(quantity);
        army.add(creature);
    }

    public void removeCreature(Creature creature, int quantity) {

        try {
            creature = army.get(army.indexOf(creature));
        } catch (IndexOutOfBoundsException e) {
            return;
        }

        creature.setQuantity(creature.getQuantity() - quantity);

        if (creature.getQuantity() == 0) {
            army.remove(creature);
        }
    }

    public LinkedList<Creature> getArmy() {
        return army;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefence() {
        return defence;
    }

    public String getName() {
        return name;
    }

    public Faction getFaction() {
        return faction;
    }

    public int getExp() {
        return exp;
    }

    public int getLvl() {
        return lvl;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", faction=" + faction +
                ", exp=" + exp +
                ", lvl=" + lvl +
                ", attack=" + attack +
                ", defence=" + defence +
                '}';
    }
}
