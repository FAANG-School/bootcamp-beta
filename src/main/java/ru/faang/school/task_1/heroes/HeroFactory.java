package ru.faang.school.task_1.heroes;

public class HeroFactory {

    public static Hero createHero(Fraction fraction, String name) {
        return switch (fraction) {
            case CASTLE -> new Hero(Fraction.CASTLE, name);
            case CITADEL -> new Hero(Fraction.CITADEL, name);
            case CONFLUX -> new Hero(Fraction.CONFLUX, name);
            case DUNGEON -> new Hero(Fraction.DUNGEON, name);
            case FORTRESS -> new Hero(Fraction.FORTRESS, name);
            case INFERNO -> new Hero(Fraction.INFERNO, name);
            case NECROPOLIS -> new Hero(Fraction.NECROPOLIS, name);
            case TOWER -> new Hero(Fraction.TOWER, name);
            case RAMPART -> new Hero(Fraction.RAMPART, name);
        };
    }

}
