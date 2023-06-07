package ru.faang.school.task_1.classes.creatures;

import lombok.Getter;

@Getter
public class Swordman extends Creature {
    private static final String NAME = "Мечник";
    private static final int LEVEL = 4;
    private static final int DAMAGE = 9;
    private static final int ARMOR = 12;
    private static final int SPEED = 5;

    public Swordman(int quantity) {
        super(NAME, LEVEL, DAMAGE, ARMOR, SPEED, quantity);
    }
}
