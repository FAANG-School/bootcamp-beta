package ru.faang.school.task_1.Entities;

public class Swordman extends Creature{
    public Swordman(){
        this.name = "swordman";
        this.damage = 20;
        this.quantity = 1;
        this.level = 1;
        this.speed = 1;
        this.resistance = 20;
        setBackUp();
    }
}
