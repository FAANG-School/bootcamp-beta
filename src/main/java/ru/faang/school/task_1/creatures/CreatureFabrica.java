package ru.faang.school.task_1.creatures;

public class CreatureFabrica {

public Creature createCreature(CreatureType type, int quantity){
    Creature creature = null;
    creature = switch (type){
        case ANGEL -> new Angel(quantity);
        case GRIFFIN -> new Griffin(quantity);
        case PIKEMAN -> new Pikeman(quantity);
        case SWORDSMAN -> new Swordsman(quantity);
    };
    return creature;
}

}
