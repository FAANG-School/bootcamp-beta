package ru.faang.school.task_1.classes.creatures;

import lombok.Getter;

@Getter
public class Pikeman extends Creature {
    private static final String NAME = "Копейщик";
    private static final int LEVEL = 1;
    private static final int DAMAGE = 3;
    private static final int ARMOR = 5;
    private static final int SPEED = 4;

    public Pikeman() {
        super(NAME, LEVEL, DAMAGE, ARMOR, SPEED);
    }
}
