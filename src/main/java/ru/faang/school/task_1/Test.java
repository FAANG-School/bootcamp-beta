package ru.faang.school.task_1;

public class Test {
    public static void main(String[] args) {
        Hero h1 = new Hero("Christian", "Castle");
        Hero h2 = new Hero("Edric", "Castle");

        h1.addCreature(new Pikeman(), 150);
        h1.addCreature(new Archer(), 100);
        h1.addCreature(new Griffin(), 50);
        h1.addCreature(new Swordsman(), 30);
        h1.addCreature(new Monk(), 12);
        h1.addCreature(new Cavalier(), 5);
        h1.addCreature(new Angel(), 2);

        h2.addCreature(new Pikeman(), 150);
        h2.addCreature(new Archer(), 100);
        h2.addCreature(new Griffin(), 50);
        h2.addCreature(new Swordsman(), 30);
        h2.addCreature(new Monk(), 12);
        h2.addCreature(new Cavalier(), 5);
        h2.addCreature(new Angel(), 4);

        /*System.out.println("First hero army:");
        h1.getArmy();
        System.out.println();
        System.out.println("Second hero army:");
        h2.getArmy();

        h2.removeCreature(new Angel(), 4);
        h2.getArmy();*/

        BattleField battleField = new BattleField(h1,h2);
        battleField.battle();
    }
}
