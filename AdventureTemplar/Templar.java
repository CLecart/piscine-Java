public class Templar extends Character implements Healer, Tank {
    private final int healCapacity;
    private final int shield;

    public Templar(String name, int maxHealth, int healCapacity, int shield) {
        super(name, maxHealth);
        this.healCapacity = healCapacity;
        this.shield = shield;
    }

    @Override
    public int getHealCapacity() {
        return healCapacity;
    }

    @Override
    public int getShield() {
        return shield;
    }

    @Override
    public void heal(Character target) {
        int healed = target.getCurrentHealth() + healCapacity;
        if (healed > target.getMaxHealth()) {
            healed = target.getMaxHealth();
        }
        if (target instanceof Templar) {
            ((Templar) target).setCurrentHealth(healed);
        } else {
            // If Character has setCurrentHealth, use it; otherwise, use reflection or protected field
            // For now, assume setCurrentHealth exists
            target.setCurrentHealth(healed);
        }
    }

    @Override
    public String toString() {
        if (getCurrentHealth() == 0) {
            return getName() + " has been beaten, even with its " + shield + ". So bad, it could heal " + healCapacity + " HP.";
        }
        return getName() + " is a strong Templar with " + getCurrentHealth() + " HP. It can heal " + healCapacity + " HP and has a shield of " + shield + ".";
    }
}