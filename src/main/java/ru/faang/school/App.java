package ru.faang.school;

import ru.faang.school.task_1.model.battlefield.Battlefield;
import ru.faang.school.task_1.model.creature.human.Griffin;
import ru.faang.school.task_1.model.creature.human.Pikeman;
import ru.faang.school.task_1.model.creature.human.Swordman;
import ru.faang.school.task_1.model.creature.necromancer.Skeleton;
import ru.faang.school.task_1.model.creature.necromancer.Vampire;
import ru.faang.school.task_1.model.creature.necromancer.Zombie;
import ru.faang.school.task_1.model.hero.HumanHero;
import ru.faang.school.task_1.model.hero.NecromancerHero;

import java.util.List;


public class App {
    public static void main(String[] args) throws InterruptedException {
        Battlefield battlefield = new Battlefield();
        HumanHero hero1 = new HumanHero("Александр", "Альянс Света", 12, 300.0);
        hero1.addCreature(List.of(new Swordman(50), new Griffin(15), new Pikeman(30)));

        NecromancerHero hero2 = new NecromancerHero("Виктория", "Некромант", 18, 420.0);
        hero2.addCreature(List.of(new Skeleton(320), new Zombie(32), new Vampire(12)));

        battlefield.battle(hero1, hero2);

    }
}
