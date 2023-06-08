package ru.faang.school.task_1;

public class Angel extends Creature {
    private static int level = 8;
    private static int attack = 7;
    private static int defence = 2;
    private static int speed = 4;
    private static int amount = 10;
    public Angel() {
        super("angel", level, attack, defence, speed, amount);
    }
}