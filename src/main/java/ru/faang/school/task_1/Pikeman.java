public class Pikeman extends Creature {
    @Override
    public String getName() {
        return "Pikeman";
    }

    @Override
    public int getLevel() {
        return 1;
    }

    @Override
    public int getAttack() {
        return 4;
    }

    @Override
    public int getProtection() {
        return 5;
    }

    @Override
    public int getSpeed() {
        return 4;
    }

    @Override
    public int getAmount() {
        return 14;
    }

    @Override
    int getDamage() {
        return getAmount()*getSpeed()*getAttack();
    }


}
