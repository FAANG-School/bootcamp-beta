package ru.faang.school.task_1.creatures;

public class Pikeman extends Creature {

    public Pikeman() {
        super("Рудокоп",
                3,
                "21-25",
                "10-15%",
                3,
                1050);
    }

    @Override
    public int getDamage() {
        return (int) ((Math.random() * (25 - 20)) + 20);
    }

    @Override
    public double getArmor() {
        return (Math.random() * (0.15 - 0.1) + 0.1);
    }
}
