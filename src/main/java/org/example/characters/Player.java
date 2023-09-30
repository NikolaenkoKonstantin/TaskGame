package org.example.characters;

public class Player extends Creature{
    private int numberOfRemainingHeals = 4;


    public void healYourself(){
        int currentHealth = getCurrentHealth();
        int maxHealth = getMaxHealth();

        if(numberOfRemainingHeals > 0 && currentHealth < maxHealth) {
            int healingOn = (int) (0.3 * maxHealth);

            if (maxHealth - currentHealth < healingOn) {
                setCurrentHealth(maxHealth);
            } else {
                setCurrentHealth(healingOn);
            }

            numberOfRemainingHeals--;
            System.out.println("cured"); // For clarity
        }
    }

    public Player(int attack, int protection, int health, int minDamage, int maxDamage) {
        super(attack, protection, health, minDamage, maxDamage);
    }
}
