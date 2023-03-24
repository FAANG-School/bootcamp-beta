package ru.faang.school;

public class Hero {
    String name;
    String fraction;
    String experience;
    int level;

    public Hero(String name, String fraction, String experience, int level) {
        this.name = name;
        this.fraction = fraction;
        this.experience = experience;
        this.level = level;
    }

    public void addCreature(Creature creature, int quantity) {
        System.out.println("Добавить существ в армию героя");
    }
    public void removeCreature(Creature creature, int quantity) {
        System.out.println("Удалить существ из армии героя.");
    }
    public int getArmy() {
        System.out.println("Получить список всех существ в армии героя.");
        return 0;
    }

}
