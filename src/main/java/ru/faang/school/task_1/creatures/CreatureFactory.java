package ru.faang.school.task_1.creatures;

public class CreatureFactory {

    public static Creature getCreature(CreatureType creatureType, int count) {
        return switch (creatureType) {
            case ANGEL -> new Angel(count);
            case PIKEMAN -> new Pikeman(count);
            case GRIFFIN -> new Griffin(count);
            case SWORDSMAN -> new Swordman(count);
        };
    }
}
