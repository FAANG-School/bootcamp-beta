package ru.faang.school.task_1.test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.faang.school.task_1.Battlefield;
import ru.faang.school.task_1.creature.Angel;
import ru.faang.school.task_1.creature.Griffin;
import ru.faang.school.task_1.creature.Pikeman;
import ru.faang.school.task_1.creature.Swordman;
import ru.faang.school.task_1.hero.Faction;
import ru.faang.school.task_1.hero.Hero;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.SimpleFormatter;

class BattleTest {

    private Hero initMullich() {
        Hero mullich = new Hero("Sir Mullich",
                Faction.CASTLE,
                500,
                1,
                2,
                2);

        mullich.addCreature(new Angel(1), 1);
        mullich.addCreature(new Swordman(1), 10);
        mullich.addCreature(new Griffin(1), 15);
        mullich.addCreature(new Pikeman(1), 50);

        return mullich;
    }

    private Hero initCatherine() {
        Hero catherine = new Hero("Catherine",
                Faction.CASTLE,
                200,
                3,
                4,
                3);

        catherine.addCreature(new Swordman(1), 40);
        catherine.addCreature(new Griffin(1), 10);
        catherine.addCreature(new Pikeman(1), 25);
        catherine.addCreature(new Pikeman(1), 25);

        return catherine;
    }

    private Hero initEdric() {
        Hero edric = new Hero("Edric",
                Faction.CASTLE,
                199,
                5,
                3,
                8);

        edric.addCreature(new Griffin(1), 30);
        edric.addCreature(new Griffin(1), 10);
        edric.addCreature(new Griffin(1), 10);
        edric.addCreature(new Swordman(1), 16);
        edric.addCreature(new Pikeman(1), 55);

        return edric;
    }

    @BeforeAll
    static void loggerInit() {
        Level level = Level.WARNING;

        ConsoleHandler handler = new ConsoleHandler();
        handler.setLevel(level);
        handler.setFormatter(new SimpleFormatter());

        Battlefield.logger.setLevel(level);
        Battlefield.logger.addHandler(handler);
    }

    @Test
    @DisplayName("Sir Mullich VS Catherine")
    void battle1() {
        Battlefield battlefield = new Battlefield(initMullich(), initCatherine());
        battlefield.battle();
    }

    @Test
    @DisplayName("Sir Mullich VS Edric")
    void battle2() {
        Battlefield battlefield = new Battlefield(initMullich(), initEdric());
        battlefield.battle();
    }

    @Test
    @DisplayName("Catherine VS Sir Mullich")
    void battle3() {
        Battlefield battlefield = new Battlefield(initCatherine(), initMullich());
        battlefield.battle();
    }

    @Test
    @DisplayName("Catherine VS Edric")
    void battle4() {
        Battlefield battlefield = new Battlefield(initCatherine(), initEdric());
        battlefield.battle();
    }

    @Test
    @DisplayName("Edric VS Sir Mullich")
    void battle5() {
        Battlefield battlefield = new Battlefield(initEdric(), initMullich());
        battlefield.battle();
    }

    @Test
    @DisplayName("Edric VS Catherine")
    void battle6() {
        Battlefield battlefield = new Battlefield(initMullich(), initCatherine());
        battlefield.battle();
    }

}
