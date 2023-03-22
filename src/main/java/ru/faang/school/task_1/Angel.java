package ru.faang.school.task_1;

public class Angel extends Creature{
    public Angel(){
        this.name = "angel";
        this.damage = 10;
        this.quantity = 1;
        this.level = 1;
        this.speed = 4;
        this.resistance = 6;
        setBackUp();
    }
}
