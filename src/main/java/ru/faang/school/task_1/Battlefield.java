package ru.faang.school.task_1;

public class Battlefield {
    Hero hero1;
    Hero hero2;

    public Battlefield(Hero h1, Hero h2){
        this.hero1 = h1;
        this.hero2 = h2;
    }

    public void battle(){
        /*
        hits are made one by one
        one creature find one weakest(with lowest resistance) enemy to hit
        and hit him
        every round strongest creature make its hit
        with every hit he becomes more tired and his damage decreases by half
         */
        Hero first = hero2;
        Hero second = hero1;
        while(first.army.size() != 0 && second.army.size() != 0){
            //Swap heroes
            Hero tmp = first;
            first = second;
            second = tmp;

            Creature current = first.army.get(0);
            for(Creature entity : first.army)
                if(current.getDamage() < entity.getDamage())
                    current = entity;

            Creature enemy = second.army.get(0);
            for(Creature entity : second.army)
                if(enemy.getResistance() < entity.getResistance())
                    enemy = entity;
            if(current.getDamage() >= enemy.getResistance()) {
                second.removeCreature(enemy, 1);
                enemy.backUp();
                //if creature dies we should remember that another creatures are not tired
            }
            else{
                enemy.resistance -= current.damage;
                current.damage /= 2;
            }
        }
        Hero winner = first.army.size() != 0?first:second;
        addExp(winner);
        System.out.println(winner);
    }

    private void addExp(Hero winner){
        winner.exp++;
        if(winner.exp == 2){
            winner.exp = 0;
            winner.level++;
            System.out.println(winner.name + " : Level UP!!!");
        }
        for(Creature creature : winner.army)
            creature.levelUp();
    }
}
