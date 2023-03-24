package ru.faang.school.task_1.creatures;

public class Griffin extends Creature {

    public Griffin() {
        super("Грифон",
                2,
                "15-18",
                "8-10%",
                2,
                900);
    }

    @Override
    public int getDamage() {
        return (int) ((Math.random() * ((18 - 14)) + 14) + 1);
    }

    @Override
    public double getArmor() {
        return (Math.random() * (0.1 - 0.08) + 0.08);
    }
}
