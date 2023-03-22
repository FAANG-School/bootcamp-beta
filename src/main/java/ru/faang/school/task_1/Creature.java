public abstract class Creature {
    private String name;
    private int level;
    private int attack;
    private int def;
    private int speed;
    private int count;

    public Creature(String name, int level, int attack, int def, int speed, int count) {
        this.name = name;
        this.level = level;
        this.attack = attack;
        this.def = def;
        this.speed = speed;
        this.count = count;
    }

    public int getDamage(){
        return attack;
    }



}
