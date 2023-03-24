public class Swordman extends Creature {
    @Override
    public String getName() {
        return "Swordman";
    }

    @Override
    public int getLevel() {
        return 4;
    }

    @Override
    public int getAttack() { return 10; }

    @Override
    public int getProtection() {
        return 12;
    }

    @Override
    public int getSpeed() {
        return 5;
    }

    @Override
    public int getAmount() { return 4; }
    @Override
    int getDamage() {
        return getAmount()*getSpeed()*getAttack();
    }


}
