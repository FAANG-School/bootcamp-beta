package main.java.ru.faang.school.task_1;

import main.java.ru.faang.school.task_1.Creature.*;


public class Test {
    public static void main(String[]args){
        Hero hero1=new Hero("Hero","GoodMan");
        Hero hero2=new Hero("Villain","BadMan");

        hero1.addCreature(new Angel(),10000);
        hero1.addCreature(new Swordman(),10);

        hero2.addCreature(new Pikeman(),10);
        hero2.addCreature(new Griffin(),10);

        Battlefield battlefield=new Battlefield(hero1,hero2);

        System.out.println("The winner is - "+battlefield.battle().getName());

    }
}
