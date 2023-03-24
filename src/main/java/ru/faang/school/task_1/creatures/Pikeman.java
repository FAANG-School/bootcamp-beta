package ru.faang.school.task_1.creatures;

public class Pikeman extends Creature{
    private final String NAME = "Pikeman";
    private final int LEVEL = 1;
    private final int ATTACK_POWER  = 15;
    private final int ARMOR = 50;
    private final int SPEED = 10;
    private final int QUANTITY = 0;

    public Pikeman() {
        this.name = NAME;
        this.level = LEVEL;
        this.attackPower = ATTACK_POWER;
        this.armor = ARMOR;
        this.speed = SPEED;
        this.quantity = QUANTITY;
    }

}
