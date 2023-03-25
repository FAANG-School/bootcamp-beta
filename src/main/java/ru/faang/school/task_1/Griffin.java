package ru.faang.school.task_1;

public class Griffin extends Creature{
    public Griffin() {
        super("Griffin", 6, 18, 9, 170, 10);
    }

    @Override
    public int getDamage() {
        return (this.getAttack() + this.getLevel()) * this.getQuantity();
    }
}
