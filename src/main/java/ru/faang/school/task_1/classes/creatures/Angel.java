package ru.faang.school.task_1.classes.creatures;

import lombok.Getter;

@Getter
public class Angel extends Creature{
    private static final String NAME = "Архангел";
    private static final int LEVEL = 7;
    private static final int DAMAGE = 30;
    private static final int ARMOR = 30;
    private static final int SPEED = 30;

    public Angel(int quantity) {
        super(NAME, LEVEL, DAMAGE, ARMOR, SPEED, quantity);
    }
}
