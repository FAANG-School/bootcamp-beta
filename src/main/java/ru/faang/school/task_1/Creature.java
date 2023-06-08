package ru.faang.school.task_1;

public abstract class Creature {
    private String name;
    private int level;
    private int attack;
    private int defence;
    private int speed;
    private int amount;

    public Creature(String name, int level, int attack, int defence, int speed, int amount) {
        if(name.equals("")) System.out.println("Введите имя");
        if(attack < 0) System.out.println("Аттака не может быть меньше нуля");
        if(defence < 0) System.out.println("Защита не может быть меньше нуля");
        if(speed < 0) System.out.println("Скорость не может быть меньше нуля");
        if(amount < 0) System.out.println("Количиство юнитов не может быть меньше нуля");

        this.name = name;
        this.level = level;
        this.attack = attack;
        this.defence = defence;
        this.speed = speed;
        this.amount = amount;
    }

    public int getDamage(Creature creature) {
        return ((attack*level*amount*speed)/
                (creature.getDefence()* creature.getAmount()* creature.getLevel() * creature.getSpeed())) + 1;
    }
    public int getDefence() {
        return defence;
    }

    public int getAmount() {
        return amount;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getAttack() {
        return attack;
    }

    public int getSpeed() {
        return speed;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "\nCreature{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", attack=" + attack +
                ", defence=" + defence +
                ", speed=" + speed +
                ", amount=" + amount +
                "}";
    }
}
