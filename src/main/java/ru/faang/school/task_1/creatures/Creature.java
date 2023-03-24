package ru.faang.school.task_1.creatures;

public abstract class Creature {

    protected String name;
    protected int lvl;
    protected String attack;
    protected String armor;
    protected int speedAttack;
    protected double countHp;


    public Creature(String name, int lvl, String attack, String armor, int speedAttack, double countHp) {
        this.name = name;
        this.lvl = lvl;
        this.attack = attack;
        this.armor = armor;
        this.speedAttack = speedAttack;
        this.countHp = countHp;
    }

    public abstract int  getDamage();
    public abstract double getArmor();

    public String getName() {
        return name;
    }

    public int getLvl() {
        return lvl;
    }

    public String getAttack() {
        return attack;
    }

    public int getSpeedAttack() {
        return speedAttack;
    }
    public double getCountHp() {
        return countHp;
    }

    public String toString() {
        return name;
    }
}
