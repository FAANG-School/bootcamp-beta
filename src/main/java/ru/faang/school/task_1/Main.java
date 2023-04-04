public class Main {
    public static void main(String[] args) {
        Battlefield battlefield = new Battlefield();
        Hero hero1 = new Hero("Vlad", 2, 4, 2);
        Hero hero2 = new Hero("Sergey", 2,1, 5);

        hero1.addCreature(new Angel(), 1);
        hero1.addCreature(new Pikeman(), 4);

        hero2.addCreature(new Swordman(), 3);
        hero2.addCreature(new Griffin(), 2);

        System.out.println("Won " + battlefield.battle(hero1, hero2));

    }
}