package ru.faang.school.task_1;

import ru.faang.school.task_1.Hero.Hero;
import ru.faang.school.task_1.Creature.*;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BattlefieldTest {

    private Hero firstHero;

    private Hero secondHero;

    private Hero thirdHero;

    private Hero fourthHero;

  @Before
   public void setUp(){
        firstHero = new Hero("First hero", "1", 1);
        firstHero.addCreature(new Angel(), 1);
        firstHero.addCreature(new Griffin(), 4);
        firstHero.addCreature(new Pikeman(), 3);
        firstHero.addCreature(new Swordman(), 5);

        secondHero = new Hero("Second hero", "2",1 );
        secondHero.addCreature(new Angel(), 10);
        secondHero.addCreature(new Griffin(), 4);
        secondHero.addCreature(new Pikeman(), 3);
        secondHero.addCreature(new Swordman(), 5);

        thirdHero = new Hero("Third Hero", "1", 1);
        thirdHero.addCreature(new Angel(), 30);

        fourthHero = new Hero("Fourth Hero", "2", 1);
        fourthHero.addCreature(new Griffin(), 110);
        fourthHero.addCreature(new Pikeman(), 150);
        fourthHero.addCreature(new Swordman(), 100);
    }

    @Test
   public void firstBattle() {
        Battlefield battlefield = new Battlefield(firstHero, secondHero);

        Hero winner = battlefield.battle();

        assertEquals(secondHero.getName(), winner.getName());
    }

    @Test
    public void secondBattle() {
        Battlefield battlefield = new Battlefield(thirdHero, fourthHero);

        Hero winner = battlefield.battle();

        assertEquals(fourthHero.getName(), winner.getName());
    }
}
