import java.util.ArrayList;
import java.util.List;

public abstract class Character {
    private final String name;
    private final int maxHealth;
    private int currentHealth;
    private Weapon weapon;

    private static List<Character> allCharacters = new ArrayList<>();

    public Character(String name, int maxHealth, Weapon weapon) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.weapon = weapon;
        allCharacters.add(this);

    }

    public String getName() {
        return name;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    protected void setCurrentHealth(int health) {
        this.currentHealth = health;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public boolean hasWeapon() {
        return weapon != null;
    }

    @Override
    public String toString() {
        if (currentHealth == 0) {
            return name + " : KO";
        }
        return name + " : " + currentHealth + "/" + maxHealth;
    }

    public abstract void takeDamage(int amount) throws DeadCharacterException;


    public abstract void attack(Character target) throws DeadCharacterException;

    public static String printStatus() {
        String border = "------------------------------------------";
        if (allCharacters.isEmpty()) {
            return border + "\nNobody's fighting right now !\n" + border + "\n";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(border).append("\n");
            sb.append("Characters currently fighting :\n");
            for (Character character : allCharacters) {
                sb.append(" - ").append(character.toString()).append("\n");
            }
            sb.append(border).append("\n");
            return sb.toString();
        }
    }

    public static Character fight(Character c1, Character c2) {
        while (c1.currentHealth > 0 && c2.currentHealth > 0) {
            try {
                c1.attack(c2);
                if (c2.currentHealth == 0) return c1;
                c2.attack(c1);
                if (c1.currentHealth == 0) return c2;
            } catch (DeadCharacterException e) {
                System.out.println(e.getMessage());
                break;
            }
        }
        return c1.currentHealth > 0 ? c1 : c2;
    }
}
