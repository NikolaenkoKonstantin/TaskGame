package org.example.characters;

public class Player extends Creature{
    private int numberOfRemainingHeals = 4;


    public void getHealed(){
        if(numberOfRemainingHeals > 0 && tempHealth < maxHealth) {
            int healingOn = (int) (0.3 * maxHealth);

            if (maxHealth - tempHealth < healingOn) {
                tempHealth = maxHealth;
            } else {
                tempHealth += healingOn;
            }

            numberOfRemainingHeals--;
            System.out.println("get healed"); // For clarity
        }
    }

    public Player(int attack, int protection, int health, int[] damage) {
        super(attack, protection, health, damage);
        this.maxHealth = health;
    }
}
