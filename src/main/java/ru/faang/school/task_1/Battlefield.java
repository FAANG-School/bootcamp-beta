package ru.faang.school.task_1;

import java.util.Random;
import java.util.Stack;

public class Battlefield {
    public void battle(Hero blueHero, Hero redHero) throws InterruptedException {
        Stack<Creature> blueArmy = blueHero.getArmy();
        Stack<Creature> redArmy = redHero.getArmy();

        getInfo(blueHero, redHero);
        Thread.sleep(500);

        boolean flag = getToBattlefield(blueHero, redHero);
        while(!blueArmy.isEmpty() && !redArmy.isEmpty()){
            if(flag) {
                attack(blueHero, redHero);
                attack(redHero, blueHero);
            }
            else{
                attack(redHero, blueHero);
                attack(blueHero, redHero);
            }
            Thread.sleep(500);

        }

        if(redArmy.isEmpty()){
            System.out.printf("The blue army led by %s WON!\n" +
                    "army composition  after the battle: %s\n\n", blueHero.getName(), blueHero.getArmy());
            increaseExp(blueHero, redHero);
        }
        else{
            System.out.printf("The red army led by %s WON!\n" +
                    "army composition after the battle: %s\n\n", redHero.getName(), redHero.getArmy());
            increaseExp(redHero, blueHero);
        }

    }

    /*
     * Вся логика двух методов ниже + логика удаления отряда из стэка, если юнитов не осталось*/
    private void attack(Hero attackingHero, Hero defendingHero){
        if(attackingHero.getArmy().isEmpty() || defendingHero.getArmy().isEmpty())
            return;
        Creature attackingUnit = attackingHero.getArmy().peek();
        Creature defendingUnit = defendingHero.getArmy().peek();

        int totalDamage = getTotalDamage(attackingUnit, defendingUnit);
        System.out.printf("%s's %s squad deals: %d damage\n", attackingHero.getName(), attackingUnit.getName(), totalDamage);
        int numberOfFallenUnits = getNumberOfFallenUnits(defendingUnit, totalDamage);
        System.out.printf("%s's %s squad loses: %d unit(s)\n", defendingHero.getName(), defendingUnit.getName(), numberOfFallenUnits);

        defendingHero.removeCreature(defendingUnit, numberOfFallenUnits);
        System.out.printf("\n\n");
    }

    /*
     * Получаем количество погибших юнитов в отряде.
     * Если урон был больше общего здоровья отряда,
     * то погибает весь отряд. Иначе находим остаток здоровья.
     * Вычисляем кол-во юнитов с фулл хп и остатки присваиваем последнему юниту
     * Например: базовое здоровье для одного юнита 20 хп. В отряде 10 юнитов = 200хп
     * После удара осталось 115 хп. Это значит 4 отлетели, 5 юнитов с фулл хп и один юнит с 15 хп */
    private int getNumberOfFallenUnits(Creature defendingUnit, int totalDamage){
        if(totalDamage >= defendingUnit.getTotalHealth())
            return defendingUnit.getQuantity();

        int difference = defendingUnit.getTotalHealth() - totalDamage;
        int numberOfAliveInSquad = (int) Math.ceil(difference * 1.0/ defendingUnit.getHealth());
        defendingUnit.setTotalHealth(difference);
        return defendingUnit.getQuantity() - numberOfAliveInSquad;
    }

    /*
     * Используем защиту атакованного отряда для снижения урона
     * снижаем урон на % равный самой защите. Т.е. 20 ед = 20%*/
    private int getTotalDamage(Creature attackingUnit, Creature defendingUnit){
        int damage = attackingUnit.getDamage();
        int indexOfDefence = damage * defendingUnit.getDefence() / 100;
        return damage - indexOfDefence;
    }

    /*
     * Чтобы поле speed не было бесполезным добавляем логику
     * Сравниваем среднюю скорость каждой армии
     * Более быстрая армия первее приходит на поле боя и имеет приемущество
     * Эта армия будет атаковать первая
     * В противном случае первой атакует рандомная армия*/
    private boolean getToBattlefield(Hero blueHero, Hero redHero){
        System.out.printf("Speed of blue army: %d\n" +
                "Speed of red army: %d\n\n", blueHero.getAverageSpeed(), redHero.getAverageSpeed());

        if(blueHero.getAverageSpeed() > redHero.getAverageSpeed()){
            System.out.printf("The blue hero %s got to the battlefield first\n" +
                    "His army took the best position and has the advantage\n" +
                    "They're going to attack first\n\n", blueHero.getName());
            return true;
        }
        else if(redHero.getAverageSpeed() > blueHero.getAverageSpeed()){
            System.out.printf("The red hero %s got to the battlefield first\n" +
                    "His army took the best position and has the advantage\n" +
                    "They're going to attack first\n\n", redHero.getName());
            return false;
        }
        else{
            System.out.printf("Both heroes got to the battlefield at the same time\n" +
                    "Random side attacks first\n\n");
            return new Random().nextBoolean();
        }
    }

    /*
     * Получаем инфу о старте сражения
     * Выводим общие сведения о герое и его армии*/
    private void getInfo(Hero blueHero, Hero redHero) throws InterruptedException {
        System.out.println("The battle will start soon!\n");
        Thread.sleep(3000);

        System.out.printf("Blue side: \n" +
                "Hero: %s level %d from %s fraction\n" +
                "His army: %s\n\n", blueHero.getName(), blueHero.getLevel(), blueHero.getFraction(), blueHero.getArmy());

        System.out.printf("Red side: \n" +
                "Hero: %s level %d from %s fraction\n" +
                "His army: %s\n\n", redHero.getName(), redHero.getLevel(), redHero.getFraction(), redHero.getArmy());
    }

    /*Конвертируем общее здоровья армии лузера в експу для победителя
     * курс 1 к 1
     * 1 лвл = 1000 експы
     * конвертируем експу в лвл
     * увеличиваем лвл победителя
     * остаки присваиваем полю experience, если их меньше 1000*/
    private void increaseExp(Hero winner, Hero loser){
        int totalExpForBattle = loser.getTotalHealth();
        int levelIncrease = (totalExpForBattle + winner.getExperience()) / 1000;
        int expIncrease = totalExpForBattle + winner.getExperience() - 1000 * levelIncrease;

        winner.setLevel(levelIncrease);
        winner.setExperience(expIncrease);

        System.out.printf("Amount of experience for the battle: %d\n", totalExpForBattle);


        System.out.printf("%s level increased to: %d\n" +
                "experience: %d / 1000", winner.getName(), winner.getLevel(), winner.getExperience());
    }
}
