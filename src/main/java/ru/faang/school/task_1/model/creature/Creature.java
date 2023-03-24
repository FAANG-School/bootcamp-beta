package ru.faang.school.task_1.model.creature;

public abstract class Creature {

    private final String name;

    private final Integer level;

    private final Double attack;

    private final Double defense;

    private Double speed;

    private Integer quantity;

    private Double health;

    private boolean isAlive = true;

    protected Creature(String name, Integer level, Double attack, Double defense, Double speed, Integer quantity, Double health) {
        this.name = name;
        this.level = level;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.quantity = quantity;
        this.health = health;
    }

    public void updateInformation(Double enemyDamage) {
        double deadUnit = (enemyDamage - defense) / health;
        this.quantity = quantity - (int) deadUnit;
        if (quantity <= 0) {
            isAlive = false;
        }
    }

    public abstract Double getDamage();

    public String getName() {
        return name;
    }

    public Integer getLevel() {
        return level;
    }

    public Double getAttack() {
        return attack;
    }

    public Double getDefense() {
        return defense;
    }

    public Double getSpeed() {
        return speed;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getHealth() {
        return health;
    }

    public boolean isDead() {
        return !isAlive;
    }
}
