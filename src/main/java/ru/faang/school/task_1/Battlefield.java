package ru.faang.school.task_1;


import java.util.HashMap;
import java.util.Map;

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



    public static void battle(Hero hero1, Hero hero2){
        Map<Creature, Integer> army1 = hero1.getArmy();
        Map<Creature, Integer> army2 = hero2.getArmy();

        while (!(army1.isEmpty() || army2.isEmpty())) {
            double turn = Math.random(); //определяем, чей ход

            if (turn <= 0.5) {
                for (Map.Entry<Creature, Integer> unit : army1.entrySet()) {

                    Map<Integer, Creature> enemies = new HashMap<>();
                    int i = 0;

                    army2.entrySet().removeIf(entry -> entry.getValue() <= 0);

                    if(army2.isEmpty()){
                        System.out.println("Первая армия выйграла!");
                        break;
                    }

                    for (Map.Entry<Creature, Integer> unit2 : army2.entrySet()) {
                        enemies.put(i, unit2.getKey());
                        i++;
                    }

                    int enemyNumber = (int) Math.ceil((Math.random()) * (i-1));  //поиск врага для атаки

                    int damageForSecond = unit.getKey().getDamage(enemies.get(enemyNumber));

                    hero2.removeCreature(enemies.get(enemyNumber), damageForSecond);

                    if (army2.get(enemies.get(enemyNumber)) <= 0){
                        System.out.println("Вторая армия потеряла всех " + enemies.get(enemyNumber).getName());
                    } else {
                        System.out.println("Вторая армия потеряла " + damageForSecond +
                                " " + enemies.get(enemyNumber).getName());
                    }
                }
            }

            if (turn > 0.5) {
                for (Map.Entry<Creature, Integer> unit : army2.entrySet()) {

                    Map<Integer, Creature> enemies = new HashMap<>();
                    int i = 0;

                    army1.entrySet().removeIf(entry -> entry.getValue() <= 0);

                    if(army1.isEmpty()){
                        System.out.println("Вторая армия выйграла!");
                        break;
                    }

                    for (Map.Entry<Creature, Integer> unit1 : army1.entrySet()) {
                        enemies.put(i, unit1.getKey());
                        i++;
                    }

                    int enemyNumber = (int) Math.ceil((Math.random()) * (i-1));  //поиск врага для атаки

                    int damageForFirst = unit.getKey().getDamage(enemies.get(enemyNumber));

                    hero1.removeCreature(enemies.get(enemyNumber), damageForFirst);

                    if (army1.get(enemies.get(enemyNumber)) <= 0){
                        System.out.println("Перая армия потеряла всех " + enemies.get(enemyNumber).getName());
                    } else {
                        System.out.println("Первая армия потеряла " + damageForFirst +
                                " " + enemies.get(enemyNumber).getName());
                    }
                }
            }
        }
    }

}
