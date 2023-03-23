package ru.faang.school.task_1.creature.warriors;

public abstract class Creature {
    private String name;
    private Integer level;
    private Integer hitLevel;
    private Integer protectLevel;
    private Integer speed;
    private Integer squad;

    protected Creature(String name, Integer level, Integer hitLevel, Integer protectLevel, Integer speed, Integer squad) {
        this.name = name;
        this.level = level;
        this.hitLevel = hitLevel;
        this.protectLevel = protectLevel;
        this.speed = speed;
        this.squad = squad;
    }

    public Integer getDamage() {
        return hitLevel;
    }

    @Override
    public String toString() {
        return "Creature{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public Integer getLevel() {
        return level;
    }

    public Integer getHitLevel() {
        return hitLevel;
    }

    public Integer getProtectLevel() {
        return protectLevel;
    }

    public Integer getSpeed() {
        return speed;
    }

    public Integer getSquad() {
        return squad;
    }

    public void setSquad(Integer squad) {
        this.squad = squad;
    }
}
