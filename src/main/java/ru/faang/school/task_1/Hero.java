import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Hero {
    private String name;
    private String fraction;
    private int experience;
    private int level;
    private Map<Creature, Integer> chaps = new HashMap<>();

    public Hero(String name, String fraction, int experience, int level) {
        this.name = name;
        this.fraction = fraction;
        this.experience = experience;
        this.level = level;
    }

    public void addCreature(Creature creature, int quantity){
        int count;
        count = chaps.getOrDefault(creature, 0);
        chaps.put(creature, quantity + count);
    }

    public void removeCreature(Creature creature, int quantity){
        int count;
        count = chaps.getOrDefault(creature, 0);
        if (quantity >= count) {
            chaps.remove(creature, 0);
        }else {
            chaps.remove(creature, count - quantity);
        }
    }

    public Map<Creature, Integer> getArmy(){
        return chaps;
    }

    public String getName() {
        return name;
    }
}
