package ru.faang.school.task_1;

public class Griffin extends Creature {
    private static int level = 3;
    private static int attack = 6;
    private static int defence = 5;
    private static int speed = 8;
    private static int amount = 10;
    public Griffin() {
        super("griffin", level, attack, defence, speed, amount);
    }
}