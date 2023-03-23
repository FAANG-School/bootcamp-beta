package ru.faang.school.task_1;

import java.util.Objects;

public abstract class Creature {
    private String name;
    private String level;
    private Integer attack;
    private Integer defend;
    private Integer speed;
    private Integer healthPoints;
    private Integer health;

    public Creature(String name, String level, Integer attack, Integer defend, Integer speed, Integer health) {
        this.name = name;
        this.level = level;
        this.attack = attack;
        this.defend = defend;
        this.speed = speed;
        this.health = health;
        this.healthPoints = health;
    }


    public Integer getDamage() {
        return attack;
    }

    public void setHealthPoints(Integer healthPoints) {
        this.healthPoints = healthPoints;
    }

    public Integer getHealthPoints() {
        return healthPoints;
    }

    public Integer getHealth() {
        return health;
    }

    public Integer getDefend() {
        return defend;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Creature creature = (Creature) o;
        return name.equals(creature.name) && level.equals(creature.level);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, level);
    }

}
