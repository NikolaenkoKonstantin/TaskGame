package org.example.characters;

import java.util.Random;

public class Creature {
    private int attack; // 1 - 30
    private int protection; // 1 - 30
    private int health; // 0 - N
    private final int[] damage; // N - M

    Random random = new Random();


    public void takingDamage(int[] damage){
        int DamageDealt = random.nextInt(damage[0], damage[1]);

        if(health > DamageDealt){
            health -= DamageDealt;
        }else{
            health = 0;
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
                break;
            }
        }
    }

    public void die(){
        if(health == 0){
            System.out.println("The creature died");
        }
    }

    public Creature(int attack, int protection, int health, int[] damage) {
        this.attack = attack;
        this.protection = protection;
        this.health = health;
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

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
