package ru.faang.school.task_1.creatures;

public class Swordman extends Creature{
    private final String NAME = "Swordman";
    private final int LEVEL = 1;
    private final int ATTACK_POWER  = 10;
    private final int ARMOR = 100;
    private final int SPEED = 15;
    private final int QUANTITY = 0;

    public Swordman() {
        this.name = NAME;
        this.level = LEVEL;
        this.attackPower = ATTACK_POWER;
        this.armor = ARMOR;
        this.speed = SPEED;
        this.quantity = QUANTITY;
    }
}
