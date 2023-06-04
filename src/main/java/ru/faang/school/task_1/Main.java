package ru.faang.school.task_1;

public class Main {
    public static void main(String[] args) {
        Hero dmitryI = new Hero("Dimon", "Kraken", 3, 2);
        Hero petrV = new Hero("Petr", "Russia Empire", 5, 1);

        dmitryI.addCreature(new Griffin(121), 1);
        dmitryI.addCreature(new Swordman(21), 2);
        dmitryI.addCreature(new Angel(5), 1);


        petrV.addCreature(new Pikeman(99), 3);
        petrV.addCreature(new Swordman(21), 5);

        Battlefield bf = new Battlefield(dmitryI, petrV);
        System.out.println("Winner: " + bf.battle().getName());
    }
}
