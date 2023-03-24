package ru.faang.school;

public class Battlefield {
    private Hero hero1;
    private Hero hero2;

    public Battlefield(Hero hero1, Hero hero2) {
        this.hero1 = hero1;
        this.hero2 = hero2;
    }

    public Hero battle() {
        int army1 = hero1.getArmy();
        int army2 = hero2.getArmy();

        if (army1 > army2) {
            return hero1;
        } else {
            return hero2;
        }
    }
}
