package ru.faang.school.task_1.creatures;

public class Griffin extends Creature{
    public Griffin(int quantity) {
        this.name = "Griffin";
        this.attackRating = 25;
        this.defenceRating = 15;
        this.level = 1;
        this.speed = 4;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Griffin{"  + quantity + '}';
    }
}
