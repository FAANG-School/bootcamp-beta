package ru.faang.school.task_1.creatures;

public class Griffin extends Creature{
    private final String NAME = "Griffin";
    private final int LEVEL = 1;
    private final int ATTACK_POWER  = 75;
    private final int ARMOR = 500;
    private final int SPEED = 150;
    private final int QUANTITY = 0;

    public Griffin() {
        this.name = NAME;
        this.level = LEVEL;
        this.attackPower = ATTACK_POWER;
        this.armor = ARMOR;
        this.speed = SPEED;
        this.quantity = QUANTITY;
    }
}
