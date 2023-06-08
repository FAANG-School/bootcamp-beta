package ru.faang.school.task_1;

public class Pikeman extends Creature {
    private static int level = 6;
    private static int attack = 5;
    private static int defence = 3;
    private static int speed = 2;
    private static int amount = 10;
    public Pikeman() {
        super("pikeman",  level, attack, defence, speed, amount);
    }
}
