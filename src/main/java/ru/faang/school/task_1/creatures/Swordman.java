package ru.faang.school.task_1.creatures;

public class Swordman extends Creature {

    public Swordman() {
        super("Мечник",
                4,
                "29-32",
                "25-30%",
                2,
                1500);
    }

    @Override
    public int getDamage() {
        return (int) ((Math.random() * (32 - 28)) + 28);
    }

    @Override
    public double getArmor() {
        return (Math.random() * (0.3 - 0.25) + 0.25);
    }
}
