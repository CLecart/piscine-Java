

public class Monster extends Character {
    public Monster(String name, int maxHealth, Weapon weapon) {
        super(name, maxHealth, weapon);
    }

    public void takeDamage(int amount) {
        int damageTaken = (int) (amount * 0.8);

        if (getCurrentHealth() - damageTaken < 0) {
            setCurrentHealth(0);
        } else {
            setCurrentHealth(getCurrentHealth() - damageTaken);
        }
    }

    public void attack(Character target) {
        if (getWeapon() != null) {
            target.takeDamage(getWeapon().getDamage());
        } else {
            target.takeDamage(7);
        }
    }

    @Override
    public String toString() {
        if (getCurrentHealth() == 0) {
            return getName() + " is a monster and is dead. He has the weapon " + getWeapon().getName() + "deals " + getWeapon().getDamage() + " damages.";
        }
        return getName() + " is a monster with " + getCurrentHealth() + " HP " + getWeapon().getName();
    }
}