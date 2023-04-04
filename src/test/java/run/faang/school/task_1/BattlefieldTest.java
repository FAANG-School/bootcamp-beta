package run.faang.school.task_1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ru.faang.school.task_1.game.Battlefield;
import ru.faang.school.task_1.game.heroes.Hero;
import ru.faang.school.task_1.game.creatures.Angel;
import ru.faang.school.task_1.game.creatures.Griffin;
import ru.faang.school.task_1.game.creatures.Pikeman;
import ru.faang.school.task_1.game.creatures.Swordman;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BattlefieldTest {

    private Hero firstHero;

    private Hero secondHero;

    private Hero thirdHero;

    private Hero fourthHero;

    @BeforeEach
    void setUp() {
        firstHero = new Hero("First hero", "Blue fraction");
        firstHero.addCreature(new Angel(), 1);
        firstHero.addCreature(new Griffin(), 4);
        firstHero.addCreature(new Pikeman(), 3);
        firstHero.addCreature(new Swordman(), 5);

        secondHero = new Hero("Second hero", "Red fraction");
        secondHero.addCreature(new Angel(), 10);
        secondHero.addCreature(new Griffin(), 4);
        secondHero.addCreature(new Pikeman(), 3);
        secondHero.addCreature(new Swordman(), 5);

        thirdHero = new Hero("Third Hero", "Red Fraction");
        thirdHero.addCreature(new Angel(), 30);

        fourthHero = new Hero("Fourth Hero", "Blue Fraction");
        fourthHero.addCreature(new Griffin(), 110);
        fourthHero.addCreature(new Pikeman(), 150);
        fourthHero.addCreature(new Swordman(), 100);
    }

    @Test
    void firstBattle() {
        Battlefield battlefield = new Battlefield(firstHero, secondHero);

        Hero winner = battlefield.battle();

        assertEquals(secondHero.getName(), winner.getName());
    }

    @Test
    void secondBattle() {
        Battlefield battlefield = new Battlefield(thirdHero, fourthHero);

        Hero winner = battlefield.battle();

        assertEquals(thirdHero.getName(), winner.getName());
    }
}