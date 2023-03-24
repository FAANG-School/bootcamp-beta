package ru.faang.school.task_1.creatures;

public class Angel extends Creature {
    private final String NAME = "Angel";
    private final int LEVEL = 1;
    private final int ATTACK_POWER  = 100;
    private final int ARMOR = 1000;
    private final int SPEED = 100;
    private final int QUANTITY = 0;

    public Angel() {
        this.name = NAME;
        this.level = LEVEL;
        this.attackPower = ATTACK_POWER;
        this.armor = ARMOR;
        this.speed = SPEED;
        this.quantity = QUANTITY;
    }
}
