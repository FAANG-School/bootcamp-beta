package ru.faang.school.task_1.creatures;

public class Angel extends Creature{

    public Angel(int quantity) {
        this.name = "Angel";
        this.attackRating = 50;
        this.defenceRating = 40;
        this.level = 1;
        this.speed = 5;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Angel{" + getQuantity() + '}';
    }
}
