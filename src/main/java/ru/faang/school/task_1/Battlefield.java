import java.util.HashMap;
import java.util.Map;

public class Battlefield {
    private Hero heroFirst;
    private Hero heroSecond;
    private Map<Creature, Integer> armyFirst;
    private Map<Creature, Integer> armySecond;

    public void heroOneInfo(Hero heroFirst, Map<Creature, Integer> armyFirst){
        this.heroFirst = heroFirst;
        this.armyFirst = armyFirst;
    }

    private void heroTwoInfo(Hero heroSecond, Map<Creature, Integer> armySecond) {
        this.heroSecond = heroSecond;
        this.armySecond = armySecond;
    }

    public String battle(){
        //first side
        int damage1 = 0;
        for (Map.Entry<Creature, Integer> entry : armyFirst.entrySet()){
            damage1 += entry.getKey().getDamage() * entry.getValue();
        }
        //second side
        int damage2 = 0;
        for (Map.Entry<Creature, Integer> entry : armySecond.entrySet()){
            damage2 += entry.getKey().getDamage() * entry.getValue();
        }
        if (damage1 == damage2) {
            return "draw!";
        }
        return damage1 > damage2 ? heroFirst.getName() : heroSecond.getName();
    }

    public static void main(String[] args) {
        Battlefield battlefield = new Battlefield();
        //first hero
        Hero hero1 = new Hero("Vlad", "Uber", 6, 26);
        hero1.addCreature(new Angel(), 2);
        hero1.addCreature(new Griffin(), 1);
        hero1.addCreature(new Pikeman(), 4);
        battlefield.heroOneInfo(hero1, hero1.getArmy());
        //second hero
        Hero hero2 = new Hero("Maclo", "Lolz", 1, 17);
        hero2.addCreature(new Swordman(), 1);
        hero2.addCreature(new Griffin(), 2);
        hero2.addCreature(new Pikeman(), 3);
        battlefield.heroTwoInfo(hero2, hero2.getArmy());
        //battle!!!
        System.out.println(battlefield.battle());
    }

}
