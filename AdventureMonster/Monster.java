public class Monster extends Character {
    public Monster(String name, int maxHealth) {
        super(name, maxHealth);
    }

    @Override
    public String toString() {
        if (getCurrentHealth() == 0) {
            return getName() + " : is a monster and is dead";
        }
        return getName() + " : is a monster with " + getMaxHealth() + " HP";
    }
}