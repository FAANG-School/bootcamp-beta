public class Angel extends Creature {
    @Override
    public String getName() {
        return "Angel";
    }

    @Override
    public int getLevel() { return 7; }

    @Override
    public int getAttack() { return 20; }

    @Override
    public int getProtection() {
        return 20;
    }

    @Override
    public int getSpeed() {
        return 12;
    }

    @Override
    public int getAmount() { return 1; }

    @Override
    int getDamage() {
        return getAmount()*getSpeed()*getAttack();
    }

}
