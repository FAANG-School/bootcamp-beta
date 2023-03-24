package ru.faang.school.task_1.model;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Battlefield {
    private final Hero hero1;
    private final Hero hero2;

    public Battlefield(Hero hero1, Hero hero2) {
        this.hero1 = hero1;
        this.hero2 = hero2;
    }

    public Hero battle() {
        try {
            AtomicInteger hero1damage = new AtomicInteger();
            AtomicInteger hero1defence = new AtomicInteger();

            AtomicInteger hero2damage = new AtomicInteger();
            AtomicInteger hero2defence = new AtomicInteger();

            hero1.getArmy().forEach((key, value) -> hero1damage.set(Integer.sum(hero1damage.get(), value * key.getDamage())));
            hero1.getArmy().forEach((key, value) -> hero1defence.set(Integer.sum(hero1defence.get(), value * key.getArmor())));

            hero2.getArmy().forEach((key, value) -> hero2damage.set(Integer.sum(hero2damage.get(), value * key.getDamage())));
            hero2.getArmy().forEach((key, value) -> hero2defence.set(Integer.sum(hero2defence.get(), value * key.getArmor())));

            if (hero1damage.get() > hero2defence.get() || hero2damage.get() < hero1defence.get()) {
                return hero1;
            } else if (hero1damage.get() == hero2defence.get() || hero2damage.get() == hero1defence.get()) {
                return new Random().nextBoolean() ? hero1 : hero2;
            } else {
                return hero2;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
