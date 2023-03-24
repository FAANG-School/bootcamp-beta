package ru.faang.school.task_1.model.battlefield;

import ru.faang.school.task_1.model.creature.Creature;
import ru.faang.school.task_1.model.hero.Hero;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;


public class Battlefield {

    private int orderIndex = 0;

    private final Random random = new Random();

    private final List<Hero> moveOrder = new ArrayList<>();

    private static final DecimalFormat df = new DecimalFormat("0.00");

    public void battle(Hero hero1, Hero hero2) throws InterruptedException {
        hero1.getArmy().sort(Comparator.comparing(Creature::getSpeed));
        hero2.getArmy().sort(Comparator.comparing(Creature::getSpeed));

        System.out.println("Статистика до битвы");
        showHeroStatistic(hero1);
        showHeroStatistic(hero2);

        Thread.sleep(5000);

        if (random.nextInt(2) == 0) {
            moveOrder.add(hero1);
            moveOrder.add(hero2);
        } else {
            moveOrder.add(hero2);
            moveOrder.add(hero1);
        }

        while (hero1.getArmy().size() > 0 && hero2.getArmy().size() > 0) {
            Hero attackHero = moveOrder.get(orderIndex % 2);
            Hero defenseHero = moveOrder.get((orderIndex + 1) % 2);
            System.out.println("\nХод героя %s".formatted(attackHero.getName()));
            makeMove(attackHero, defenseHero);
            orderIndex+=1;
        }
        System.out.println("\nПобедил");
        if (hero1.getArmy().size() > 0) {
            showHeroStatistic(hero1);
        } else {
            showHeroStatistic(hero2);
        }
    }

    private void makeMove(Hero attackHero, Hero defenseHero) {
        int attackCreatureIndex = random.nextInt(attackHero.getArmy().size());
        int defenseCreatureIndex = random.nextInt(defenseHero.getArmy().size());
        Creature attackCreature = attackHero.getArmy().get(attackCreatureIndex);
        Creature defenseCreature = defenseHero.getArmy().get(defenseCreatureIndex);
        Double damage = attackCreature.getDamage();
        System.out.println("Отряд существа %s(%s) из команды героя %s нападает на отряд существ %s(%s) и наносит %s урона"
                .formatted(attackCreature.getName(), attackCreature.getQuantity(), attackHero.getName(),
                        defenseCreature.getName(), defenseCreature.getQuantity(), df.format(damage)));
        defenseCreature.updateInformation(damage);
        if (defenseCreature.isDead()) {
            System.out.printf("Отряд существа %s героя %s был разгромлен!%n", defenseCreature.getName(), defenseHero.getName());
            defenseHero.removeCreature(defenseCreature);
        }
    }

    private void showHeroStatistic(Hero hero) {
        System.out.println("\nГерой %s".formatted(hero.getName()));
        System.out.println("Армия героя");
        hero.showArmyStatistics();
    }
}
