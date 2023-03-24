public class Battlefield {
    public String battle(Hero hero1, Hero hero2) {
        int damage1 = 0;
        int damage2 = 0;
        if (hero1.getArmy().getDamage() > hero2.getArmy().getDamage()) {
            return hero1.getName();
        } else if (hero1.getArmy().getDamage() == hero2.getArmy().getDamage()){
            damage1 = hero1.getArmy().getDamage() + ((hero1.getExp() + hero1.getFraction()) * hero1.getLevel());
            damage2 = hero2.getArmy().getDamage() + ((hero2.getExp() + hero2.getFraction()) * hero2.getLevel());
            return (damage2>damage1)? hero2.getName() : hero1.getName();
        } else {
            return hero2.getName();
        }
    }
}

//Можно перегрузить метод и сделать возможность сражения большего количества героев
