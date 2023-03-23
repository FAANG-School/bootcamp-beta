package ru.faang.school.task_1.creature;

public abstract class Creature {
    protected String name;
    protected int level;
    protected int attack;
    protected int defense;
    protected int speed;
    protected int qty;

    public abstract int getDamage(); // the formula is self-authored

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getQty() {
        return qty;
    }
}
