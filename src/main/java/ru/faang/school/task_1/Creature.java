package ru.faang.school.task_1;
import java.util.ArrayList;
public abstract class Creature {

    public static ArrayList<Creature> creatures = new ArrayList<>();

    Creature() {
        creatures.add(this);
    }

    private String name;
    private int level;
    private float attack;
    private float defense;
    private float speed;
    private int quantity;

    public enum Fraсtion {
        Pikeman, Griffin, Swordman, Angel;
    }

    public float getDamage() {
        return attack * quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public float getAttack() {
        return attack;
    }

    public void setAttack(float attack) {
        this.attack = attack;
    }

    public float getDefense() {
        return defense;
    }

    public void setDefense(float defense) {
        this.defense = defense;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
