package ru.faang.school.task_1;

public abstract class Creature {
    public Creature(String name, Integer level, Integer attack, Integer protection, Integer speed,
                    Integer health, Integer quantity) {
        this.name = name;
        this.level = level;
        this.attack = attack;
        this.protection = protection;
        this.speed = speed;
        this.health = health;
        this.quantity = quantity;
    }

    String name;
    Integer level;
    Integer attack;
    Integer protection;
    Integer speed;
    Integer health;
    Integer quantity;

    Integer getDamage(Integer h) {
        return h-attack;
    }
}
