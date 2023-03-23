import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.faang.school.task_1.Battlefield;
import ru.faang.school.task_1.Creature;
import ru.faang.school.task_1.Hero;
import ru.faang.school.task_1.creatures.Angel;
import ru.faang.school.task_1.creatures.Griffin;
import ru.faang.school.task_1.creatures.Pikeman;
import ru.faang.school.task_1.creatures.Swordman;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

class BattlefieldTest {
    List<Hero> heroes = new LinkedList<>();

    Creature pikeman = new Pikeman("pikeman", "1", 2, 1, 0, 15);
    Creature griffin = new Griffin("griffin", "2", 6, 3, 0, 30);
    Creature swordman = new Swordman("swordman", "3", 25, 10, 0, 70);
    Creature angel = new Angel("angel", "4", 75, 65, 0, 150);

    @BeforeEach
    void setUp() {
        Hero red = new Hero("Myulich", "aliance", 0, 0);
        generateArmy(red);
        Hero blue = new Hero("Tiro", "aliance", 0, 0);
        generateArmy(blue);
        Hero orange = new Hero("Hallat", "aliance", 0, 0);
        generateArmy(orange);
        Hero purple = new Hero("Hector", "aliance", 0, 0);
        generateArmy(purple);
        heroes.addAll(List.of(red, blue, orange, purple));
    }

    @Test
    void battleWarTest() {
        while (heroes.size() != 1) {
            List<Hero> winners = new ArrayList<>();
            while (heroes.size() >= 2) {
                Hero leftHero = heroes.remove(0);
                Hero rightHero = heroes.remove(0);
                presentHeroes(leftHero, rightHero);
                Hero winner = new Battlefield(leftHero, rightHero).battle();
                presentWinner(winner);
                winners.add(winner);
            }
            heroes.addAll(winners);
        }
        assertTrue(heroes.get(0).getArmy().size() != 0);
    }


    private void generateArmy(Hero hero) {
        int lvl1ArmyQuantity = new Random().nextInt(1000);
        hero.addCreature(pikeman, lvl1ArmyQuantity);
        int lvl2ArmyQuantity = new Random().nextInt(750);
        hero.addCreature(griffin, lvl2ArmyQuantity);
        int lvl3ArmyQuantity = new Random().nextInt(300);
        hero.addCreature(swordman, lvl3ArmyQuantity);
        int lvl4ArmyQuantity = new Random().nextInt(20);
        hero.addCreature(angel, lvl4ArmyQuantity);
    }

    private void presentHeroes(Hero leftHero, Hero rightHero) {
        presentHero(leftHero);
        System.out.println();
        presentHero(rightHero);
    }

    private void presentHero(Hero hero) {
        System.out.printf("Left hero name is %s\n", hero.getName());
        System.out.println("His army contains: ");
        for (Creature creature : hero.getArmy()) {
            System.out.printf("%s - %d\n", creature.getName(), hero.getCreatureQuantity(creature));
        }
    }

    private void presentWinner(Hero winner) {
        System.out.printf("Winner name is %s\n", winner.getName());
        System.out.println("His army contains: ");
        for (Creature creature : winner.getArmy()) {
            System.out.printf("%s - %d\n", creature.getName(), winner.getCreatureQuantity(creature));
        }
    }
}