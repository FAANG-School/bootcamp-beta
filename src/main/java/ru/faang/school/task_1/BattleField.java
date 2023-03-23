package ru.faang.school.task_1;

public class BattleField {
    private Hero hero1;
    private Hero hero2;

    public BattleField(Hero hero1, Hero hero2) {
        setHero1(hero1);
        setHero2(hero2);
    }

    public Hero battle() {
        System.out.println(getHero1().getName() + " and " + getHero2().getName() + " are preparing to battle!");

        int hero1ArmySize = getHero1().getArmy().size();
        int hero2ArmySize = getHero2().getArmy().size();
        int turnDecider = 1;
        while (hero1ArmySize != 0 && hero2ArmySize != 0) {

            Creature currentCreatureToGetDamage;
            Creature currentCreatureToCauseDamage;
            if (turnDecider % 2 == 0) {
                currentCreatureToGetDamage = getHero2().getArmy().get((int) (Math.floor(Math.random() * hero2ArmySize)));
                currentCreatureToCauseDamage = getHero1().getArmy().get((int) (Math.floor(Math.random() * hero1ArmySize)));
                int takenDamage = currentCreatureToGetDamage.getDamage(currentCreatureToCauseDamage, getHero2());
                System.out.println(currentCreatureToGetDamage + " get " + takenDamage + " damage!");

            } else {
                currentCreatureToGetDamage = getHero1().getArmy().get((int) (Math.floor(Math.random() * hero1ArmySize)));
                currentCreatureToCauseDamage = getHero2().getArmy().get((int) (Math.floor(Math.random() * hero2ArmySize)));
                int takenDamage = currentCreatureToGetDamage.getDamage(currentCreatureToCauseDamage, getHero1());
                System.out.println(currentCreatureToGetDamage + " get " + takenDamage + " damage!");
            }
            System.out.println("Turn number " + turnDecider++);
            hero1ArmySize = getHero1().getArmy().size();
            hero2ArmySize = getHero2().getArmy().size();
        }
        return hero1ArmySize == 0 ? hero2 : hero1;
    }

    public Hero getHero1() {
        return hero1;
    }

    public void setHero1(Hero hero1) {
        this.hero1 = hero1;
    }

    public Hero getHero2() {
        return hero2;
    }

    public void setHero2(Hero hero2) {
        this.hero2 = hero2;
    }
}
