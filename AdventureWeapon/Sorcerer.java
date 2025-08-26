public class Sorcerer extends Character implements Healer {
    private final int healCapacity;

    public Sorcerer(String name, int maxHealth, final int healCapacity, Weapon weapon) {
        super(name, maxHealth, weapon);
        this.healCapacity = healCapacity;
    }

    @Override
    public int getHealCapacity() {
        return healCapacity;
    }

    @Override
    public void heal(Character target) {

        int healed = target.getCurrentHealth() + healCapacity;
        if (healed > target.getMaxHealth()) {
            healed = target.getMaxHealth();
        }

        target.setCurrentHealth(healed);
    }

    public void takeDamage(int amount) {
        int damageTaken = (int) (amount);

        if (getCurrentHealth() - damageTaken < 0) {
            setCurrentHealth(0);
        } else {
            setCurrentHealth(getCurrentHealth() - damageTaken);
        }
    }

    public void attack(Character target) {

        target.takeDamage(10);
        this.heal(this);
    }

    @Override
    public String toString() {
        if (getCurrentHealth() == 0) {
            return getName() + " is a dead sorcerer. So bad, it could heal " + healCapacity + " HP.";
        }
        return getName() + " is a sorcerer with " + getCurrentHealth() + " HP. It can heal " + healCapacity + " HP.";
    }
}