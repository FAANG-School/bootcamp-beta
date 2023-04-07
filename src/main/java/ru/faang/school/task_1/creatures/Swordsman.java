package ru.faang.school.task_1.creatures;

public class Swordsman extends Creature{
    public Swordsman(int quantity) {
        this.name = "Swordsman";
        this.attackRating = 8;
        this.defenceRating = 12;
        this.level = 1;
        this.speed = 2;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Swordsman{"  + quantity + '}';
    }
}
