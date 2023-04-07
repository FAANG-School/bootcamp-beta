package ru.faang.school.task_1.Entities;

public class Griffin extends Creature{
    public Griffin(){
        this.name = "griffin";
        this.damage = 14;
        this.quantity = 1;
        this.level = 1;
        this.speed = 2;
        this.resistance = 8;
        setBackUp();
    }

}
