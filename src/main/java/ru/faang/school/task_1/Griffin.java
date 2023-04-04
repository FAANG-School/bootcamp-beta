public class Griffin extends Creature {

    @Override
    public String getName() {
        return "Griffin";
    }

    @Override
    public int getLevel() {
        return 3;
    }

    @Override
    public int getAttack() {
        return 8;
    }

    @Override
    public int getProtection() {
        return 8;
    }

    @Override
    public int getSpeed() {
        return 6;
    }

    @Override
    public int getAmount() {
        return 7;
    }
    @Override
    int getDamage() {
        return getAmount()*getSpeed()*getAttack();
    }


}
