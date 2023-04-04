package ru.faang.school.task_1.Heroes;

public class Axe  extends  Hero{
    public Axe() {
        super("Акс",
                Fraction.STRENGTH,
                (int) ((Math.random() * (6 - 1)) + 1));
    }
}
