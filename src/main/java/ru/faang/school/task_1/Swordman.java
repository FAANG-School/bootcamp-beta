package ru.faang.school.task_1;

public class Swordman extends Creature{
    public Swordman() {
        super("Swordman", 5, 12, 20, 120, 6);
    }

    @Override
    public int getDamage() {
        return (this.getAttack() + this.getLevel()) * this.getQuantity();
    }
}
