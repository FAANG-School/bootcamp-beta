package ru.faang.school.task_1;

import ru.faang.school.task_1.entities.*;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Battlefield {
    private final ThreadLocalRandom r = ThreadLocalRandom.current();
    private final Hero first = new Hero("hronosfera", "shadow", 0, 0);

    private final Hero second = new Hero("l1st3r", "demigod", 0, 0);
    public void init() {
        createArmy(first);
        createArmy(second);
        battle(first, second);
    }
    private void createArmy(Hero hero) {
        hero.addCreature(new Angel(), r.nextInt(10) + 1);
        hero.addCreature(new Swordman(), r.nextInt(100) + 1);
        hero.addCreature(new Griffin(),  r.nextInt(50) + 1);
        hero.addCreature(new Pikeman(), r.nextInt(200) + 1);
    }
    private void battle(Hero first, Hero another) {
        List<Creature> firstArmy = first.getArmy();
        List<Creature> anotherArmy = another.getArmy();
        if (firstArmy.size() == 0) {
            System.out.println("Win:" + another.getName());
            return;
        }

        if (anotherArmy.size() == 0) {
            System.out.println("Win:" + first.getName());
            return;
        }
        Creature firstCreature = firstArmy.get(r.nextInt(firstArmy.size()));
        Creature anotherCreature = anotherArmy.get(r.nextInt(anotherArmy.size()));

        int fix = quantityCounter(anotherCreature, firstCreature);

        another.removeCreature(anotherCreature, fix);

        battle(another, first);
    }
    private int quantityCounter(Creature anotherCreature, Creature firstCreature) {
        int oldAbsHealth = anotherCreature.getAbsHealth();
        anotherCreature.setAbsHealth(oldAbsHealth - Math.max(1, firstCreature.getDamage() - anotherCreature.getArmor() / 2));
        int absHealth = anotherCreature.getAbsHealth();
        int hp = anotherCreature.getHealth();
        int rec = oldAbsHealth - absHealth;
        return absHealth <= 0 ? anotherCreature.getQuantity() : rec <= 0 ? anotherCreature.getQuantity() : rec / hp;
    }
}
