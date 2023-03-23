package run.faang.school.task_1.battlefield;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.faang.school.task_1.battlefield.Battlefield;
import ru.faang.school.task_1.creature.Angel;
import ru.faang.school.task_1.creature.Creature;
import ru.faang.school.task_1.creature.Swordsman;
import ru.faang.school.task_1.hero.Hero;

import java.util.Optional;

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
		Assertions.assertEquals(winnerOption.get(), hero2);

		Assertions.assertEquals(hero1.getArmySize(), 0);
	}

	@Test
	void testPickRandomHero() {
		Hero randomHero = battlefield.pickRandomHero();
		Assertions.assertTrue(randomHero.equals(hero1) || randomHero.equals(hero2));
	}

	@Test
	void testPickOpposingHero() {
		Hero opposingHero = battlefield.pickOpposingHero(hero1);
		Assertions.assertEquals(opposingHero, hero2);
	}

	@Test
	void testPickRandomCreature() {
		Creature randomCreature = battlefield.pickRandomCreature(hero1.getArmy());
		Assertions.assertTrue(hero1.getArmy().containsKey(randomCreature));
	}

	@Test
	void testCalculateCreatureQuantityAfterHit() {
		int killedSwordsmanCreatures = battlefield.calculateCreatureQuantityAfterHit(new Swordsman(70, 4), 70);
		Assertions.assertEquals(killedSwordsmanCreatures, 6);

		int killedAngelCreatures = battlefield.calculateCreatureQuantityAfterHit(new Angel(70, 4), 70);
		Assertions.assertEquals(killedAngelCreatures, 6);
	}

	@Test
	void testPerformAttack() {
		Creature attackingCreature = new Swordsman(70, 4);
		Creature defendingCreature = new Angel(70, 4);

		Hero attacker = new Hero("Attacker", "Attacker Fraction", 1, 1);
		Hero defender = new Hero("Defender", "Defender Fraction", 1, 1);

		attacker.addCreature(attackingCreature, attackingCreature.getQuantity());
		defender.addCreature(defendingCreature, defendingCreature.getQuantity());

		battlefield.performAttack(attacker, defender);

		Assertions.assertNotEquals(attacker.getArmy().get(defendingCreature), 70);
		Assertions.assertNotEquals(defender.getArmy().get(defendingCreature), 70);
	}

	@Test
	void testGetWinner() {
		hero1.removeCreature(hero1.getArmy().keySet().iterator().next(), 1000);
		Optional<Hero> winner = battlefield.getWinner(hero1, hero2);
		Assertions.assertTrue(winner.isPresent());
		Assertions.assertEquals(battlefield.getWinner(hero1, hero2).get(), hero2);
	}

	@Test
	void testIsBattleOverWithBothArmies() {
		Assertions.assertFalse(battlefield.isBattleOver(hero1, hero2));
	}
}