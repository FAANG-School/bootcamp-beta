package ru.faang.school.task_1;

import java.util.Objects;
import java.util.Stack;

public class Hero {
    private String name;
    private String fraction;
    private int experience;
    private int level;
    private Stack<Creature> army = new Stack<>();
    private int totalArmyHealth;

    public Hero(String name, String fraction, int level) {
        if(name == null || name.isEmpty() || name.isBlank()){
            this.name = "Unknown";
        }
        else if(name.length() > 16){
            this.name = name.substring(0, 17);
        }
        else
            this.name = name;

        if(fraction == null || fraction.isEmpty() || fraction.isBlank()){
            this.fraction = "Unknown";
        }
        else if(fraction.length() > 16){
            this.fraction = fraction.substring(0, 17);
        }
        else
            this.fraction = fraction;

        if(level <= 0)
            this.level = 1;
        else
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

    public void setExperience(int experience) {
        if(experience < 0)
            experience = 0;

        int levelIncrease = (experience + this.experience) / 1000;
        level += levelIncrease;
        this.experience += experience - 1000 * levelIncrease;

    }

    public int getLevel() {
        return level;
    }

    public int getAverageSpeed() {
        int averageSpeed = 0;
        for(Creature c: army){
            averageSpeed += c.getSpeed();
        }
        return averageSpeed / army.size();
    }

    public int getTotalArmyHealth() {
        return totalArmyHealth;
    }

    public Stack<Creature> getArmy(){
        return army;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hero hero = (Hero) o;
        return level == hero.level && Objects.equals(name, hero.name) && Objects.equals(fraction, hero.fraction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, fraction, level);
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", fraction='" + fraction + '\'' +
                ", level=" + level +
                '}';
    }

    /*
     * Один объект Creature равен одному отряду.
     * Количество юнитов в отряде контролируется
     * полем quantity
     */
    public void addCreature(Creature creature, int quantity){
        creature.setQuantity(quantity);
        army.push(creature);

        totalArmyHealth += creature.getTotalSquadHealth();
    }

    /*
     * Отряд живет, если после атаки поле quantity больше 0,
     * иначе убираем отряд(объект Creature) из стека
     */
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
}
