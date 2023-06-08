package ru.faang.school.task_1;

import java.util.Map;
import java.util.NoSuchElementException;

public class Battlefield {

    public static void main(String[] args) {

        Hero firstHero = new Hero("Illidan", "Elfs", 200, 80);
        Hero secondHero = new Hero("Druid", "Orcs", 250, 70);

        firstHero.createArmy();
        secondHero.createArmy();

        System.out.println(firstHero);
        System.out.println(secondHero);
        System.out.println("Battle started");

        battle(firstHero, secondHero);
    }

    public static void battle(Hero hero1, Hero hero2) {
        Map<Creature, Integer> army1 = hero1.getArmy();
        Map<Creature, Integer> army2 = hero2.getArmy();

        while (!(army1.isEmpty() || army2.isEmpty())) {
            double turn = Math.random(); //определяем, чей ход
            if (turn <= 0.5) {
                turnOfOneArmy(army1, army2, hero1, hero2);
            }
            if (turn > 0.5) {
                turnOfOneArmy(army2, army1, hero2, hero1);
            }
        }
    }

    private static void turnOfOneArmy(Map<Creature, Integer> army1, Map<Creature, Integer> army2, Hero hero1, Hero hero2) {
        for (Map.Entry<Creature, Integer> unit : army1.entrySet()) {
            army2.entrySet().removeIf(entry -> entry.getValue() <= 0);
            if (army2.isEmpty()) {
                System.out.println(hero1.getName() + " выйграл!");
                break;
            }
            Creature unitForAttack = army2.keySet().stream().findAny().get();
            int damageForSecond = unit.getKey().getDamage(unitForAttack);
            hero2.removeCreature((unitForAttack), damageForSecond);

            if (army2.get(unitForAttack) <= 0) {
                System.out.println(hero2.getName() + " потерял всех " + unitForAttack.getName());
            } else {
                System.out.println(hero2.getName() + " потерял " + damageForSecond +
                        " " + unitForAttack.getName());
            }

        }
    }

    private static Creature findEnemy(Map<Creature, Integer> army) {
        try {
            return army.keySet().stream().findAny().get();
        } catch (NoSuchElementException e) {
            System.out.println("В армии нет юнитов");
            return null;
        }
    }
}
