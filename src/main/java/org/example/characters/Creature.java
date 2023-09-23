package org.example.characters;

import java.util.Random;

public class Creature {
    private int level = 1;
    private int attack; // 1 - 30
    private int protection; // 1 - 30
    protected int tempHealth; // 0 - N
    protected int maxHealth;
    private int[] damage; // N - M
    private boolean isDied = false;

    Random random = new Random();


    private boolean isDied(){
        return isDied;
    }


    private void levelUp(Creature creature){
        if(creature.isDied()) {
            this.level++;
            improveParameters();
        }
    }


    private void improveParameters() {
        this.attack++;
        this.protection++;
        healthChange();
        this.damage = new int[]{damage[0] + 1, damage[1] + 1};
    }


    private void healthChange() {
        double percentTempHealth = (double) tempHealth / maxHealth;
        this.maxHealth += 5;
        this.tempHealth = (int) (this.maxHealth * percentTempHealth);
    }


    public void takingDamage(int[] damage){
        int DamageDealt = random.nextInt(damage[0], damage[1]);

        if(tempHealth > DamageDealt){
            tempHealth -= DamageDealt;
        }else{
            tempHealth = 0;
        }

        System.out.println("Damage taken " + DamageDealt);
        die();
    }


    public void hit(Creature creature){
        int attackModifier = attack - creature.getProtection() + 1;

        for(int i = 0; i < attackModifier; i++){
            if(random.nextInt(7) >= 5 ){
                System.out.println("Successful strike");
                creature.takingDamage(damage);
                levelUp(creature);
                break;
            }
        }
    }


    public void die(){
        if(tempHealth == 0){
            this.isDied = true;
            System.out.println("The creature died");
        }
    }


    public Creature(int attack, int protection, int health, int[] damage) {
        this.attack = attack;
        this.protection = protection;
        this.tempHealth = health;
        this.maxHealth = health;
        this.damage = damage;
    }


    public int getAttack() {
        return attack;
    }


    public void setAttack(int attack) {
        this.attack = attack;
    }


    public int getProtection() {
        return protection;
    }


    public void setProtection(int protection) {
        this.protection = protection;
    }


    public int getTempHealth() {
        return tempHealth;
    }


    public void setTempHealth(int tempHealth) {
        this.tempHealth = tempHealth;
    }


    public int getMaxHealth() {
        return maxHealth;
    }


    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }


    public int getLevel() {
        return level;
    }


    public void setLevel(int level) {
        this.level = level;
    }


    public int[] getDamage() {
        return damage;
    }


    public void setDamage(int[] damage) {
        this.damage = damage;
    }
}
