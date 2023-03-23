package run.faang.school.task_1.battlefield;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ru.faang.school.task_1.battlefield.Battlefield;
import ru.faang.school.task_1.creature.Angel;
import ru.faang.school.task_1.creature.Creature;
import ru.faang.school.task_1.creature.Griffin;
import ru.faang.school.task_1.creature.Swordsman;
import ru.faang.school.task_1.hero.Hero;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BattlefieldTest {
    private Hero hero1;
    private Hero hero2;
    private Battlefield battlefield;

    @BeforeEach
    void setUp() {
        hero1 = new Hero("Hero1", "Fraction1", 1, 1);
        hero1.addCreature(new Angel(100, 3), 100);

        hero2 = new Hero("Hero2", "Fraction2", 1, 1);
        hero2.addCreature(new Swordsman(100, 4), 100);

        battlefield = new Battlefield(hero1, hero2);
    }

    @Test
    void testBattle() {
        hero2 = new Hero("Hero2", "Fraction2", 5, 999);
        hero2.addCreature(new Swordsman(1000, 999), 1000);

        battlefield = new Battlefield(hero1, hero2);

        Optional<Hero> winnerOption = battlefield.battle();
        Assertions.assertTrue(winnerOption.isPresent());
        assertEquals(winnerOption.get(), hero2);

        assertEquals(hero1.getArmySize(), 0);
    }

    @Test
    void testPickRandomHero() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method pickRandomHero = BattlefieldReflector.getDeclaredMethodWithoutArguments("pickRandomHero");
        Hero randomHero = (Hero) pickRandomHero.invoke(battlefield);
        Assertions.assertTrue(randomHero.equals(hero1) || randomHero.equals(hero2));
    }

    @Test
    void testPickOpposingHero() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method pickOpposingHero = BattlefieldReflector.getDeclaredMethodWithTypeArguments("pickOpposingHero", Hero.class);
        Hero opposingHero = (Hero) pickOpposingHero.invoke(battlefield, hero1);
        assertEquals(opposingHero, hero2);
    }

    @Test
    void testPickRandomCreature() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method pickRandomCreature = BattlefieldReflector.getDeclaredMethodWithTypeArguments("pickRandomCreature", Map.class);
        Creature randomCreature = (Creature) pickRandomCreature.invoke(battlefield, hero1.getArmy());
        Assertions.assertTrue(hero1.getArmy().containsKey(randomCreature));
    }

    @ParameterizedTest
    @CsvSource({"70,6,9","50,4,6", "20,2,3"})
    void testCalculateCreatureQuantityAfterHit(int damage, int expectedKilledSwordsmans, int expectedKilledGriffins) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method calculateCreatureQuantityAfterHit = Battlefield.class.getDeclaredMethod("calculateCreatureQuantityAfterHit", Creature.class, int.class);

        Battlefield battlefield = new Battlefield(hero1, hero2);
        int killedSwordsmanCreatures = (int) calculateCreatureQuantityAfterHit.invoke(battlefield, new Swordsman(70, 2), damage);
        assertEquals(expectedKilledSwordsmans, killedSwordsmanCreatures);

        int killedAngelCreatures = (int) calculateCreatureQuantityAfterHit.invoke(battlefield, new Griffin(70, 2), damage);
        assertEquals(expectedKilledGriffins, killedAngelCreatures);
    }


    @Test
    void testPerformAttack() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method performAttack = BattlefieldReflector.getDeclaredMethodWithTypeArguments("performAttack", Hero.class, Hero.class);

        Creature attackingCreature = new Swordsman(70, 4);
        Creature defendingCreature = new Angel(70, 4);

        Hero attacker = new Hero("Attacker", "Attacker Fraction", 1, 1);
        Hero defender = new Hero("Defender", "Defender Fraction", 1, 1);

        attacker.addCreature(attackingCreature, attackingCreature.getQuantity());
        defender.addCreature(defendingCreature, defendingCreature.getQuantity());

        performAttack.invoke(battlefield, attacker, defender);

        Assertions.assertNotEquals(attacker.getArmy().get(defendingCreature), 70);
        Assertions.assertNotEquals(defender.getArmy().get(defendingCreature), 70);
    }

    @Test
    void testGetWinner() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method getWinner = BattlefieldReflector.getDeclaredMethodWithTypeArguments("getWinner", Hero.class, Hero.class);
        hero1.removeCreature(hero1.getArmy().keySet().iterator().next(), 1000);
        Optional<Hero> winner = (Optional<Hero>) getWinner.invoke(battlefield, hero1, hero2);
        Assertions.assertTrue(winner.isPresent());
        assertEquals(winner.get(), hero2);
    }

    @Test
    void testIsBattleOverWithBothArmies() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Method isBattleOver = BattlefieldReflector.getDeclaredMethodWithTypeArguments("isBattleOver", Hero.class, Hero.class);
        Assertions.assertFalse((Boolean) isBattleOver.invoke(battlefield, hero1, hero2));
    }
}