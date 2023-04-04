package ru.faang.school.task_1.Heroes;

public class Slark extends  Hero{

    public Slark() {
        super("Рыба",
                Fraction.AGILITY,
                (int) ((Math.random() * (6 - 1)) + 1));
    }
}
