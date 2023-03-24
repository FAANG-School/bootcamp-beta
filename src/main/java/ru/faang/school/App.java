package ru.faang.school;

import ru.faang.school.task_1.Battlefield;
import ru.faang.school.task_1.Hero;

public class App {
    public static void main(String[] args) {
        Hero firstHero = new Hero("Vlad","Castle",5_000_000,121);
        Hero secondHero = new Hero("Max","Necropolis",3_500_000,115);
        Battlefield battlefield = new Battlefield(firstHero,secondHero);
        battlefield.fillFirstHeroArmy();
        battlefield.fillSecondHeroArmy();
        System.out.println(battlefield.battle());
        System.out.println("First hero army: "+firstHero.getARMY().size());
        System.out.println("Second hero army: "+secondHero.getARMY().size());
    }
}
