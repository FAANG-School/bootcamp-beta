package ru.faang.school.task_1.Entities;

public class Pikeman extends Creature{
    public Pikeman(){
        this.name = "pikeman";
        this.damage = 19;
        this.quantity = 1;
        this.level = 1;
        this.speed = 3;
        this.resistance = 3;
        setBackUp();
    }
}
