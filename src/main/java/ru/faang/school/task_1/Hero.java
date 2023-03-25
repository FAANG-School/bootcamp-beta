package ru.faang.school.task_1;

import java.util.Stack;

public class Hero {
    private String name;
    private String fraction;
    private int experience; //по умолчанию 0. В конструкторе не устанавливаем. Лень думать логику потолка для опыта.
    private int level;
    private Stack<Creature> army = new Stack<>();
    private int totalSpeed; //Из этого поля получаем среднюю скорость армии через геттер. Логика: Кто быстрее придет на поле боя, тот первый и атакует
    private int totalHealth; //Нужно, чтобы конвертировать здоровье проигравшей армии в очки опыта для победившего героя. 1 hp = 1 exp


    public Hero(String name, String fraction, int level) {
        this.name = name;
        this.fraction = fraction;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public String getFraction() {
        return fraction;
    }

    public int getExperience() {
        return experience;
    }

    public int getLevel() {
        return level;
    }

    public void setExperience(int experience) {
        this.experience = experience;

    }

    public void setLevel(int level) {
        this.level += level;
    }

    public int getAverageSpeed() {
        return totalSpeed / army.size();
    }

    public int getTotalHealth() {
        return totalHealth;
    }


    /*Один объект Creature равен одному отряду.
     * Количество юнитов в отряде контролируется
     * полем quantity*/
    public void addCreature(Creature creature, int quantity){
        creature.setQuantity(quantity);
        army.push(creature);

        totalSpeed += creature.getSpeed();
        totalHealth += creature.getTotalHealth();
    }

    /*Отряд живет, если после атаки поле quantity больше 0,
     * иначе убираем отряд(объект Creature) из стека*/
    public void removeCreature(Creature creature, int quantity){
        int numberOfAliveInSquad = creature.getQuantity() - quantity;

        if(numberOfAliveInSquad > 0) {
            creature.setQuantity(numberOfAliveInSquad);
            System.out.printf("Number of units in %s squad: %d\n", creature.getName(), numberOfAliveInSquad);
        }
        else {
            System.out.printf("%s's %s squad is dead\n", this.getName(), creature.getName());
            army.pop();
        }
    }

    public Stack<Creature> getArmy(){
        return army;
    }
}
