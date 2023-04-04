public abstract class Creature {
    private String name;
    private int level;
    private int attack;
    private int protection;
    private int speed;
    private int amount;

    abstract int getDamage();

    public String getName() { return name; }

    public int getLevel() { return level; }

    public int getAttack() { return attack; }

    public int getProtection() { return protection; }

    public int getSpeed() { return speed; }

    public int getAmount() { return amount; }

}
