package ru.faang.school.task_1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HeroesTest {
    @Test
    public void whenFirstHeroWin() {
        Hero firstHero = new Hero("Ариэль", "Добро", 0, 0);
        Hero secondHero = new Hero("Джезебель", "Зло", 0, 0);
        firstHero.addCreature(new Angel(), 4);
        secondHero.addCreature(new Griffin(), 5);
        Battlefield battlefield = new Battlefield(firstHero, secondHero);
        Assertions.assertEquals(battlefield.battle(), firstHero);
    }

    @Test
    public void whenSecondHeroWin() {
        Hero firstHero = new Hero("Ариэль", "Добро", 0, 0);
        Hero secondHero = new Hero("Джезебель", "Зло", 0, 0);
        Battlefield battlefield = new Battlefield(firstHero, secondHero);
        Assertions.assertEquals(battlefield.battle(), secondHero);
    }
}
