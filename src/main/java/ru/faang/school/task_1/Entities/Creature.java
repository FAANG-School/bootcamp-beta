package ru.faang.school.task_1.Entities;

public abstract class Creature {
    //имя, уровень, атака, защита, скорость и количество
    protected String name;
    protected int level;
    protected int damage;
    private int backUpDamage;
    protected int resistance;//dynamic field
    private int backUpResistance;//static field(we should not touch it)
    protected int speed;
    protected int quantity;

    public int getDamage(){return damage;}

    public int getResistance() {
        return resistance;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    public void levelUp(){
        level++;
    }
    protected void setBackUp(){backUpResistance = resistance; backUpDamage = damage;}
    public void backUp(){resistance = backUpResistance; damage = backUpDamage;}
    @Override
    public String toString(){
        return ("Name: " + name + "\nLevel: " + level + "\nDamage: " + damage + "\nResistance: " +
                resistance + "\nSpeed: " + speed + "\nQuantity: " + quantity + "\n");
    }
}
