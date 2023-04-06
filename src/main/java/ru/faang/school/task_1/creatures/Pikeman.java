package ru.faang.school.task_1.creatures;

public class Pikeman extends Creature{
    public Pikeman(int quantity) {
        this.name = "Pikeman";
        this.attackRating = 10;
        this.defenceRating = 8;
        this.level = 1;
        this.speed = 1;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Pikeman{" + quantity + '}';
    }
}
