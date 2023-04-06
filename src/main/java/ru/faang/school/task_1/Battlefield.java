package ru.faang.school.task_1;

public class Battlefield {

    private Hero first;
    private Hero second;

    public Battlefield(Hero hero1, Hero hero2) {
        this.first = hero1;
        this.second = hero2;
        System.out.printf("%s\n and\n%s\nmet on the battlefield...\n", hero1, hero2);
    }

    public Hero battle() {
        System.out.println("And the battle began...");
        int powerOfFirstArmy = first.getPowerOfArmy() - second.getDefenceOfArmy();
        int powerOfSecondArmy =  second.getPowerOfArmy() - first.getDefenceOfArmy();
        Hero winner =  powerOfFirstArmy >= powerOfSecondArmy ? first : second;
        System.out.println("The winner is " + winner);
        return winner;
    }

    public int getPowerOfArmy(Hero hero){
        return 5;
    }
}
