package ru.faang.school.task_1.Heroes;

public class Windraner extends Hero {

    public Windraner() {
        super("Лучница",
                Fraction.INTELLECT,
                (int) ((Math.random() * (6 - 1)) + 1));
    }
}
