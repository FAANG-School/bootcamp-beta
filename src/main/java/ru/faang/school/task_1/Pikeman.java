package ru.faang.school.task_1;

public class Pikeman extends Creature{
    public Pikeman() {
        super("Pikeman", 4, 10, 17, 100, 7);
    }

    @Override
    public int getDamage() {
        return (this.getAttack() + this.getLevel()) * this.getQuantity();
    }
}
