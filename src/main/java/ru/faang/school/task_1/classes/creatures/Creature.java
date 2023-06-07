package ru.faang.school.task_1.classes.creatures;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public abstract class Creature {
    private String name;
    private int level;
    private int damage;
    private int armor;
    private int speed;
    private int quantity;
}
