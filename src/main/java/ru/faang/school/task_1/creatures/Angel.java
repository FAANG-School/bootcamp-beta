package ru.faang.school.task_1.creatures;

public class Angel extends Creature {

    public Angel() {
        super("Ангел",
                5,
                "23-25",
                "5-8%",
                4,
                1000);
    }

    @Override
    public int getDamage() {
        return (int) ((Math.random() * ((25 - 22)) + 22) + 1);
    }

    @Override
    public double getArmor() {
        return (Math.random() * (0.08 - 0.05) + 0.05);
    }
}
