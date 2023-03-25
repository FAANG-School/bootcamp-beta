package ru.faang.school.task_1;

public class Angel extends Creature{
    public Angel() {
        super("Angel", 7, 20, 10, 200, 12);
    }

    @Override
    public int getDamage() {
        return (this.getAttack() + this.getLevel()) * this.getQuantity();
    }
}

