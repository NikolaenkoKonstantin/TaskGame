package org.example.characters;

import java.util.Random;

public abstract class Creature {
    private int level = 1;
    private int attack; // 1 - 30
    private int protection; // 1 - 30
    protected int currentHealth; // 0 - N
    protected int maxHealth;
    private int minDamage;
    private int maxDamage;
    private boolean dead = false;

    private final static Random random = new Random();


    private void levelUp() {
        System.out.println("level up"); // For clarity
        this.level++;
        improveParameters();
    }


    private void improveParameters() {
        System.out.println("update parameters"); // For clarity
        this.attack++;
        this.protection++;
        levelUpHealth();
        this.minDamage++;
        this.maxDamage++;
    }


    private void levelUpHealth() {
        System.out.println("health change"); // For clarity
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
        int attackModifier = (attack - creature.getProtection()) > 0
                ? attack - creature.getProtection() + 1 : 1;

        for(int i = 0; i < attackModifier; i++){
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


    public Creature(int attack, int protection, int health, int minDamage, int maxDamage) {
        this.attack = attack;
        this.protection = protection;
        this.currentHealth = health;
        this.maxHealth = health;
        this.minDamage = minDamage;
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


    private boolean isDead(){
        return dead;
    }
}
