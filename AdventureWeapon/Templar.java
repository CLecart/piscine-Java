public class Templar extends Character implements Healer, Tank {
    private final int healCapacity;
    private final int shield;

    public Templar(String name, int maxHealth, int healCapacity, int shield, Weapon weapon) {
        super(name, maxHealth, weapon);
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
            target.setCurrentHealth(healed);
        }
    }

    public void takeDamage(int amount) {
        int damageTaken = (int) amount - shield;

        if (damageTaken < 0) {
            return;
        }

        if (getCurrentHealth() - damageTaken < 0) {
            setCurrentHealth(0);
        } else {
            setCurrentHealth(getCurrentHealth() - damageTaken);
        }
    }

    public void attack(Character target) {
        this.heal(this);
        if (target.getWeapon() != null) {
            target.takeDamage(getWeapon().getDamage());
        }
        target.takeDamage(6);

    }

    @Override
    public String toString() {
        if (getCurrentHealth() == 0) {
            return getName() + " has been beaten, even with its " + shield + " shield. So bad, it could heal " + healCapacity + " HP.";
        }
        return getName() + " is a strong Templar with " + getCurrentHealth() + " HP. It can heal " + healCapacity + " HP and has a shield of " + shield + ". He has the weapon " + getWeapon().getName() + " deals " + getWeapon().getDamage() + " damages.";
    }
}