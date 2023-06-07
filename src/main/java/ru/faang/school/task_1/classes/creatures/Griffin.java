package ru.faang.school.task_1.classes.creatures;

import lombok.Getter;

@Getter
public class Griffin extends Creature {
    private static final String NAME = "Грифон";
    private static final int LEVEL = 3;
    private static final int DAMAGE = 6;
    private static final int ARMOR = 7;
    private static final int SPEED = 6;

    public Griffin() {
        super(NAME, LEVEL, DAMAGE, ARMOR, SPEED);
    }
}
