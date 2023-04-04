package ru.faang.school.task_1;

import ru.faang.school.task_1.creatures.Creature;
import ru.faang.school.task_1.heroes.Hero;

public class Battlefield {

    private Hero currentHero;
    private Hero waitingHero;

    public Battlefield(Hero leftHero, Hero rightHero) {
        this.currentHero = leftHero;
        this.waitingHero = rightHero;
    }

    public void battle() {
        while (true) {
            if (currentHero.getArmy().isEmpty() || waitingHero.getArmy().isEmpty()) {
                System.out.println(currentHero.getArmy().isEmpty() ? waitingHero.getName() : currentHero.getName());
                return;
            }

            creatureFight(currentHero, waitingHero);

            Hero tempHero = currentHero;
            currentHero = waitingHero;
            waitingHero = tempHero;
        }
    }

    private void creatureFight(Hero attackHero, Hero defensiveHero){
        Creature strongestCreature = attackHero.getArmy().peek();
        Creature defensiveCreature = defensiveHero.getArmy().peek();

        if (strongestCreature.getSquadDamage() < defensiveCreature.getSquadDamage()) {
            for (Creature creature : defensiveHero.getArmy()) {
                if (strongestCreature.getSquadDamage() > creature.getSquadDamage()) {
                    defensiveCreature = creature;
                    break;
                }
            }
        }

        defensiveCreature.takeDamage(strongestCreature.getSquadDamage());

        if (!defensiveCreature.isAlive()) {
            defensiveHero.removeCreature(defensiveCreature);
        }
    }
}
