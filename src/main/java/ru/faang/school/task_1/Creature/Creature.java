package main.java.ru.faang.school.task_1.Creature;

abstract public class Creature {
    private final String name;
    private int level;
    private int damage;
    private int defence;
    private int speed;
    private int quantity;

    public int getDamage() {return damage;}
    public int getLevel(){return level;}

    public String getName() {return name;}

    public int getArmor() {
        return defence;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getSpeed() {
        return speed;
    }

    public void setArmor(int defence) {
        this.defence = defence;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setLevel(int level) {
        this.level = level;
    }


    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    protected Creature(String name,int level,int damage,int defence,int speed,int quantity){
        this.quantity=quantity;
        this.damage=damage;
        this.level=level;
        this.name=name;
        this.speed=speed;
        this.defence=defence;
    }
}
