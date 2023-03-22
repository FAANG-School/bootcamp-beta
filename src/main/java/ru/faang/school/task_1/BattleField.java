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
        if(Math.round(Math.random()*2)==1){
            System.out.println(getHero1().getName() + " won!");
            return getHero1();
        } else {
            System.out.println(getHero2().getName() + " won!");
            return getHero2();
        }
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
