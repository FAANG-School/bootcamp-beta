package ru.faang.school.task_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BattlefieldTest {

    @Test
    void battle() {
        Battlefield battlefield = new Battlefield();
        Hero h1 = new Hero();
        h1.addCreature( new Angel(), 2);
        h1.addCreature(new Griffin(), 100);
        Hero h2 = new Hero();
        h2.addCreature( new Pikeman(), 1);

        assertEquals(h1, battlefield.battle(h1, h2));
    }
}