package org.example.characters;

import java.util.Random;

public abstract class Creature {
    private int level = 1;
    private int attack; // 1 - 30
    private int protection; // 1 - 30
    private int currentHealth; // 0 - N
    private int maxHealth;
    private int minDamage;
    private int maxDamage;
    private boolean dead = false;

    private final static Random random = new Random();


    public Creature(int attack, int protection, int health, int minDamage, int maxDamage) {
        this.attack = attack;
        this.protection = protection;
        this.currentHealth = health;
        this.maxHealth = health;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
    }


    public int getMinDamage() {
        return minDamage;
    }

    public void setMinDamage(int minDamage) {
        this.minDamage = minDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public void setMaxDamage(int maxDamage) {
        this.maxDamage = maxDamage;
    }

    public int getAttack() {
        return attack;
    }


    protected void setAttack(int attack) {
        this.attack = attack;
    }


    public int getProtection() {
        return protection;
    }


    protected void setProtection(int protection) {
        this.protection = protection;
    }


    public int getCurrentHealth() {
        return currentHealth;
    }


    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }


    public int getMaxHealth() {
        return maxHealth;
    }


    protected void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }


    public int getLevel() {
        return level;
    }


    public void setLevel(int level) {
        this.level = level;
    }


    public void setDead(boolean dead) {
        this.dead = dead;
    }


    protected boolean isDead(){
        return dead;
    }


    protected void levelUp() {
        System.out.println("Level up"); // For clarity
        this.level++;
        improveParameters();
    }


    protected void improveParameters() {
        System.out.println("Update parameters"); // For clarity
        this.attack++;
        this.protection++;
        levelUpHealth();
        this.minDamage++;
        this.maxDamage++;
    }


    protected void levelUpHealth() {
        System.out.println("Level up health"); // For clarity
        double percentTempHealth = (double) currentHealth / maxHealth;
        this.maxHealth += 5;
        this.currentHealth = (int) (this.maxHealth * percentTempHealth);
    }


    protected void takeDamage(int minDamage, int maxDamage){
        int damageDealt = random.nextInt(minDamage, maxDamage);

        if(currentHealth > damageDealt){
            currentHealth -= damageDealt;
        }else{
            currentHealth = 0;
        }

        System.out.println("Damage taken " + damageDealt); // For clarity

        if(currentHealth == 0){
            die();
            System.out.println("The creature died"); // For clarity
        }
    }


    private int diceRoll(){
        return random.nextInt(7);
    }


    public void hit(Creature creature){
        int numberOfHitAttempts = (attack - creature.getProtection()) > 0
                ? attack - creature.getProtection() + 1 : 1;

        for(int i = 0; i < numberOfHitAttempts; i++){
            if(diceRoll() >= 5 ){
                System.out.println("Successful strike"); // For clarity
                creature.takeDamage(minDamage, maxDamage);

                if(creature.isDead()) {
                    levelUp();
                }
                break;
            }
        }
    }


    protected void die(){
        this.dead = true;
    }
}
